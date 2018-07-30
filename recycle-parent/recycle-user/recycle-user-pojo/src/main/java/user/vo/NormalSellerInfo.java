package user.vo;

import java.io.Serializable;

public class NormalSellerInfo implements Serializable{

	private String sellerAccount;
	private String sellerPhone;
	private String sellerName;
	private String sellerAddressArea;
	private String sellerAddressDetail;
	
	
	public String getSellerAccount() {
		return sellerAccount;
	}
	public void setSellerAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerAddressArea() {
		return sellerAddressArea;
	}
	public void setSellerAddressArea(String sellerAddressArea) {
		this.sellerAddressArea = sellerAddressArea;
	}
	public String getSellerAddressDetail() {
		return sellerAddressDetail;
	}
	public void setSellerAddressDetail(String sellerAddressDetail) {
		this.sellerAddressDetail = sellerAddressDetail;
	}
}
