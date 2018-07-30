package user.service;


import java.util.List;

import net.sf.json.JSONArray;
import pojo.PageBean;
import user.dto.UserInfoDto;
import user.pojo.Seller;
import user.vo.SellerDetailedInfo;

/**
 * 
 * @author JCX
 *
 */
public interface SellerService {
	
	//将卖家的经纬度存入数据库
	public String savePosition(String xSite, String ySite, String openid);
	
	//根据seller账号获取地理位置
	 public JSONArray getPositionByAccount(List<String> list); 
	
	/* 通过卖家名字检验seller是否存在*/
	 public boolean checkSellerByName(String sellerName);
	 
	 /* �����˺��Ƿ����*/
	 public int checkSellerByAccount(String sellerAccount);
	 
	 //通过账号获得卖家
	 public Seller getByAccount(String sellerAccount);
	 
	 /*���˺� �����¼*/
	 public Seller getByAccountAndPasswd(String sellerAccount, String sellerPassword, String openid);
	 
	 /*��openid��¼*/
	 public Seller getByOpenid(String sellerOpenid);
	 
	 
	/*���seller*/
	public String insertSeller(Seller seller);
	
	/*ɾ��seller*/
	public void deleteSeller(int id);
	
    /*����ɾ��    */
    public void deleteBatch(List<Integer> ids);
    
    /*��ѯ����     */  
	public List<Seller> showSellerList();
	
    /*������ѯ     */
    public List<Seller> selectByBatch(List<Integer> ids);
    
	/*��ѯseller by id*/
	public Seller getSellerById(int id);
	/*��ѯseller by Namelike  ģ����ѯ*/
	public  List<Seller> getSellerByNameLike(String nameValue);
	
	
	/*��ҳ*/
	public PageBean<Seller> findByPage(int currentPage);
	
	/*����seller By id*/
	public void updateSellerById(Seller seller);
	
	/*select  update */
	public void updateSellerBySelect(Seller seller);
	
	/*����seller*/
	public void updateSeller(Seller seller);
	
	
	/**
	 * 根据卖家账号信息获取，简要卖家信息，地址，用于订单展示中
	 * @param sellerAccount
	 * @return
	 */
	public UserInfoDto getNormalSeller_AddressByAccount(String sellerAccount);
	
	/**
	 * TODO
	 * 根据区域获取居民用户信息
	 * @param addressArea
	 * @return
	 */
	public List<UserInfoDto> getAreaSellersByCollectorArea(String addressArea);
	
	SellerDetailedInfo getSellerAllInfoByAccount(String account);
}
