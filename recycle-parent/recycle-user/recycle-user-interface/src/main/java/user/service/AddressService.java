package user.service;

import java.util.List;

import user.pojo.Address;

/**
 * 
 * @author jiangchenxi
 *
 */
public interface AddressService {

	/*ͨ��addressId������ѯ*/
	public List<String> getDetailedAddressByAddressId(List<String> list);
	
	/*���address*/
	public void insertAddress(Address address);
	
	/*ɾ��address*/
	public void deleteAddressById(int id);
	
   /*����ɾ��    */
   public void deleteBatch(List<Integer> ids);
     
   /*��ʾ���е�ַ       */
	public List<Address> showAddressList();
  //��ַid��ѯ��ַ
	public Address getByAddressId(String addressId);
	
 /*  ������ѯ     */
  /* public List<Address> selectByBatch(List<Integer> ids);*/
    
	/*��ѯAddress by id*/
	public Address getAddressById(int id);
		
	/*��ѯAddress by Arealike  ģ����ѯ*/
	public  List<Address> getAddressByArealike(String nameValue);
	
	/*��ѯAddress by Namelike  ģ����ѯ*/
	public  List<Address> getAddressByNameLike(String nameValue);
	
	 /* 
	��ҳ
	//public Page<Seller> findSellerList(Integer page, Integer rows, String nameValue);
	*/
	/*����seller*/
	public void updateAddress(Address address);
}
