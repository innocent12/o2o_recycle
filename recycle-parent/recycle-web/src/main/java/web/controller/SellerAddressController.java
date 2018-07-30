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
import user.pojo.SellerAddress;
import user.service.SellerAddressService;

/**
 * 
 * @author JCX
 *
 */

@Controller
@RequestMapping(value="/selleraddress")
public class SellerAddressController {

	
	@Autowired
	private SellerAddressService sellerAddressService;
	
	/**
	 * 添加卖家地址（设置addressid和sellercount相同）
	 * @param input
	 * @return
	 */
	@RequestMapping(value="/addSellerAddress", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addSellerAddress(@RequestBody JSONObject object){
		SellerAddress sellerAddress = new SellerAddress();
		sellerAddress.setAddresstype(Integer.parseInt("0"));
		sellerAddress.setAddressid(object.getString("selleraccount"));
		sellerAddress.setSelleraccount(object.getString("selleraccount"));
				
		sellerAddressService.insertSellerAddress(sellerAddress);				
		
		return object;		
	}
	
	/**
	 * 显示所有卖家的地址
	 * @param object
	 * @return
	 */
	@RequestMapping(value = "/showSellerAddressList")
	@ResponseBody
	public JSONObject showSellerAddressList(@RequestBody JSONObject object){
		List<SellerAddress> sellerAddressList = sellerAddressService.showSellerAddressList();
		object = JSONObject.fromObject(sellerAddressList);
		object.put("list", sellerAddressList);
	    return object;	
		
	}
	
	/**
	 * 删除卖家地址
	 * @param input
	 * @return
	 */
	@RequestMapping(value="/deleteSellerAddress")
	@ResponseBody
	public JSONObject deleteSellerAddress(@RequestBody JSONObject object){
		Integer id = Integer.parseInt(object.getString("id"));
		sellerAddressService.deleteSellerAddressById(id);
		object.put("msg", "success");
		return object;		
	}

	/**
	 * 批量删除卖家地址
	 * @param input
	 * @return
	 */
	@RequestMapping(value="/deleteSellerAddressByBatch")
	@ResponseBody
	public JSONObject deleteSelllerAddressByBatch(@RequestBody JSONObject object){
		List<Integer> ids = new ArrayList<>();
		for(int i=0; i<object.size(); i++){
			Integer id = Integer.parseInt(object.getJSONObject(i+"").getString("id"));
			ids.add(id);
		}		
		object.put("msg", "success");
		sellerAddressService.deleteBatch(ids);
		return object;	

				
	}
	
	/**
	 * 这个是总的更新下面有根据一个一个的更新
	 * @param input
	 * @return
	 * @throws SellerExistsException
	 */
	@RequestMapping(value="/updateSellerAddress")
	@ResponseBody
	public JSONObject updateSellerAddress(@RequestBody JSONObject input){
		JSONObject object = JSONObject.fromObject(input);
		SellerAddress sellerAddress = new SellerAddress();
		
		Integer addressType = Integer.parseInt(object.getString("addressType"));
		String addressId = object.getString("addressId");
		String sellerAccount = object.getString("sellerAccount");
		
		sellerAddress.setAddresstype(addressType);
		sellerAddress.setAddressid(addressId);
		sellerAddress.setSelleraccount(sellerAccount);
		
		sellerAddressService.updateSellerAddress(sellerAddress);
		object.put("msg", "success");
		return object;		
			
	}
	
	/**
	 * 根据卖家账号更新卖家地址
	 * @param input
	 * @return
	 * @throws SellerExistsException
	 */
	@RequestMapping(value="/updateSellerAddressBysellerAccount")
	@ResponseBody
	public JSONObject updateSellerAddressBysellerAccount(@RequestBody JSONObject object){
		SellerAddress sellerAddress = new SellerAddress();

		String sellerAccount = object.getString("sellerAccount");

		sellerAddress.setSelleraccount(sellerAccount);
		
		sellerAddressService.updateSellerAddress(sellerAddress);
		object.put("msg", "success");
		return object;		
			
	}
	
	/**
	 * 通过卖家地址id更新卖家地址
	 * @param input
	 * @return
	 * @throws SellerExistsException
	 */
	@RequestMapping(value="/updateSellerAddressByaddressId")
	@ResponseBody
	public JSONObject updateSellerAddressByaddressId(@RequestBody JSONObject object){
		SellerAddress sellerAddress = new SellerAddress();
		
		String addressId = object.getString("addressId");
		sellerAddress.setAddressid(addressId);
		
		sellerAddressService.updateSellerAddress(sellerAddress);
		object.put("msg", "success");
		return object;		
			
	}
	/**
	 * 通过地址类型更新卖家地址
	 * @param input
	 * @return
	 * @throws SellerExistsException
	 */
	@RequestMapping(value="/updateSellerAddressByType")
	@ResponseBody
	public JSONObject updateSellerAddressByType(@RequestBody JSONObject object){
		SellerAddress sellerAddress = new SellerAddress();
		
		Integer addressType = Integer.parseInt(object.getString("addressType"));
		
		sellerAddress.setAddresstype(addressType);
		
		sellerAddressService.updateSellerAddress(sellerAddress);
		object.put("msg", "success");
		return object;		
			
	}
	
	
}
