package user.service;


import java.util.List;

import user.pojo.SellerAddress;

/**
 * 
 * @author jiangchenxi
 *
 */
public interface SellerAddressService {

	public List<String> getAddressIdByAccount(List<String> list);
	
	//���������˺�������ַid
	public SellerAddress getAddressBySellerAccount(String account);
	
	/*���seller_address*/
	public void insertSellerAddress(SellerAddress sellerAddress);
	
	/*ɾ��seller_address*/
	public void deleteSellerAddressById(int id);
	
	/*  ����ɾ��    */
    public void deleteBatch(List<Integer> ids);
     
    /*  ��ѯby id    */
    public SellerAddress getSellerAddressById(int id);
    
   /*��ʾ���е�ַ   */    
	public List<SellerAddress> showSellerAddressList();
  
	/*��ҳ*/
	//public Page<Seller> findSellerList(Integer page, Integer rows, String nameValue);
	
	/*����seller_address*/
	public void updateSellerAddress(SellerAddress sellerAddress);
}
