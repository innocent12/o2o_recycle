package web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import category.pojo.ResourceCategory;
import category.pojo.ResourceRecords;
import category.service.ResCategService;
import category.service.ResRecordService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import order.dto.OrderDetail;
import order.pojo.OrderInfo;
import order.service.OrderInfoService;
import order.vo.VisualOrderInfo;
import processor.JsonDateValueProcessor;
import user.dto.UserInfoDto;
import user.dto.UserInfoDto;
import user.pojo.Address;
import user.pojo.Collector;
import user.pojo.Seller;
import user.pojo.SellerAddress;
import user.service.AddressService;
import user.service.CollectorService;
import user.service.SellerAddressService;
import user.service.SellerService;
import web.dto.FontOrder;

/**
 * 
 * @author yangshu
 *
 */
@Controller
@RequestMapping(value="/orderInfo")
public class OrderinfoController {
	@Autowired
	private OrderInfoService orderinfoService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private SellerAddressService saService;
	@Autowired
	private CollectorService collectorService;
	@Autowired
	private SellerAddressService selleraddressService;
	@Autowired
	private ResRecordService resService;
	@Autowired
	private ResCategService resCategService;
	
	private static final Log log = LogFactory.getLog(OrderinfoController.class);
	/**
	 * ��ѯ���ж���
	 * @return arrs
	 */
	@RequestMapping(value = "/orderList")
	@ResponseBody
	public JSONArray selectOrderList() {
		List<OrderInfo> list = orderinfoService.selectAllOrderinfo();
		JsonConfig config = new JsonConfig();  
        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
		JSONArray arrs = JSONArray.fromObject(list,config);
		return arrs;
	}

	/**
	 * ��Ӷ���
	 * @param orderinfo
	 * @return result
	 */
	@RequestMapping(value = "/addOrderinfo")
	@ResponseBody
	public JSONObject AddOrderinfo(String selleraccount, String timestamp) {
		JSONObject result = new JSONObject();
		OrderInfo order = new OrderInfo();
		System.out.println(timestamp+selleraccount);
		//��ʱ�������Ϊorderid
		order.setOrderid(timestamp);
		order.setSelleraccount(selleraccount);
		//
		order = orderinfoService.addOrderinfo(order);
		if(order != null){
			result.put("Msg", "success");
			result.put("orderid", order.getOrderid());
			return result;
		}
		result.put("Msg", "fail");
		return result;
	}

	/**
	 * ����id��ѯ����
	 * @param id
	 * @return order
	 */
	@RequestMapping(value = "/selectOrderinfoByid")
	@ResponseBody
	public JSONObject SelectOrderinfoById(@RequestBody JSONObject json) {
		int id = json.getInt("id");
		OrderInfo orderinfo = orderinfoService.selectOrderinfoById(id);
		JsonConfig config = new JsonConfig();  
        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
		JSONObject order = JSONObject.fromObject(orderinfo,config);
		return order;
	}
	
