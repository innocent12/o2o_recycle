package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import pojo.AccessToken;
import user.pojo.Address;
import user.pojo.Collector;
import user.pojo.Seller;
import user.pojo.SellerAddress;
import user.service.AddressService;
import user.service.CollectorService;
import user.service.SellerAddressService;
import user.service.SellerService;
import util.WeiXinUtil;


@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	private CollectorService collectorService;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private SellerAddressService saService;
	
	@Autowired
	private AddressService addressService;
	/**
	 * ����openidֱ�ӵ�¼
	 * �����ݿ�ƥ����Ӧ���û���Ϣ
	 * 
	 * @param json
	 * @param session
	 * @return
	 */
	@RequestMapping("/validWXLogin")
	@ResponseBody
	public JSONObject validAllLogin(@RequestBody JSONObject json){
		WeiXinUtil wxUtil = new WeiXinUtil();
		try{
			//����code
			String code = json.optString("code");
			json.optString("state");
			AccessToken accesstoken = wxUtil.getAccessToken(code);
			String openid = accesstoken.getOpenid();
			if(openid != ""){
				//������֤����Ա
				Collector collector = collectorService.LoginIn(openid);
				if(collector != null){
					json = JSONObject.fromObject(collector);
					Address address = addressService.getByAddressId(collector.getAddressid());
					String collectorarea = address.getAddressarea();
					json.put("collectoraddressarea", collectorarea);
					json.put("msg", "success");
					//����Ա���
					json.put("identity", "2");
				}else{
					//��֤�����û����
					Seller seller = sellerService.getByOpenid(openid);
					String area = "";
					String detail = "";
					if(seller != null){
						SellerAddress sellerAddress = saService.getAddressBySellerAccount(seller.getSelleraccount());
						if(sellerAddress != null){
							String addressid = sellerAddress.getAddressid();
							Address address =  addressService.getByAddressId(addressid);
							area = address.getAddressarea();
							detail = address.getAddressdetailed();
						}
						json = JSONObject.fromObject(seller);
						json.put("selleraddressarea", area);
						json.put("selleraddressdetail", detail);
						json.put("msg", "success");
						json.put("identity", "1");
					}else{
						json.put("msg", "openid无效");
						json.put("openid", openid);
					}
				}
			}else{
				json.put("msg", "empty openid");
			}
		}catch(Exception e){
			e.printStackTrace();
			json.put("msg", "error");
		}
		return json;
	}
	
}
