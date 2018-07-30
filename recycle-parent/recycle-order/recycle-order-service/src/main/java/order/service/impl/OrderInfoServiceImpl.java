package order.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import order.dao.OrderInfoMapper;
import order.dto.OrderDetail;
import order.pojo.OrderInfo;
import order.pojo.OrderInfoExample;
import order.pojo.OrderInfoExample.Criteria;
import order.service.OrderInfoService;
import order.vo.OrderResource;
import order.vo.VisualOrderInfo;

/**
 * 
 * @author yangshu
 *
 */
@Service("orderinfoServiceImpl")
public class OrderInfoServiceImpl implements OrderInfoService{
	@Autowired
	private OrderInfoMapper orderinfoMapper;
	private static final Log log = LogFactory.getLog(OrderInfoServiceImpl.class);
	
	
	public OrderDetail getOrderDetailedByVisualOrderInfo(String addressArea, String se_account, String orderId){
		OrderDetail orderDetail = new OrderDetail();
		List<VisualOrderInfo> visualOrderInfoList = orderinfoMapper.selectTheOrderByOrderidAndSeller(addressArea, se_account, orderId);;
		List<OrderResource> orderItemList = orderinfoMapper.selectResByOrderId(orderId);
		log.info(orderItemList.size());
		if(visualOrderInfoList.isEmpty() || orderItemList.isEmpty() )
			log.info("没有数据");
		else
			orderDetail.setVisualOrderInfo(visualOrderInfoList.get(0));
			orderDetail.setOrderItemList(orderItemList);
		return orderDetail;
	}
	
	public List<VisualOrderInfo> getOrdersByCollectorAndArea(String addrArea, String collector){
		List<VisualOrderInfo> visualOrderInfoList = orderinfoMapper.selectOrderListByArea(addrArea, collector);
		if(visualOrderInfoList.size() != 0){
//			log.info("orderDetail:"+JSONArray.fromObject(visualOrderInfoList));
			log.info("获取回收员订单 success");
			
		}else{
			log.warn("该回收员没有订单 no orders for the collector");
		}
		return visualOrderInfoList;
	}
	
	public OrderDetail getOrderResByOrderId(String orderid){
		OrderDetail orderDetail = new OrderDetail();
		List<OrderResource> orderItemList = orderinfoMapper.selectResByOrderId(orderid);
		try{
			log.info("123");
			if(orderItemList.size() == 0){
				log.warn("该订单没有货物记录");
				orderDetail.setStatus("fail");
			}else{
				log.info("查询订单 success");
//				log.info(JSONArray.fromObject(orderItemList));
				orderDetail.setOrderId(orderid);
				orderDetail.setOrderItemList(orderItemList);
				orderDetail.setStatus("success");
//				log.info(JSONObject.fromObject(orderDetail));
			}
		}catch(Exception e){
			e.printStackTrace();
			orderDetail.setStatus("error");
			log.info("error");
		}
		return orderDetail;
	}
	