	/**
	 * TODO 
	 * 订单资源获取简化,
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/getC_OrderDetail")
	@ResponseBody
	public JSONArray getCol_OrderDetailed(@RequestBody JSONObject json){
		JSONArray jsarr = new JSONArray();
		long startTime = System.currentTimeMillis();
		String orderid = json.getString("orderid");
		String addressArea = json.optString("addressArea");
		String seller = json.optString("se_account");
		OrderDetail orderDetail = orderinfoService.getOrderDetailedByVisualOrderInfo(addressArea, seller, orderid);
		json.clear();
		json = JSONObject.fromObject(orderDetail);
		long endTime = System.currentTimeMillis();
		long times = endTime-startTime;
//		json.put("collector", collector+times);
		log.warn("该业务访问数据库两次："+times);
		jsarr.add(json);
		return jsarr;
	}
	
	/**
	 * 
	 * 查询订单详细内容
	 * 说明：1.获取订单的资源货物信息
	 * 2.获取卖家信息、回收员信息
	 * 3.拼接成json数据返回
	 * 
	 * 7个service调用，加一个controller层的list遍历
	 * @param orderid
	 * @return order,seller,collector
	 */
	@RequestMapping(value = "/selectOrderinfoDetailByorderid")
	@ResponseBody
	public JSONObject selectOrderinfoDetailByorderid(@RequestBody JSONObject json) {
		
		long startTime = System.currentTimeMillis();
		
		String orderid = json.getString("orderid");
		OrderInfo order = orderinfoService.selectOrderinfoByOrderid(orderid);
		List<ResourceRecords> recordlist = resService.getRecordsByOrderId(orderid);
		Seller seller = sellerService.getByAccount(order.getSelleraccount());
		SellerAddress selleraddress = selleraddressService.getAddressBySellerAccount(order.getSelleraccount());
		Address address = addressService.getByAddressId(selleraddress.getAddressid());
		Collector collector = collectorService.getCollectorByAccount(order.getCollectoraccount());
		
		
		//日期格式
		JsonConfig config = new JsonConfig();  
        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
        JSONObject orderj = JSONObject.fromObject(order,config);
		orderj.put("sellername", seller.getSellername());
		orderj.put("sellerphone", seller.getSellerphone());
		orderj.put("selleraddressarea", address.getAddressarea());
		orderj.put("selleraddressdetail", address.getAddressdetailed());
		orderj.put("collectorid", collector.getCollectoropenid());
		List<JSONObject> jsonlist = new ArrayList<JSONObject>();
		for(int i = 0; i < recordlist.size(); i++){
			ResourceCategory resCategory = resCategService.getResourceCategoryByResourceId(recordlist.get(i).getResourceid());;
			JSONObject recordj = new JSONObject();
			recordj.put("resource", recordlist.get(i).getResourcename());
			recordj.put("resourcetype", resCategory.getResourcetype());
			recordj.put("resourceamount", recordlist.get(i).getResourceamount());
			jsonlist.add(recordj);
		}
		orderj.put("resources", jsonlist);
		long endTime = System.currentTimeMillis();
		long Time = endTime-startTime;
		System.out.println(endTime - startTime);
		orderj.put("msg","success" +Time );
		return orderj;
	}
	
