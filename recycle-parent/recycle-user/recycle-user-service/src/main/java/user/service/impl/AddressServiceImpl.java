package user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.dao.AddressMapper;
import user.pojo.Address;
import user.pojo.AddressExample;
import user.service.AddressService;

/**
 * 
 * @author JCX
 *
 */
@Service("addressServiceImpl")
@Component
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressMapper addressMapper;

	
	/*���address*/
	public void insertAddress(Address address){
		addressMapper.insert(address);
		addressMapper.updateByPrimaryKey(address);
	}
	
	/*ɾ��address*/
	public void deleteAddressById(int id){
		addressMapper.deleteByPrimaryKey(id);
	}
	
	 /*����ɾ��    */
	   public void deleteBatch(List<Integer> ids){
		  for(Integer i: ids){
			  addressMapper.deleteByPrimaryKey(i.intValue());
		  }
	   }
	   
	   /*��ʾ���е�ַ       */
		public List<Address> showAddressList(){
			AddressExample  example = new AddressExample();
			example.createCriteria().andAddressidIsNotNull();
			return addressMapper.selectByExample(example);
			
		}
		
		/*��ѯAddress by id*/
		public Address getAddressById(int id){
			return addressMapper.selectByPrimaryKey(id);
		}
		
		/*��ѯAddress by Arealike  ģ����ѯ*/
		public  List<Address> getAddressByArealike(String nameValue){
			List<Address> addressList = new ArrayList<Address>();
			AddressExample  example = new AddressExample();
			
			if(StringUtils.isNoneBlank(nameValue)){
				
				nameValue = "%" +nameValue + "%";
			}
			
			if(StringUtils.isNotBlank(nameValue)){   
				//AddressExample  example = new AddressExample();
				example.createCriteria().andAddressareaLike(nameValue);
				//criteria.andAddressareaLike(nameValue);  			
			    addressList = addressMapper.selectByExample(example);
			} 
			return addressList;
			
		}
		
		/*��ѯAddress by Namelike  ģ����ѯ*/
		public  List<Address> getAddressByNameLike(String nameValue){
			List<Address> addressList = new ArrayList<Address>();
			AddressExample  example = new AddressExample();
			
			if(StringUtils.isNoneBlank(nameValue)){
				
				nameValue = "%" +nameValue + "%";
			}
			
			if(StringUtils.isNotBlank(nameValue)){   
				
				example.createCriteria().andAddressnameLike(nameValue);  			
			    addressList = addressMapper.selectByExample(example);
			} 
			return addressList;
			
		}
		
		/*����seller*/
		public void updateAddress(Address address){
			addressMapper.updateByPrimaryKeySelective(address);
		}

		@Override
		public Address getByAddressId(String addressId) {
			// TODO Auto-generated method stub
			AddressExample  example = new AddressExample();
			example.createCriteria().andAddressidEqualTo(addressId);
			List<Address> list = addressMapper.selectByExample(example);
			if(list.size() == 0){
				return null;
			}
			return list.get(0);
		}

		/**
		 * 根据地址编号获取详细的地址信息
		 */
		@Override
		public List<String> getDetailedAddressByAddressId(List<String> list) {
			List<String> addressDetailList = new ArrayList<>();
			try{
				AddressExample  example = new AddressExample();
				example.createCriteria().andAddressidIn(list);
				List<Address> addressList = addressMapper.selectByExample(example);
				if(addressList.size() !=0){
					for(int i =0;i<addressList.size();i++){
						addressDetailList.add(addressList.get(i).getAddressdetailed());
					}
				}else{
					addressDetailList = null;
				}
			}catch(Exception e){
				addressDetailList = null;
				e.printStackTrace();
			}
			return addressDetailList;
		}

}
