package user.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.PageBean;
import user.dao.SellerMapper;
import user.dto.UserInfoDto;
import user.pojo.Seller;
import user.pojo.SellerExample;
import user.service.SellerService;
import user.vo.NormalSellerInfo;
import user.vo.SellerDetailedInfo;

/**
 * seller�Ĺ���
 * @author JCX
 *
 */

@Service("sellerServiceImpl")
@Component
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerMapper sellerMapper;

	private static final Log log = LogFactory.getLog(SellerServiceImpl.class);
	
	public SellerDetailedInfo getSellerAllInfoByAccount(String account){
		SellerDetailedInfo sellerDetailedInfo = new SellerDetailedInfo();
		sellerMapper.selectDetailedInfoByAccount(account);
		return sellerDetailedInfo;
	}
	
	/**
	 * TODO
	 * 
	 * @param addressArea
	 * @return
	 */
	public List<UserInfoDto> getAreaSellersByCollectorArea(String addressArea){
		List<UserInfoDto> userInfoDtoList = new ArrayList<>();
		UserInfoDto userInfoDto = new UserInfoDto();
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userInfoDtoList;
	}
	
	/**
	 * 
	 */
	public UserInfoDto getNormalSeller_AddressByAccount(String sellerAccount){
		UserInfoDto sellerDto = new UserInfoDto(); 
		System.out.println("开始");
		List<NormalSellerInfo> normalSellerList = sellerMapper.selectNormalInfoByAccount(sellerAccount);
		try{
			if(normalSellerList.size() == 0){
				 log.warn("该用户信息未完善，地址可能为空");
				 sellerDto.setStatus("fail");
			 }else{
				 log.info("查询 success");
				 sellerDto.setNormalInfo(normalSellerList.get(0));
				 sellerDto.setStatus("success");
			 }
		}catch(Exception e){
			sellerDto.setStatus("error");
			log.error("");
			e.printStackTrace();
		}
		
		 return sellerDto;
	}
	
	/* �����û������˺��Ƿ����*/
	
	@Override
	public boolean checkSellerByName(String sellerName){
		SellerExample example = new SellerExample();
		example.createCriteria().andSellernameEqualTo(sellerName);
		int count = sellerMapper.countByExample(example);
		return count == 0;		
	}
	 /* �����˺��Ƿ����*/
	 public int checkSellerByAccount(String sellerAccount){
		 SellerExample example = new SellerExample();
		 example.createCriteria().andSelleraccountEqualTo(sellerAccount);
		 return sellerMapper.countByExample(example);	
	 }

	 /*根据卖家的账号密码获取用户信息*/
	 public Seller getByAccountAndPasswd(String sellerAccount, String sellerPassword, String openid){
		 Seller seller = new Seller();
		 try{
			 System.out.println(sellerAccount+sellerPassword+openid);
			 if(sellerAccount != "" && sellerPassword != ""){
				 SellerExample example = new SellerExample();
				 SellerExample.Criteria criteria = example.createCriteria();
				 criteria.andSelleraccountEqualTo(sellerAccount);
				 criteria.andSellerpasswordEqualTo(sellerPassword);
				 //sellerMapper.se
				 List<Seller> lists = sellerMapper.selectByExample(example);
				 if(lists.size() != 0){
					 
					 Seller record = lists.get(0);
					 seller.setSelleropenid(openid);
					 //更新主键
					 example.createCriteria().andIdEqualTo(record.getId());
					 if(sellerMapper.updateByExampleSelective(seller, example) == 1){
						record.setSelleropenid(openid);
						seller = record;
					 }
					 
				 }else{
					 seller = null;
				 }
			 }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return seller;
	 }
	 
	 /*根据openid获取用户信息*/
	 public Seller getByOpenid(String sellerOpenid){
		 Seller seller = null;
		 try{
			 SellerExample example = new SellerExample();
			 example.createCriteria().andSelleropenidEqualTo(sellerOpenid);
			 List<Seller> list = sellerMapper.selectByExample(example);
			 if(list.size() != 0){
				 seller = list.get(0);
			 }
		 }catch(Exception e){
			 e.printStackTrace();
			 seller = null;
		 }
		 return seller;
	 }
	
	 /**
	  *新增一个seller 
	  */
	@Override
	public String insertSeller(Seller seller){
		String result = "";
		try{
			seller.setSellerrigisterdate(new Date());
			String account = "se"+seller.getSellerphone();
			seller.setSelleraccount(account);
			seller.setSellerbalance(0.00);
			int ok = checkSellerByAccount(seller.getSelleraccount());
			if(ok != 0){
				result = "exits";
			}else{
				//System.out.println(ok);
				sellerMapper.insert(seller);
				sellerMapper.updateByPrimaryKey(seller);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 批量显示居民用户信息
	 */
	public List<Seller> showSellerList(){
		SellerExample example = new SellerExample();
		example.createCriteria().andIdIsNotNull();
		List<Seller> sellerList = sellerMapper.selectByExample(example);
		return sellerList;
		
	}
	/*ɾ��seller*/
	@Override
	public void deleteSeller(int id) {
				
		sellerMapper.deleteByPrimaryKey(id);
				
	}
	
	
	
	/*����ɾ��    */
	public void deleteBatch(List<Integer> ids){
						
    	for(Integer i:ids){
    		sellerMapper.deleteByPrimaryKey(i.intValue());
    	}
		
		
    }
	
	/*������ѯ     */   
	public List<Seller> selectByBatch(List<Integer> ids){
		List<Seller> sellerList = new ArrayList<Seller>();
		SellerExample example = new SellerExample();
		SellerExample.Criteria criteria =  example.createCriteria();
		criteria.andIdIn(ids);  			
	    sellerList = sellerMapper.selectByExample(example);
    	
    	return sellerList;
    }

	/*��ѯseller by id*/
	@Override
	public Seller getSellerById(int id) {
		return sellerMapper.selectByPrimaryKey(id);		
	}
	
	/*��ѯseller by Namelike  ģ����ѯ*/	
	@Override
	public  List<Seller> getSellerByNameLike(String nameValue) {
		List<Seller> sellerList = new ArrayList<Seller>();
		SellerExample example = new SellerExample();
		SellerExample.Criteria criteria =  example.createCriteria();
		
		if(StringUtils.isNoneBlank(nameValue)){
			
			nameValue = "%" +nameValue + "%";
		}
		
		if(StringUtils.isNotBlank(nameValue)){   
			
			criteria.andSellernameLike(nameValue);  			
		    sellerList = sellerMapper.selectByExample(example);
		} 
		
		return sellerList;
	}
	
	/*��ҳ*/
	public PageBean<Seller> findByPage(int currentPage){
		 HashMap<String,Object> map = new HashMap<String,Object>();
	        PageBean<Seller> pageBean = new PageBean<Seller>();

	        //��װ��ǰҳ��
	        pageBean.setCurrPage(currentPage);

	        //ÿҳ��ʾ������
	        int pageSize=10;
	        pageBean.setPageSize(pageSize);
	        SellerExample example = new SellerExample();
	        //��װ�ܼ�¼��
	        example.createCriteria().andIdIsNotNull();	        
	        int totalCount = sellerMapper.countByExample(example);
	        pageBean.setTotalCount(totalCount);

	        //��װ��ҳ��
	        double tc = totalCount;
	        Double num =Math.ceil(tc/pageSize);//����ȡ��
	        pageBean.setTotalPage(num.intValue());

	        map.put("start",(currentPage-1)*pageSize);
	        map.put("size", pageBean.getPageSize());
	        //��װÿҳ��ʾ������
	        List<Seller> lists = sellerMapper.findByPage(map);
	        pageBean.setLists(lists);

	        return pageBean;
	}
		
	/*����seller By id*/
	public void updateSellerById(Seller seller){
		sellerMapper.updateByPrimaryKeySelective(seller);
	}
	
	/*select  update */
	public void updateSellerBySelect(Seller seller){
		sellerMapper.updateByPrimaryKeySelective(seller);
	}
	
	/*����seller*/
	public void updateSeller(Seller seller){
		boolean ok1 = checkSellerByName(seller.getSellername());
		/*boolean ok2 = checkSellerByAccount(seller.getSelleraccount());
		if(ok1 == false){
			throw new SellerExistsException("���û���<b>"+ seller.getSellername() +"</b>�Ѵ���");
		}		
		if(ok2 == false){
			throw new SellerExistsException("���˺�<b>"+ seller.getSelleraccount() +"</b>�Ѵ���");
		}	
		sellerMapper.updateByPrimaryKey(seller);*/
	}
	
	@Override
	public Seller getByAccount(String sellerAccount) {
		SellerExample example = new SellerExample();
		SellerExample.Criteria criteria =  example.createCriteria();
		criteria.andSelleraccountEqualTo(sellerAccount);
		List<Seller> list = sellerMapper.selectByExample(example);
		if(list.size() == 0){
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 根据selleraccount批量返回
	 * 卖家的经纬度
	 * @param list
	 * @return
	 */
	@Override
	public JSONArray getPositionByAccount(List<String> list) {
		JSONArray arr = new JSONArray();
		try{
			if(list.size() != 0){
				SellerExample example = new SellerExample();
				example.createCriteria().andSelleraccountIn(list);
				List<Seller> sellerList = sellerMapper.selectByExample(example); 
				for(int i =0;i<sellerList.size();i++){
					Seller seller = sellerList.get(i);
					JSONObject obj = new JSONObject();
					obj.put("xsite", seller.getXsite());
					obj.put("ysite", seller.getYsite());
					obj.put("phone", seller.getSellerphone());
					arr.add(obj);
				}
			}else{
				arr = null;
			}
		}catch(Exception e){
			arr = null;
			e.printStackTrace();
		}
		return arr;
	}
	
	/**
	 * 将用户地理位置与账号进行绑定
	 */
	@Override
	public String savePosition(String xSite, String ySite, String openid) {
		String result = "";
		try{
			Seller record = new Seller();
			SellerExample example = new SellerExample();
			example.createCriteria().andSelleropenidEqualTo(openid);
			record.setXsite(Double.parseDouble(xSite));
			record.setYsite(Double.parseDouble(ySite));
			int count = sellerMapper.updateByExampleSelective(record, example);
			if(count == 0){
				result = "empty";
			}else{
				result = "success";
			}
		}catch(Exception e){
			result="error";
			e.printStackTrace();
		}
		return result;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
