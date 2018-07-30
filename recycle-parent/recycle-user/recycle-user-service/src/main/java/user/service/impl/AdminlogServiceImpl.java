package user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.dao.AdminlogMapper;
import user.pojo.Adminlog;
import user.pojo.AdminlogExample;
import user.service.AdminlogService;

/**
 * 
 * @author yangshu
 *
 */
@Service("adminlogServiceImpl")
@Component
public class AdminlogServiceImpl implements AdminlogService{
	@Autowired()
	private AdminlogMapper adminlogmapper; 
	
	@Override
	public List<Adminlog> selectAllAdminlog(){
		List<Adminlog> list = adminlogmapper.selectByExample(null);
		return list;
	}
	
	@Override
	public String addAdminlog(Adminlog adminlog){
		adminlog.setAdminoperationtime(new Date());
		if(adminlogmapper.insert(adminlog)!=0){
			return "success";
		}
		return "fail";
	}
	
	
	@Override
	public List<Adminlog> selectAdminlogByAdminId(String adminid){
		AdminlogExample example = new AdminlogExample();
		example.createCriteria().andAdminidEqualTo(adminid);
		List<Adminlog> list = adminlogmapper.selectByExample(example);
		return list;
	}
	
}
