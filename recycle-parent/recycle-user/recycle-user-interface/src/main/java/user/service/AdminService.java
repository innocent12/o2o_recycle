package user.service;

import java.util.List;

import user.pojo.Admin;
/**
 * 
 * @author yangshu
 *
 */
public interface AdminService {
	int adminLogin(String adminid, String adminpassword);
	List<Admin> selectAllAdmin();
	String addAdmin(Admin admin) ;
	Admin selectAdminById(int id);
	List<Admin> selectAdminByName(String name);
	Admin selectAdminByAdminId(String adminid);
	String modifyAdminPhone(int id, String phone);
	String modifyAdminPassword(int id, String password);
	String deleteAdminById(int id);
	String deleteAdmin(List<Integer> ids);
}
