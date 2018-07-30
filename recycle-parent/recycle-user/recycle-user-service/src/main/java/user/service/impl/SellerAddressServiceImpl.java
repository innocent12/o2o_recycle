package user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.dao.SellerAddressMapper;
import user.pojo.SellerAddress;
import user.pojo.SellerAddressExample;
import user.service.SellerAddressService;
/**
 * 
 * @author jiangchenxi
 *
 */
@Service("sellerAddressServiceImpl")
@Component
public class SellerAddressServiceImpl implements SellerAddressService {

	@Autowired
	private SellerAddressMapper sellerAddressMapper;
	
	
	/*���seller_address*/
	public void insertSellerAddress(SellerAddress sellerAddress){
		
		sellerAddressMapper.insert(sellerAddress);
		sellerAddressMapper.updateByPrimaryKey(sellerAddress);
	}
	
	/*ɾ��seller_address*/
	public void deleteSellerAddressById(int id){
		sellerAddressMapper.deleteByPrimaryKey(id);		
	}
	
	/*  ����ɾ��    */
	public void deleteBatch(List<Integer> ids){
		for(Integer i: ids){
			sellerAddressMapper.deleteByPrimaryKey(i.intValue());
		  }
	}
	
	/*  ��ѯby id    */
    public SellerAddress getSellerAddressById(int id){
    	return sellerAddressMapper.selectByPrimaryKey(id);
    }
	
	/*��ʾ���е�ַ   */    
	public List<SellerAddress> showSellerAddressList(){
		SellerAddressExample example = new SellerAddressExample();
		example.createCriteria().andAddressidIsNotNull();
		return sellerAddressMapper.selectByExample(example);
	}
	
	/*����seller_address*/
	public void updateSellerAddress(SellerAddress sellerAddress){
		sellerAddressMapper.updateByPrimaryKeySelective(sellerAddress);
	}

	@Override
	public SellerAddress getAddressBySellerAccount(String account) {
		SellerAddress seaddress = new SellerAddress();
		try{
			SellerAddressExample example = new SellerAddressExample();
			example.createCriteria().andSelleraccountEqualTo(account);
			List<SellerAddress> list= sellerAddressMapper.selectByExample(example);
			if(list.size()==1){
				seaddress = list.get(0);
			}else{
				seaddress = null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return seaddress;
	}

	@Override
	public List<String> getAddressIdByAccount(List<String> list) {
		List<String> addressIdList = new ArrayList<>();
		try{
			System.out.println(list);
			SellerAddressExample example = new SellerAddressExample();
			example.createCriteria().andSelleraccountIn(list);
			List<SellerAddress> saList = sellerAddressMapper.selectByExample(example);
			if(saList.size() != 0){
				for(int i =0;i<saList.size();i++){
					addressIdList.add(saList.get(i).getAddressid());
				}
			}
		}catch(Exception e){
			addressIdList = null;
			e.printStackTrace();
		}
		return addressIdList;
	}
	
}
