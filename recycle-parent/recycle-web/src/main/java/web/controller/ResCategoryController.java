package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import category.pojo.ResourceCategory;
import category.service.ResCategService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="resCategory")
public class ResCategoryController {

	@Autowired
	private ResCategService resService;
	
	/**
	 * 锟斤拷锟斤拷锟斤拷锟絩esource锟斤拷录
	 * @param json
	 * @return
	 */
	@RequestMapping(value="addResource")
	@ResponseBody
	public JSONObject addResource(@RequestBody JSONObject json){
		try{
			ResourceCategory resource = new ResourceCategory();
			resource.setResourcedescribe(json.getString("resourcedescribe"));
			resource.setResourcename(json.getString("resourcename"));
			resource.setResourcepicture(json.getString("resourcepicture"));
			//注锟斤拷舜锟轿猟ouble锟斤拷锟斤拷
			Double price = Double.parseDouble(json.getString("resourceprice"));
			//锟斤拷锟斤拷前台锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟絩esourceid
			String timestamp = json.getString("timestamp");
			resource.setResourceprice(price);
			resource.setResourceid(timestamp);
			resource.setResourcetype(json.getString("resourcetype"));
			if(resService.addResource(resource) == "success"){
				json.clear();
				json.put("msg", "success");
			}else{
				json.put("msg", "添加失败");
			}
		}catch(Exception e){
			json.put("msg", "error");
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value="/resourceList")
	@ResponseBody
	public JSONArray selectAdminList(){
		List<ResourceCategory> list = this.resService.getAllResource();
		JSONArray arrs = JSONArray.fromObject(list);
		return arrs;
	}
}
