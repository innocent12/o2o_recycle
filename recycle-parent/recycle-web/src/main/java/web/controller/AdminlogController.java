package web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import processor.JsonDateValueProcessor;
import user.pojo.Adminlog;
import user.service.AdminlogService;

/**
 * 
 * @author yangshu
 *
 */
@Controller
@RequestMapping(value="/adminLog")
public class AdminlogController {
	@Autowired
	private AdminlogService adminlogService;

	/**
	 * ��ѯ���й���Ա��־
	 * @return arrs
	 */
	@RequestMapping(value = "/adminlogList")
	@ResponseBody
	public JSONArray selectAdminList(@RequestBody JSONObject json) {
		List<Adminlog> list = this.adminlogService.selectAllAdminlog();
		JsonConfig config = new JsonConfig();  
        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
		JSONArray arrs = JSONArray.fromObject(list,config);
		return arrs;
	}

	/**
	 * ��ӹ���Ա��־
	 * @param Adminlog
	 * @return result
	 */
	@RequestMapping(value = "/addAdminlog")
	@ResponseBody
	public JSONObject AddAdminlog(@RequestBody JSONObject json) {
		Adminlog addadminlog =(Adminlog)JSONObject.toBean(json, Adminlog.class);
		JSONObject result = new JSONObject();
		if(adminlogService.addAdminlog(addadminlog)=="success"){
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
	}

	/**
	 * ������Աid��ѯ����Ա��־
	 * @param adminid
	 * @return arrs(list)
	 */
	@RequestMapping(value = "/selectAdminlogById")
	@ResponseBody
	public JSONObject SelectAdminlogById(@RequestBody JSONObject json) {
		String id =  json.getString("adminid");
		List<Adminlog> list = adminlogService.selectAdminlogByAdminId(id);
		JsonConfig config = new JsonConfig();  
        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
		JSONObject arrs = JSONObject.fromObject(list,config);
		return arrs;
	}
}
