package web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import user.pojo.Admin;
import user.service.AdminService;

/**
 * 
 * @author yangshu
 *
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
    private AdminService adminService;
	
	
	/**
	 * ����������������������
	 * @param adminid, adminpassword
	 * @return result
	 * @throws AdminExistException 
	 */
	@RequestMapping(value="/adminLogin")
	@ResponseBody
	public JSONObject AdminLogin(@RequestBody JSONObject json){ 
		String adminid = json.getString("adminid");
		String adminpassword = json.getString("adminpassword");
		JSONObject result = new JSONObject();
		if(adminService.adminLogin(adminid, adminpassword)==1){
			Admin admin = adminService.selectAdminByAdminId(adminid);
			result = JSONObject.fromObject(admin);
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
	}
	/**
	 * ������������������������������
	 * @return arrs
	 */
	@RequestMapping(value="/adminList")
	@ResponseBody
	public JSONArray selectAdminList(){
		List<Admin> list = this.adminService.selectAllAdmin();
		JSONArray arrs = JSONArray.fromObject(list);
		return arrs;
	}
	/**
	 * �������������������
	 * @param Admin
	 * @return result
	 * @throws AdminExistException 
	 */
	@RequestMapping(value="/addAdmin")
	@ResponseBody
		public JSONObject AddAdmin(@RequestBody JSONObject json,MultipartFile adminPicture){
		Admin addadmin =(Admin)JSONObject.toBean(json, Admin.class);
		JSONObject result = new JSONObject();
		/*������������*/
		// ����������������������������������������������������������������������������uuid
		String picName = UUID.randomUUID().toString();
		// ����������������������
		String oriName = adminPicture.getOriginalFilename();
		// ��������������������
		String extName = oriName.substring(oriName.lastIndexOf("."));
		// ����������������
		try {
			adminPicture.transferTo(new File("D://upload//lanou//" + picName + extName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		addadmin.setAdminpicture(picName + extName);
		if(adminService.addAdmin(addadmin) == "success"){
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
	}
	/**
	 * ����������������������id����������������������
	 * @param adminid
	 * @return admin
	 */
	@RequestMapping(value="/selectAdminByAdminid")
	@ResponseBody
	public JSONObject SelectAdminById(@RequestBody JSONObject json){
		String adminid = json.getString("adminid");
		Admin adminbyid = adminService.selectAdminByAdminId(adminid);
		JSONObject admin = JSONObject.fromObject(adminbyid);
		return admin;
	}
	/**
	 * ��������������������������������������������������������
	 * @param adminname
	 * @return arrs
	 */
	@RequestMapping(value="/selectAdminByName")
	@ResponseBody
	public JSONObject SelectAdminByName(@RequestBody JSONObject json){ 
		String adminname = json.getString("adminname");
		List<Admin> list = adminService.selectAdminByName(adminname);
		JSONObject arrs = JSONObject.fromObject(list);
		return arrs;
	}
	/**
	 * ����������������������������������
	 * @param id, newphone
	 * @return result
	 */
	@RequestMapping(value="/editAdminPhone")
	@ResponseBody
	public JSONObject editAdmin(@RequestBody JSONObject json){
		int id = json.getInt("id");
		String adminphone = json.getString("newphone");
		JSONObject result = new JSONObject();
		if(adminService.modifyAdminPhone(id, adminphone)=="success"){
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
	}
	/**
	 * ������������������������������
	 * @param id, newpassword
	 * @return result
	 */
	@RequestMapping(value="/editAdminPassword")
	@ResponseBody
	public JSONObject EditAdminPassword(@RequestBody JSONObject json){
		int id = json.getInt("id");
		String adminpassword = json.getString("newpassword");
		JSONObject result = new JSONObject();
		if(adminService.modifyAdminPassword(id, adminpassword)=="success"){
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
	}
	/**
	 * ������������id����������������������
	 * @param id
	 * @return result
	 */
	@RequestMapping(value="/deleteAdmin")
	@ResponseBody
		public JSONObject DeleteAdminById(@RequestBody JSONObject json){
		int id = json.getInt("id");
		JSONObject result = new JSONObject();
		if(adminService.deleteAdminById(id)=="success"){
			result.put("msg", "success");
		}
		else{
			result.put("msg", "error");
		}
		return result;
		}
	/**
	 * ����������������������������������
	 * @param ids(JSONArray)
	 * @return result
	 */
	@RequestMapping(value="/deleteOrderinfo")
	@ResponseBody
	public JSONObject DeleteAdmin(@RequestBody JSONObject json){
		List<Integer> list = new ArrayList<>();
		int temp = 0;
		for(int i = 0;i<json.size();i++){
			temp = json.getJSONObject(i+"").getInt("id");
			list.add(temp);
		}
		if(adminService.deleteAdmin(list)=="success"){
			json.clear();
			json.put("msg", "success");
		}
		else{
			json.put("msg", "error");
		}
		return json;
	}
}