	/**
	 * ����orderid��ѯ����
	 * ��Ҫ����order
	 * �����������绰
	 * ��ϵ��ַ
	 * @param orderid
	 * @return arrs
	 */
	@RequestMapping(value = "/selectByorderId")
	@ResponseBody
	public JSONObject SelectOrderListByOrderid(@RequestBody JSONObject json) {
		OrderInfo order = new OrderInfo();
		Seller seller = new Seller();
		Address address = new Address();
		JsonConfig config = new JsonConfig();  
        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
		try{
			String orderId = json.getString("orderid");
			if(orderId != ""){
				System.out.println(orderId);
				order = orderinfoService.selectOrderinfoByOrderid(orderId);
				if(order != null){
					String account = order.getSelleraccount();
					seller = sellerService.getByAccount(account);
					SellerAddress seaddress = saService.getAddressBySellerAccount(account);
					address = addressService.getByAddressId(seaddress.getAddressid());
					json.clear();
					json = JSONObject.fromObject(order,config);
					json.put("sellername", seller.getSellername());
					json.put("sellerphone", seller.getSellerphone());
					json.put("selleraddre", address.getAddressarea()+address.getAddressdetailed());
					json.put("msg", "success");
				}else{
					json.put("msg", "fail");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("msg", "error");
		}
		return json;
	}

	/**
	 * �����û��˺Ų�ѯ����
	 * @param selleraccount
	 * @return arrs
	 */
	@RequestMapping(value = "/selectOrderinfoBySelleraccount")
	@ResponseBody
	public JSONArray SelectOrderinfoBySelleraccount(String account) {
		//String selleraccount = json.getString("account");
		List<OrderInfo> list = orderinfoService.selectOrderinfoBySelleraccount(account);
		JsonConfig config = new JsonConfig();  
        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
		JSONArray arrs = JSONArray.fromObject(list,config);
		return arrs;
	}

	/**
	 * 得到回收员负责区域的订单
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/getCo_Orders")
	@ResponseBody
	public JSONArray getOrderListByCo_Account(@RequestBody JSONObject json){
		String account = json.optString("account");
		String addressArea = json.optString("addressArea");
		JSONArray jsarr = new JSONArray();
		try{
			if(account == "" || addressArea == "")
				json.put("msg", "empty param");
			else{
				long startTime = System.currentTimeMillis();
				List<VisualOrderInfo> visualOrderList = orderinfoService.getOrdersByCollectorAndArea(addressArea, account);
				long endTime = System.currentTimeMillis();
				long Time = startTime-endTime;
				json.clear();
				FontOrder fontOrder = new FontOrder();
				jsarr = visualOrderList.size()!=0?JSONArray.fromObject(visualOrderList):jsarr;
				json.put("msg", "success"+Time);
				log.info("fintOrder:"+JSONObject.fromObject(fontOrder));
				jsarr.add(json);
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("msg", "error");
		}
		return jsarr;
	}
	
	/**
	 * TODO
	 * 地址查询有问题
	 * ���ݻ���Ա�˺Ų�ѯ����
	 * @param collectoraccount
	 * @return arrs
	 */
	@RequestMapping(value = "/selectOrderinfoByCollectoraccount")
	@ResponseBody
	public JSONArray SelectOrderinfoByCollectoraccount(@RequestBody JSONObject json) {
		String collectoraccount = json.getString("account");
		//������Ϣ
		List<OrderInfo> list = orderinfoService.selectOrderinfoByCollectoraccount(collectoraccount); 
		Collector collector = collectorService.getCollectorByAccount(collectoraccount); 
		Address address = addressService.getByAddressId(collector.getAddressid());
		JSONArray arrs = new JSONArray();
		for(int i = 0; i < list.size(); i++){
			JSONObject object = JSONObject.fromObject(list.get(i));
			object.put("addressarea", address.getAddressarea());
			object.put("addressdetail", address.getAddressdetailed());
			arrs.add(object);
		}
		System.out.println(arrs);
		return arrs;
	}

	/**
	 * �޸Ķ���
	 * @param orderinfo
	 * @return result
	 */
	@RequestMapping(value = "/modifyOrderinfo")
	@ResponseBody
	public JSONObject ModifyOrderinfo(@RequestBody JSONObject json) {
		OrderInfo orderinfo =(OrderInfo)JSONObject.toBean(json, OrderInfo.class);
		JSONObject result = new JSONObject();
		if(this.orderinfoService.modifyOrderinfo(orderinfo)=="success"){
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
	}
	/**
	 * 取消订单交易
	 * @param id
	 * @return result
	 */
	@RequestMapping(value = "/finishOrder")
	public JSONObject CancelOrder(String orderid) {
		JSONObject json = new JSONObject();
		if(orderid != null){
			OrderInfo order = orderinfoService.selectOrderinfoByOrderid(orderid);
			if(order != null){
				int id =order.getId();
				orderinfoService.cancelOrder(id);		
				json.put("msg", "success");
			}
		}else{
			json.put("msg", "empty");
		}
		return null;
	}
	/**
	 * ����״̬��Ϊ����
	 * @param id
	 * @return result
	 */
	@RequestMapping(value = "/reciveOrder")
	@ResponseBody
	public JSONObject ReciveOrder(@RequestBody JSONObject json) {
		String orderid = json.getString("orderid");
		JSONObject result = new JSONObject();
		OrderInfo orderinfo = new OrderInfo();
		orderinfo.setOrderid(orderid);
		if(orderinfoService.modifyOrderinfo(orderinfo)=="success"){
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
	}
	/**
	 * ����������
	 * @param id
	 * @return result
	 */
	@RequestMapping(value = "/reciveingOrder")
	@ResponseBody
	public JSONObject ReciveingOrder(@RequestBody JSONObject json) {
		int id = json.getInt("id");
		JSONObject result = new JSONObject();
		if(orderinfoService.modifyOrderstate(id)=="success"){
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
	}
	
	/**
	 * ��ɶ���
	 * @param id
	 * @return result
	 */
	@RequestMapping(value = "/completeOrder")
	@ResponseBody
	public JSONObject CompleteOrder(@RequestBody JSONObject json) {
		int id = json.getInt("id");
		JSONObject result = new JSONObject();
		if(orderinfoService.finishOrder(id)=="success"){
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
	}
	
	/**
	 * ����û�����
	 * @param id,sellermessage
	 * @return result
	 */
	@RequestMapping(value = "/addSellermessage")
	@ResponseBody
	public JSONObject AddSellermessage(@RequestBody JSONObject json) {
		int id = Integer.parseInt(json.getString("id"));
		String level = json.getString("level");
		String Message = json.getString("Message");
		OrderInfo order = orderinfoService.selectOrderinfoById(id);
		if(order != null){
			order.setSellerlevel(level);
			order.setSellermessage(Message);
			if(orderinfoService.addSellermessage(Message, level, id)=="success"){
				json.put("msg", "success");
			}else{
				json.put("msg", "fail");
			}
		}
		return json;
		
	}
	
	/**
	 * ajax����û�����
	 * @param json
	 * @return
	 *//*
	@RequestMapping(value = "/addSellermessage")
	@ResponseBody
	public JSONObject addOrderMessage(@RequestBody JSONObject json) {
		String orderId = json.optString("orderId");
		String Message = json.optString("message");
		String level = json.optString("level");
		OrderInfo order = orderinfoService.selectOrderinfoByOrderid(orderId);
		if(order != null){
			order.setSellerlevel(level);
			order.setSellermessage(Message);
			if(orderinfoService.modifyOrderinfo(order)=="success"){
				json.clear();
				json.put("fail", "success");
			}
		}
		return json;
		
	}*/

	/**
	 * ����idɾ������
	 * @param id
	 * @return result
	 */
	@RequestMapping(value="/deleteOrderinfoById")
	@ResponseBody
	public JSONObject DeleteOrderinfoById(@RequestBody JSONObject json){
		int id = json.getInt("id");
		JSONObject result = new JSONObject();
		if(orderinfoService.deleteOrderinfoById(id)=="success"){
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
	}

	/**
	 * ����ɾ������ͨ��id��
	 * @param ids(JSONArray)
	 * @return result
	 */
	@RequestMapping(value="/deleteOrderinfo")
	@ResponseBody
	public JSONObject DeleteOrder(@RequestBody JSONObject json){
		List<Integer> list = new ArrayList<>();
		int temp = 0;
		for(int i = 0;i<json.size();i++){
			temp = json.getJSONObject(i+"").getInt("id");
			list.add(temp);
		}
		if(orderinfoService.deleteOrderinfo(list)=="success"){
			json.clear();
			json.put("msg", "success");
		}
		else{
			json.put("msg", "error");
		}
		return json;
	}	
	
	/**
	 * �õ����пɻ��յĶ���λ��
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/getOrderPosition")
	@ResponseBody
	public JSONArray getOrderPosition(@RequestBody JSONObject json){
		JSONArray jsonArr = new JSONArray();
		try{
			String account = json.getString("collectoraccount");
			//�õ�����Ա�Ŀɻ��յĶ���
			List<OrderInfo> list = orderinfoService.getAviableOrderByCollector(account);
			if(list.size() != 0){
				List<String> accountList = new ArrayList<>();
				//������ȡselleraccount
				for(int i =0;i<list.size();i++){
					accountList.add(list.get(i).getSelleraccount());
				}
				//�ж�accountlist�Ƿ�Ϊ��
				if(accountList.size() ==0){
					json.put("msg", "fail");
				}else{
					//����jsonArr
					jsonArr = sellerService.getPositionByAccount(accountList);
				}
			}
		}catch(Exception e){
			json.put("msg", "error");
			e.printStackTrace();
		}
		return jsonArr;
	}
	
	/**
	 * 根据卖家账号获取
	 * 其钱包收入明细
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/getOrderIncome")
	@ResponseBody
	public JSONArray getOrderIncomeByAccount(String account){
		JSONArray array = new JSONArray();
		try{
			if(account != ""){
				array = orderinfoService.getOrderIncomeBySeller(account);
				if(array.size() == 0){
					array.add("empty");
				}
			}else{
				array.add("fail");
			}
		}catch(Exception e){
			array.add("error");
			e.printStackTrace();
		}
		return array;
	}
}
