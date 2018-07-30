package user.vo;

import java.io.Serializable;

import user.pojo.Seller;

public class SellerDetailedInfo implements Serializable{

	private String addressId;
	private String addressArea;
	private String addressDetail;
	private Seller seller;
	
	
	/**
	 * 无参构造
	 */
	public SellerDetailedInfo(){
		seller = new Seller();
		addressId = "";
		addressArea = "";
		addressDetail = "";
	}
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getAddressArea() {
		return addressArea;
	}
	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	
}
