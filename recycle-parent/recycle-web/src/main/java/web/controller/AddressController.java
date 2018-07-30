package web.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import user.pojo.Address;
import user.pojo.SellerAddress;
import user.service.AddressService;
import user.service.SellerAddressService;


/**
 * 地址
 * @author JCX
 *
 */

@Controller
@RequestMapping(value="/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@Autowired
	private SellerAddressService sellerAddressService;
	/**
	 * 添加地址Address（设置addressid和sellercount相同）
	 * @param object
	 * @return
	 */
	@RequestMapping(value="/addAddress", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addAddress(@RequestBody JSONObject object){
		Address address = new Address();
		address.setAddressid(object.getString("addressid"));
		address.setAddressarea(object.getString("addressarea"));
		address.setAddressdetailed(object.getString("addressdetailed"));
		address.setAddressname(object.getString("addressname"));
		address.setAddressphone(object.getString("addressphone"));
		addressService.insertAddress(address);				
		addressService.updateAddress(address);
		return object;		
	}
	/**
	 * 通过AddressId来查询DetailedAddress
	 * @param object
	 * @return
	 */
	@RequestMapping(value="/getDetailedAddressByAddressId")
	@ResponseBody
	public JSONObject getDetailedAddressByAddressId(@RequestBody JSONObject object){
		List<String> addressIds = new ArrayList<String>();
		for(int i=0; i<object.size(); i++){
			String addressId = object.getJSONObject(i+"").getString("addressId");
			
			addressIds.add(addressId);
		}
		List<String> addressDetailed = addressService.getDetailedAddressByAddressId(addressIds);
		
		object.put("list", addressDetailed);
		
		return object;			
	}
	/**
	 * Address列表显示所有地址
	 * @return
	 */
	@RequestMapping(value = "/showAddressList")
	@ResponseBody
	public JSONObject showAddressList(){
		JSONObject object = new JSONObject();
		List<Address> addressList = addressService.showAddressList();
		object.put("list", addressList);
		return object;
		
	}
	
	/**
	 * 删除地址通过id
	 * @param object
	 * @return
	 */
	@RequestMapping(value="/deleteAddress")
	@ResponseBody
	public JSONObject deleteAddress(@RequestBody JSONObject object){
		Integer id = Integer.parseInt(object.getString("id"));
		addressService.deleteAddressById(id);
		return object;		
	}
	
	/**
	 * id批量删除地址
	 * @param input
	 * @return
	 */
	@RequestMapping(value="/deleteAddressByBatch")
	@ResponseBody
	public JSONObject deleteAddressByBatch(@RequestBody JSONObject object){
		List<Integer> ids = new ArrayList<Integer>();
		for(int i=0; i<object.size(); i++){
			Integer id = Integer.parseInt(object.getJSONObject(i+"").getString("id"));
			ids.add(id);
		}
		object.put("msg", "success");
		addressService.deleteBatch(ids);
		return object;		
	}
	/**
	 * 通过用户账号查用户地址
	 * @param object
	 * @return
	 */
	@RequestMapping(value="/getAddressidBySellerAccount", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getAddressidBySellerAccount(String account){
		JSONObject object = new JSONObject();
		SellerAddress sellerAddress=sellerAddressService.getAddressBySellerAccount(account);
		String addressId = sellerAddress.getAddressid();
		/*被设定一个seller只有一个地址*/
		Address address=addressService.getByAddressId(addressId);
		object.put("address", address);
		return object;			
	}
	
	
	
	
	/**
	 * 根据地址名字模糊查询地址
	 * @param input
	 * @return
	 */
	@RequestMapping(value="/getAddressByNameLike", method=RequestMethod.GET)
	@ResponseBody
	public JSONObject getAddressByNameLike(@RequestBody JSONObject object){
		String namelike = object.getString("namelike");
		List<Address> addressList = addressService.getAddressByArealike(namelike);
		object.put("list", addressList);
		return object;			
	}
	
	
	/**
	 * 根据地址区域模糊查询地址
	 * @param input
	 * @return
	 */
	@RequestMapping(value="/getAddressByAreaLike", method=RequestMethod.GET)
	@ResponseBody
	public JSONObject getAddressByAreaLike(@RequestBody JSONObject object){
		String namelike = object.getString("namelike");
		List<Address> addressList = addressService.getAddressByArealike(namelike);
		object.put("list", addressList);
		return object;			
	}
	
	/**
	 * 这个是总的更新下面有根据一个一个的更新
	 * @param input
	 * @return
	 * @throws SellerExistsException
	 */
	@RequestMapping(value="/updateAddress")
	@ResponseBody
	public JSONObject updateAddress(@RequestBody JSONObject object, int id) {
		Address address = new Address();
		String addressArea = object.getString("selleraddressarea");
		String addressDetailed = object.getString("selleraddressdetail");
		//String addressName = object.getString("addressName");
		//String addressPhone = object.getString("addressPhone");
		address.setAddressarea(addressArea);
		address.setAddressdetailed(addressDetailed);
		//address.setAddressname(addressName);
		//address.setAddressphone(addressPhone);
		address.setId(id);
		addressService.updateAddress(address);
		object.put("msg", "success");
		return object;		
	}
	
	@RequestMapping(value="/updateAddressByPhone")
	@ResponseBody
	public JSONObject updateAddressByPhone(@RequestBody JSONObject object){
		Address address = new Address();
		String addressPhone = object.getString("addressPhone");
		address.setAddressphone(addressPhone);
		addressService.updateAddress(address);
		object.put("msg", "success");
		return object;		
	}
	
	@RequestMapping(value="/updateAddressByName")
	@ResponseBody
	public JSONObject updateAddressByName(@RequestBody JSONObject object) {
		Address address = new Address();
		String addressName = object.getString("addressName");		
		address.setAddressname(addressName);		
		addressService.updateAddress(address);
		object.put("msg", "success");
		return object;		
	}
	
	@RequestMapping(value="/updateAddressByArea")
	@ResponseBody
	public JSONObject updateAddressByArea(@RequestBody JSONObject object){
		Address address = new Address();
		String addressArea = object.getString("addressArea");		
		address.setAddressarea(addressArea);		
		addressService.updateAddress(address);
		object.put("msg", "success");
		return object;		
	}
	
	@RequestMapping(value="/updateAddressByDetailed")
	@ResponseBody
	public JSONObject updateAddressByDetailed(@RequestBody JSONObject object){
		Address address = new Address();
		String addressDetailed = object.getString("addressDetailed");		
		address.setAddressdetailed(addressDetailed);	
		addressService.updateAddress(address);
		object.put("msg", "success");
		return object;		
	}
	
}