	/**
	 * ����Ա���ܶ���
	 * ����״̬��Ϊ�ѽӵ�
	 * ͬʱ�޸Ķ���״̬
	 */
	@Override
	public String AcceptOrder(int id, String collectorAccount){
		// TODO Auto-generated method stub
		String result = "";
		try{
			if(id != 0 && collectorAccount != ""){
				OrderInfo record = new OrderInfo();
				
				record.setId(id);
				record.setCollectoraccount(collectorAccount);
				record.setOrderstate(2);
				if(orderinfoMapper.updateByPrimaryKeySelective(record) > 0){
					result = "success";
				}
			}
		}catch(Exception e){
			result ="fail";
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ��ȡ�����Ѿ��ӵ��Ķ���
	 * @return
	 */
	@Override
	public List<OrderInfo> getPreRecoveredOrder() {
		// TODO Auto-generated method stub
		List<OrderInfo> orderlist = null;
		try{
			OrderInfoExample orderexample = new OrderInfoExample();
			orderexample.createCriteria().andOrderstateEqualTo(2);
			orderlist = orderinfoMapper.selectByExample(orderexample);
		}catch(Exception e){
			e.printStackTrace();
		}
		return orderlist;
	}
	
	/**
	 * �������붩��ȷ��״̬
	 * ���ض�����Ϣ
	 * @param orderId
	 * @return
	 */
	@Override
	public OrderInfo ConfirmOrder(int id) {
		// TODO Auto-generated method stub
		OrderInfo record = new OrderInfo();
		try{
			//�п�
			if(id != 0){
				record.setId(id);
				record.setOrderstate(3);
				if(orderinfoMapper.updateByPrimaryKeySelective(record) > 0){
					record = orderinfoMapper.selectByPrimaryKey(id);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return record;
	}
	
	/**
	 * ����order������ѯ������Ϣ
	 * @param orderId
	 * @return
	 */
	@Override
	public OrderInfo getDetailedOrderByOrderid(int id) {
		// TODO Auto-generated method stub
		OrderInfo order = new OrderInfo();
		try{
			if(id != 0){
				order = orderinfoMapper.selectByPrimaryKey(id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return order;
	}
	
	/**
	 * ����Ա��ȡ
	 * ������Ҫ�ջ��Ķ���
	 */
	@Override
	public List<OrderInfo> getNotRecveredOrder() {
		// TODO Auto-generated method stub
		List<OrderInfo> orderList = null;
		try{
			OrderInfoExample orderexample = new OrderInfoExample();
			//������������״̬λ��1.2֮���
			orderexample.createCriteria().andOrderstateBetween(1, 2);
			orderList = orderinfoMapper.selectByExample(orderexample);
		}catch(Exception e){
			e.printStackTrace();
		}
		return orderList;
	}
	
	@Override
	public List<OrderInfo> selectAllOrderinfo(){
		List<OrderInfo> list = orderinfoMapper.selectByExample(null);
		return list;
	}
	//锟斤拷锟斤拷锟铰讹拷锟斤拷
	@Override
	public OrderInfo addOrderinfo(order.pojo.OrderInfo orderinfo){
		//锟斤拷锟斤拷状态锟斤拷placetime
		
		order.pojo.OrderInfoExample example = new OrderInfoExample();
		example.createCriteria().andSelleraccountEqualTo(orderinfo.getSelleraccount()).andOrderstateBetween(0, 3);
		List<OrderInfo> list = orderinfoMapper.selectByExample(example);
		if(list.size() == 0){
			orderinfo.setOrderplacetime(new Date());
			orderinfo.setOrderfinishtime(new Date());
			orderinfo.setOrderstate(0);
			orderinfoMapper.insert(orderinfo);
			orderinfo = orderinfoMapper.selectByExample(example).get(0);
		}else{
			orderinfo = list.get(0);
		}
		return orderinfo;
	}
	
	@Override
	public OrderInfo selectOrderinfoById(int id){
		OrderInfo orderinfo = orderinfoMapper.selectByPrimaryKey(id);
		return orderinfo;
	}
	
	@Override
	public  OrderInfo selectOrderinfoByOrderid(String orderid){
		OrderInfoExample example = new OrderInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderidEqualTo(orderid);
		List<OrderInfo> list = orderinfoMapper.selectByExample(example);
		OrderInfo order = list.size() == 1?list.get(0):null;
		return order;
	}
	
	@Override
	public List<OrderInfo> selectOrderinfoBySelleraccount(String selleraccount){
		OrderInfoExample example = new OrderInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andSelleraccountEqualTo(selleraccount);
		List<OrderInfo> list = orderinfoMapper.selectByExample(example);
		return list;
	}
	
	/**
	 * 通锟斤拷锟斤拷锟斤拷员锟剿号得碉拷
	 * 锟斤拷锟斤拷亩锟斤拷锟斤拷锟�
	 */
	@Override
	public List<OrderInfo> selectOrderinfoByCollectoraccount(String collectoraccount){
		OrderInfoExample example = new OrderInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andCollectoraccountEqualTo(collectoraccount);
		List<OrderInfo> list = orderinfoMapper.selectByExample(example);
		return list;
	}
	
	//锟斤拷锟斤拷锟斤拷锟斤拷式锟睫革拷order
	@Override
	public String modifyOrderinfo(OrderInfo orderinfo){
		try{
			OrderInfoExample example = new OrderInfoExample();
			Criteria criteria = example.createCriteria();
			criteria.andOrderstateEqualTo(2);
			if(orderinfoMapper.updateByExampleSelective(orderinfo, example) != 0){
				return "success";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "fail";
	}
	
	/**
	 * 锟睫改讹拷锟斤拷状态
	 */
	@Override
	public String modifyOrderstate(int id){
		OrderInfo orderinfo = new OrderInfo();
		orderinfo.setId(id);
		orderinfo.setOrderstate(orderinfoMapper.selectByPrimaryKey(id).getOrderstate()+1);
		if(orderinfoMapper.updateByPrimaryKeySelective(orderinfo)!=0){
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 根据订单号修改订单状态
	 * @param orderid
	 * @param state
	 * @return
	 */
	public String modifyOrderStateByOrderId(String orderid, int state){
		OrderInfo orderinfo = new OrderInfo();
		//orderinfo.setOrderid(orderid);
		orderinfo.setOrderstate(state);
		OrderInfoExample example = new OrderInfoExample();
		example.createCriteria().andOrderidEqualTo(orderid);
		orderinfoMapper.updateByExampleSelective(orderinfo, example);
		return "";
	}
	
	@Override
	public String finishOrder(int id){
		OrderInfo orderinfo = new OrderInfo();
		orderinfo.setId(id);
		orderinfo.setOrderfinishtime(new Date());
		orderinfo.setOrderstate(4);
		if(orderinfoMapper.updateByPrimaryKeySelective(orderinfo)!=0){
			return "success";
		}
		return "fail";
	}
	@Override
	public String cancelOrder(int id){
		OrderInfo orderinfo = new OrderInfo();
		orderinfo.setId(id);
		orderinfo.setOrderstate(0);
		if(orderinfoMapper.updateByPrimaryKeySelective(orderinfo)!=0){
			return "success";
		}
		return "fail";
	}
	
	@Override
	public String addSellermessage(String sellermessage, String level, int id){
		OrderInfo orderinfo = new OrderInfo();
		orderinfo.setSellermessage(sellermessage);
		orderinfo.setSellerlevel(level);
		orderinfo.setId(id);
		if(orderinfoMapper.updateByPrimaryKeySelective(orderinfo)!=0){
			return "success";
		}
		return "fail";
	}
	
	@Override
	public String deleteOrderinfoById(int id){
		if(orderinfoMapper.deleteByPrimaryKey(id)!=0){
			return "success";
		}
		return "fail";
	}
	
	@Override
	public String deleteOrderinfo(List<Integer> ids){
		for(int i=0; i<ids.size();i++){
			if(orderinfoMapper.deleteByPrimaryKey(ids.get(i))==0)
			return "fail";
		}
		return "success";
	}
	
	//锟矫碉拷锟斤拷锟揭伙拷没锟斤拷傻亩锟斤拷锟�
	@Override
	public OrderInfo getUnfinishedOrderBySellerAccount(String selleraccount) {
		OrderInfo order = new OrderInfo();
		try{
			OrderInfoExample example = new OrderInfoExample();
			Criteria criteria = example.createCriteria();
			criteria.andSelleraccountEqualTo(selleraccount);
			criteria.andOrderstateBetween(1, 3);
			List<OrderInfo> list = orderinfoMapper.selectByExample(example);
			if(list.size() != 0){
				order = list.get(0);
			}else{
				order = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return order;
	}
	
	/**
	 * 锟斤拷锟斤拷员锟矫碉拷锟斤拷锟斤拷锟斤拷取锟侥讹拷锟斤拷位锟斤拷
	 * 锟斤拷锟斤拷锟斤拷锟窖撅拷锟斤拷取锟斤拷锟斤拷史锟斤拷锟斤拷位锟斤拷
	 * @param sellectoraccount
	 * @return
	 */
	@Override
	public List<OrderInfo> getAviableOrderByCollector(String account) {
		List<OrderInfo> list = new ArrayList<>();
		try{
			OrderInfoExample example = new OrderInfoExample();
			Criteria criteria = example.createCriteria();
			criteria.andCollectoraccountEqualTo(account);
			criteria.andOrderstateBetween(1, 3);
			list = orderinfoMapper.selectByExample(example);
			
		}catch(Exception e){
			list = null;
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 获取指定订单的货款交易记录
	 * @param account
	 * @return
	 */
	@Override
	public JSONArray getOrderIncomeBySeller(String account) {
		JSONArray jsArr = new JSONArray();
		try{
			OrderInfoExample example = new OrderInfoExample();
			if(account != ""){
				example.createCriteria().andSelleraccountEqualTo(account).andOrderstateEqualTo(4);
				//订单状态条件为已经完成
				List<OrderInfo> list = orderinfoMapper.selectByExample(example);
				if(list.size()!=0){
					//取出相应的收入明细
					for(int i=0;i<list.size();i++){
						JSONObject json = new JSONObject();
						json.put("orderId", list.get(i).getOrderid());
						json.put("orderAmount", list.get(i).getOrderamount());
						//SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
						SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						json.put("finishTime", sdf2.format(list.get(i).getOrderfinishtime()));
						json.put("id", list.get(i).getId());
						jsArr.add(json);
					}
				}
			}else{
				jsArr = null;
			}
			
		}catch(Exception e){
			jsArr = null;
			e.printStackTrace();
		}
		return jsArr;
	}
	
	
}
