package web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import processor.JsonDateValueProcessor;
import user.pojo.Address;
import user.pojo.Collector;
import user.service.AddressService;
import user.service.CollectorService;
import util.WeiXinUtil;

@Controller
@RequestMapping(value = "/collector")
public class CollectorController {
	
	@Autowired
	private CollectorService collectorservice;
	@Autowired
	private AddressService addressService;
	

	
	
	@RequestMapping(value="/getCollectorByCollectorAccount")
	@ResponseBody
	public JSONObject getSellerById(@RequestBody JSONObject json){
		String account = json.getString("collectoraccount");
		Collector collector = collectorservice.getCollectorByAccount(account);
		collector.setCollectorpassword("");
		JsonConfig config = new JsonConfig();  
        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
		JSONObject collectorj = JSONObject.fromObject(collector,config);
		return collectorj;		
	}
	/**
	 * 锟斤拷锟铰伙拷锟斤拷员锟界话锟斤拷
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/updateCollectorPhone")
	@ResponseBody
	public JSONObject updateCollectorPhone(@RequestBody JSONObject json){
		try{
			int id = json.getInt("id");
			String phone = json.getString("phone");
			System.out.println(id+phone);
			json.clear();
			if(collectorservice.setPhoneById(phone, id) == "success"){
				json.put("Msg", "success");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("Msg", "fail");
		}
		return json;
	}

	/**
	 * 锟睫改伙拷锟斤拷员锟斤拷锟斤拷
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/updatePWD")
	@ResponseBody
	public JSONObject updateCollectorPWD(@RequestBody JSONObject json){
		try{
			String oldpassword = json.getString("oldpassword");
			String newpassword = json.getString("newpassword");
			int id = json.getInt("id");
			if(oldpassword != "" && newpassword!= "" && id != 0){
				String str = collectorservice.changePasswordById(oldpassword, newpassword, id);
				if(str == "success"){
					json.clear();
					json.put("msg", "success");
				}else{
					json.put("msg", "update fail");
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
	
	@RequestMapping(value="/validCollector")
	@ResponseBody
	public JSONObject validCo_Login(@RequestBody JSONObject json){
		String account = json.optString("account");
		String password = json.optString("password");
		String code = json.optString("code");
		if(account == "" || password == "" || code == ""){
			json.put("msg", "empty param");
		}else{
			WeiXinUtil wxUtil = new WeiXinUtil();
			String openid = wxUtil.getAccessToken(code).getOpenid();
			Collector collector = collectorservice.validLogin(account, password, openid);
			json = JSONObject.fromObject(collector);
			json.put("msg", "success");
		}
		return  json;
	}
	
	@RequestMapping(value="/getCo_Address")
	@ResponseBody
	public JSONObject getCo_Address(String addressId){
		JSONObject json = new JSONObject();
		Address address = new Address();
		if(addressId == "")
			json.put("msg", "empty param");
		else{
			address = addressService.getByAddressId(addressId);
			json = JSONObject.fromObject(address);
			json.put("msg", "success");
		}
		return json;
	}
	
	/**
	 * 锟斤拷锟斤拷员锟斤拷锟斤拷锟剿猴拷锟斤拷锟斤拷锟铰� 
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/collectorLogin")
	@ResponseBody
	public JSONObject getInfoByAccountAndPWD(@RequestBody JSONObject json){
		Collector collector = new Collector();
		WeiXinUtil wxUtil = new WeiXinUtil();
		try{
			String account = json.getString("account");
			String password = json.getString("password");
			//验证是否有code,有则用code换取openid
			String code = json.optString("code");
			String openid = wxUtil.getAccessToken(code).getOpenid();
			if(account != null && password != null){
				collector = collectorservice.validLogin(account, password, openid);
				if(collector != null){
					Address address = addressService.getByAddressId(collector.getAddressid());
					String collectorarea = address.getAddressarea();
					json.clear();
					json = JSONObject.fromObject(collector);
					json.put("collectoraddressarea", collectorarea);
					json.put("msg", "success");
				}else{
					json.put("msg", "账号或密码错误");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("msg", "fail");
		}
		return json;
	}
	
	/**
	 * 锟斤拷锟斤拷员注锟斤拷
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/register")
	@ResponseBody
	public JSONObject registerCollector(@RequestBody JSONObject json){
		try{
			String name = json.getString("collectorname");
			String password = json.getString("collectorpassword");
			String phone = json.getString("phone");
			Collector collector = new Collector();
			collector.setCollectorname(name);
			collector.setCollectorpassword(password);
			collector.setCollectorphone(phone);
			if(collectorservice.addCollector(collector)=="success"){
				json.put("msg", "success");
			}else{
				json.put("msg", "fail");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("msg", "error");
		}
		return json;
	}
	
	/**
	 * 锟斤拷锟斤拷id锟斤拷锟斤拷锟斤拷删锟斤拷锟斤拷锟斤拷员
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/deleteByList")
	@ResponseBody
	public JSONObject deleteByIdList(@RequestBody JSONObject json){
		try{
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<json.size();i++){
				int temp = json.getJSONObject(1+"").getInt("id");
				list.add(temp);
			}
			if(collectorservice.deleteBatchCollector(list)=="success"){
				json.clear();
				json.put("msg", "success");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("msg", "error");
		}
		return json;
	}
	
	/**
	 * 锟斤拷锟斤拷删锟斤拷锟斤拷锟斤拷员
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/deleteCollector")
	@ResponseBody
	public JSONObject deleteCollector(@RequestBody JSONObject json){
		try{
			int id = json.optInt("id");
			if(collectorservice.deleteCollecotrById(id)=="success"){
				json.put("msg", "success");
			}else{
				json.put("msg", "fail");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("msg", "error");
		}
		return json;
	}
	
}
