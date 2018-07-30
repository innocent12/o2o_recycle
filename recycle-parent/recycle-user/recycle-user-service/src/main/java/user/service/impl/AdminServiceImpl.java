package user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.dao.AdminMapper;
import user.pojo.Admin;
import user.pojo.AdminExample;
import user.service.AdminService;

/**
 * 
 * @author yangshu
 *
 */
@Service("adminServiceImpl")
@Component
public class AdminServiceImpl implements AdminService{
	
	@Autowired()
	private AdminMapper adminmapper; 
	
	@Override
	public int adminLogin(String adminid, String adminpassword){
		int ok = 0;
		if(isAdminExist(adminid)==false){
			System.out.println("不存在");
		}
		else{
			AdminExample example = new AdminExample();
			example.createCriteria().andAdminidEqualTo(adminid);
			List<Admin> list = adminmapper.selectByExample(example);
				Admin admin = list.get(0);
				if(admin.getAdminpassword().equals(adminpassword)){
					ok = 1;
				}
				else{
					System.out.println("不匹配");
			}
		}
		return ok;
	}
	
	@Override
	public List<Admin> selectAllAdmin(){
		List<Admin> list = adminmapper.selectByExample(null);
		return list;
	}
	
	@Override
	public String addAdmin(Admin admin){
		boolean ok;
		ok = isAdminExist(admin.getAdminid());
		if(ok==true){
			return "�û��Ѵ���";
		}
		if(adminmapper.insert(admin)!=0){
			return "success";
		}
		return "fail";
	}
	
	@Override
	public Admin selectAdminById(int id){
		Admin admin = adminmapper.selectByPrimaryKey(id);
		return admin;
	}
	
	@Override
	public List<Admin> selectAdminByName(String name){
		AdminExample example = new AdminExample();
		example.createCriteria().andAdminnameEqualTo(name);
		List<Admin> list = new ArrayList<Admin>();
		if(StringUtils.isNoneBlank(name)){
			name = "%" +name + "%";
		}
		if(StringUtils.isNotBlank(name)){ 
			example.clear();
			example.createCriteria().andAdminnameLike(name);
		    list = adminmapper.selectByExample(example);
		} 
		return list;
	}
	
	@Override
	public Admin selectAdminByAdminId(String adminid){
		AdminExample example = new AdminExample();
		example.createCriteria().andAdminidEqualTo(adminid);
		List<Admin> list = adminmapper.selectByExample(example);
		return list.get(0);
	}
	
	@Override
	public String modifyAdminPhone(int id, String phone){
		Admin record = new Admin();
		record.setId(id);
		record.setAdminphone(phone);
		if(adminmapper.updateByPrimaryKeySelective(record)!=0){
			return "success";
		}
		return "fail";
	}
	
	@Override
	public String modifyAdminPassword(int id, String password){
		Admin record = new Admin();
		record.setId(id);
		record.setAdminpassword(password);
		if(adminmapper.updateByPrimaryKeySelective(record)!=0){
			return "success";
		}
		return "fail";
	}
	
	@Override
	public String deleteAdminById(int id){
		if(adminmapper.deleteByPrimaryKey(id)!=0){
			return "success";
		}
		return "fail";
	}
	
	@Override
	public String deleteAdmin(List<Integer> ids){
		for(int i=0; i<ids.size();i++){
			if(adminmapper.deleteByPrimaryKey(ids.get(i))==0){
				return "fail";
			}
		}
		return "success";
	}
	
	public boolean isAdminExist(String id){
		AdminExample example = new AdminExample();
		example.createCriteria().andAdminidEqualTo(id);
		List<Admin> list = adminmapper.selectByExample(example);
		if(list.size()==0){
			return false;
		}
		else{
			return true;
		}
		
	}
}
