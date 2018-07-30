package web.controller;

import java.util.ArrayList;
import java.util.List;

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
import order.service.OrderInfoService;

@Controller
@RequestMapping(value="record")
public class ResRecordController {
	
	@Autowired
	private ResRecordService recordService;
	
	@Autowired
	private ResCategService cateService;
	
	@Autowired
	private OrderInfoService orderService;
	
	/**
	 * �����Դ��¼
	 * @param json
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value="addRecord")
	@ResponseBody
	public JSONObject addRecordforSeller(String array, String orderid){
		JSONObject result = new JSONObject();
		try{
			JSONArray json = JSONArray.fromObject(array);
			List<ResourceRecords> recordlist = new ArrayList<>();
			//����jsonlist�б�
			
			String name = "";
			String type="";
			ResourceCategory resource = new ResourceCategory();
			//��ǰ̨���ݷ�װ��resourcerecordlist��
			System.out.println(222);
			for(int i=0;i< json.size();i++){
				result = json.getJSONObject(i);
				ResourceRecords record = new ResourceRecords();
				record.setOrderid(orderid);
				name = result.getString("resourceName");
				type = result.getString("resourceType");
				resource = cateService.getResourceByNameAndType(name, type);
				if(resource != null){
					record.setResourceid(resource.getResourceid());
					record.setResourceamount(Double.parseDouble(result.getString("resourceValue")));
					record.setResourcename(name);
					recordlist.add(record);
				}else{
					result.put("msg", "fail");
				}
				
			}
			//ִ��service����
			if(recordService.addManyRecords(recordlist) == "success"){
				orderService.modifyOrderStateByOrderId(orderid, 1);
				result.clear();
				result.put("msg", "success");
			}else{
				result.put("msg", "fail");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			result.put("msg", "fail");
		}
		return result;
	}
	
	
	/**
	 * ��ѯ������������Դ��¼
	 * ͨ��orderid
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/getOrderResource")
	@ResponseBody
	public JSONObject getRecordsByorderId(@RequestBody JSONObject json){
		try{
			String orderId = json.optString("orderid");
			if(orderId != ""){
				List<ResourceRecords> list =  recordService.getRecordsByOrderId(orderId);
				if(!list.isEmpty()){
					json.clear();
					json = JSONObject.fromObject(list);
					json.put("msg", "success");
				}else{
					json.put("msg", "fail");
				}
			}else{
				json.put("msg", "empty params");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("msg", "error");
		}
		return json;
	}
	
	/**
	 * ɾ��ָ�������ŵ�һ����Դ��¼
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/dropOrderResource")
	@ResponseBody
	public JSONObject deleteRecordsByOrderId(@RequestBody JSONObject json){
		try{
			if(json.optString("orderid")!="" && json.optString("resourceid") != ""){
				String str = recordService.deleteRecord(json.getString("orderid"), json.getString("resourceid"));
				if(str == "success"){
					json.clear();
					json.put("msg", "success");
				}
			}
		}catch(Exception e){
			json.put("msg", "error");
			e.printStackTrace();
		}
		
		return json;
	}
}
