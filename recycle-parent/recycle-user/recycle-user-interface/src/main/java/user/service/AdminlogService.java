package user.service;

import java.util.List;

import user.pojo.Adminlog;

/**
 * 
 * @author yangshu
 *
 */
public interface AdminlogService {
	List<Adminlog> selectAllAdminlog();
	String addAdminlog(Adminlog adminlog);
	List<Adminlog> selectAdminlogByAdminId(String adminid);
}
