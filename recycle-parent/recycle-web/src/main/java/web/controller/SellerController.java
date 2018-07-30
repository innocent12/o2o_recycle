package web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import exception.SellerExistsException;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import processor.JsonDateValueProcessor;
import user.pojo.Address;
import user.pojo.Seller;
import user.pojo.SellerAddress;
import user.service.AddressService;
import user.service.SellerAddressService;
import user.service.SellerService;
import util.WeiXinUtil;

/**
 * seller
 * @author JCX
 *
 */

@Controller
@RequestMapping(value="/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService; 
	
	@Autowired
	private SellerAddressService saService;
	
	@Autowired
	private AddressService addressService;
	
	private static final Log log = LogFactory.getLog(SellerController.class);
	
	@RequestMapping(value="/sellerInfo")
	@ResponseBody
	public JSONObject sellerInfo(String account){
		JSONObject json = new JSONObject();
		if(account == "" || account == null)
			json.put("msg", "fail");
		else
			json = JSONObject.fromObject(sellerService.getSellerAllInfoByAccount(account));
		return json;
	}
	
/*	public JSONObject validSellerLogin(@RequestBody JSONObject json){
		String account = json.optString("account");
		String password = json.optString("password");
		String code = json.optString("code");
		if(code == "" || account == "" ||password == ""){
			json.put("msg", "empty param");
		}else{
			WeiXinUtil wxUtil = new WeiXinUtil();
			String openid = wxUtil.getAccessToken(json.optString("code")).getOpenid();
			Seller seller = sellerService.getByAccountAndPasswd(account, password, openid);
			
		}
		
		return json;
	}*/
	
	/**
	 * 用户用account和password来登录
	 * @param Session 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/sellerLogin")
	@ResponseBody
	public JSONObject sellerLogin(@RequestBody JSONObject input){
		Seller seller = new Seller();
		WeiXinUtil wxUtil = new WeiXinUtil();
		try{
			String account = input.getString("account");
			String password = input.getString("password");
			System.out.println(input);
			//根据code换取openid
			String openid = wxUtil.getAccessToken(input.optString("code")).getOpenid();
			//String openid = "orFlX05MZQKLZVIpSU1Tk866ob7A";
			seller = sellerService.getByAccountAndPasswd(account, password, openid);
			SellerAddress sellerAddress = saService.getAddressBySellerAccount(account);
			String area = "";
			String detail = "";
			if(sellerAddress != null){
				String addressid = sellerAddress.getAddressid();
				Address address =  addressService.getByAddressId(addressid);
				area = address.getAddressarea();
				detail = address.getAddressdetailed();
			}
			if(seller != null){
				input.clear();
				input = JSONObject.fromObject(seller);
				input.put("selleraddressarea", area);
				input.put("selleraddressdetail", detail);
				input.put("msg", "success");
				log.info("input:"+input);
			}else{
				input.put("msg", "fail");
				log.info("seller"+JSONObject.fromObject(seller));
			}
		}catch(Exception e){
			e.printStackTrace();
			input.put("msg", "error"+e);
		}
		return input;
	}
	
	
	/**
	 * 根据页面保存的id来修改密码
	 * @param id
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/updatePassword")
	@ResponseBody
	public JSONObject updatePassword(@RequestBody JSONObject input) {	
		String oldpassword = input.getString("oldpassword");
		String newpassword = input.getString("newpassword");
		Integer id = Integer.parseInt(input.getString("id"));
		Seller seller = sellerService.getSellerById(id);
		input.put("msg", "error");
		if(newpassword != "" && seller.getSellerpassword().equalsIgnoreCase(oldpassword)){
			seller.setSellerpassword(newpassword);
			sellerService.updateSellerBySelect(seller);
			input.put("msg", "success");
			
		}	
		return input;		
	}
	
	/**
	 * 根据页面保存的id修改name
	 * @param id
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/updateName")
	@ResponseBody
	public JSONObject updateName(@RequestBody JSONObject input) {
		String name = input.getString("sellername");
		Integer id = Integer.parseInt(input.getString("id"));		
		Seller seller = sellerService.getSellerById(id);
		input.put("msg", "error");
		if(name != null){
			seller.setSellername(name);
			sellerService.updateSellerBySelect(seller);
			input.put("msg", "success");
		} 
		return input;		
	}
	
	/**
	 * 根据页面保存的id修改phone
	 * @param id
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/updatePhone")
	@ResponseBody
	public JSONObject updatePhone(@RequestBody JSONObject input) {
		String phone = input.optString("sellerphone");
		Integer id = Integer.parseInt(input.optString("id"));
		Seller seller = sellerService.getSellerById(id);
		if(phone != null){
			seller.setSellerphone(phone);
			sellerService.updateSellerBySelect(seller);
			input.put("msg", "success");
		}else{
			input.put("msg", "error");
		}
		return input;		
	}
	
	
	/**
	 * 添加城市居民用户
	 * 
	 * @param records  从前台获取的json格式的用户信息
	 * @param request
	 * @param response
	 * @return
	 * @throws SellerExistsException
	 */
	@RequestMapping(value="/addseller")
	@ResponseBody
	public JSONObject addSe(@RequestBody JSONObject records){
		try{
			Seller seller = new Seller();
			if(records.toString() != ""){
				seller.setSellername(records.getString("name"));
				seller.setSellerpassword(records.getString("pwd"));
				seller.setSellerphone(records.getString("phone"));
				seller.setSellerlevel("0");
				if(sellerService.insertSeller(seller) == "exits"){
					records.put("msg", "电话号已经被注册");
				}else{
					records.put("msg", "success");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			records.put("msg", "fail");
		}
		return records;
	}
	
	/**
	 * 这是后台显示所有seller的入口 是一个页面的跳转 以分页的形式显示
	 * @param currentPage 表示当前的页面值,设置它的值为1，表示页面是从第一页开始显示的
	 * @param model
	 * @return
	 */
	 @RequestMapping("/main")
	    public String  main(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model){
	        model.addAttribute("pagemsg", sellerService.findByPage(currentPage));//���Է�ҳ����
	        return "main";
	    }
		
	/**
	 * 显示所有的seller
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/showSellerList")
	@ResponseBody
	public JSONObject showSellerList(@RequestBody JSONObject json){
		try{
			List<Seller> sellerList = sellerService.showSellerList();
			JsonConfig config = new JsonConfig();  
	        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
	        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
			if(sellerList .size() != 0){
				json = JSONObject.fromObject(sellerList,config);
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
	 * 根据ID来删除seller
	 * @param id
	 * @return void
	 */
	@RequestMapping(value="/deleteSeller", method=RequestMethod.GET)
	@ResponseBody
	public JSONObject deleteSeller(@RequestBody JSONObject input){
		try{
			int id = input.getInt("id");
			sellerService.deleteSeller(id);
			input.put("msg", "success");
		}catch(Exception e){
			e.printStackTrace();
			input.put("msg", "error");
		}
		return input;		
	}
	/**
	 * 批量删除 
	 * @param ids  存储前台选择的id，是一个list
	 * @param model
	 * @param request
	 * @param response
	 * @return void
	 */
	@RequestMapping(value="/deleteSellerByBatch")
	@ResponseBody
	public JSONObject deleteSellerByBatch(@RequestBody JSONObject input){
		try{
			List<Integer> ids = new ArrayList<>();
			for(int i=0; i<input.size(); i++){
				Integer id = Integer.parseInt(input.getJSONObject(i+"").getString("id"));
				ids.add(id);
				
			}
			sellerService.deleteBatch(ids);
			input.put("msg", "success");
		}catch(Exception e){
			e.printStackTrace();
			input.put("msg", "error");
		}
		return input;		
	}
	
	 
	@RequestMapping(value="/getSellerByOpenId")
	@ResponseBody
	public JSONObject getSellerById(@RequestBody JSONObject json){
		String openid = json.getString("selleropenid");
		Seller seller = sellerService.getByOpenid(openid);
		seller.setSellerpassword("");
		JsonConfig config = new JsonConfig();  
        JsonDateValueProcessor jsonValueProcessor = new JsonDateValueProcessor();  
        config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
		JSONObject sellerj = JSONObject.fromObject(seller,config);
		return sellerj;		
	}
	
	/**
	 * 根据ID来查询seller 并且返回一个seller ,这里可能还有修改
	 * @param id
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value="/edit")
	@ResponseBody
	public Seller getSellerById(Integer id, ModelMap model){
		Seller seller = sellerService.getSellerById(id);
		model.addAttribute("seller", seller);
		return seller;		
	}*/
	
	/**
	 * 根据name模糊查询
	 * @param nameValue 表示输入的值
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getSellerByNameLike")
	@ResponseBody
	public JSONObject getSellerByNameLike(@RequestBody JSONObject input){
		String namelike = input.getString("namelike");
		List<Seller> sellerList = sellerService.getSellerByNameLike(namelike);
		input.put("list", sellerList);
		return input;		
	}
	
	
	
}
