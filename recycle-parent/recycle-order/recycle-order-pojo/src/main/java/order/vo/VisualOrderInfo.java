package order.vo;

import java.io.Serializable;

/**
 * 从数据得到的订单信息
 * @author xutianyu
 *
 */
public class VisualOrderInfo implements Serializable{

	private String orderId;
	private double orderAmount;
	//区域地址
	private String addressArea;
	//详细地址
	private String addressDetailed;
	private String sellerPhone;
	//下单时间
	private String orderPlaceTime;
	private String orderFinishTime;
	private String orderState;
	//卖家留言
	private String sellerMessage;
	private String sellerAccount;
	private String sellerName;
	
	
	
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getAddressArea() {
		return addressArea;
	}
	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}
	public String getAddressDetailed() {
		return addressDetailed;
	}
	public void setAddressDetailed(String addressDetailed) {
		this.addressDetailed = addressDetailed;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public String getOrderFinishTime() {
		return orderFinishTime;
	}
	
	public String getOrderPlaceTime() {
		return orderPlaceTime;
	}
	public void setOrderPlaceTime(String orderPlaceTime) {
		this.orderPlaceTime = orderPlaceTime;
	}
	public void setOrderFinishTime(String orderFinishTime) {
		this.orderFinishTime = orderFinishTime;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getSellerMessage() {
		return sellerMessage;
	}
	public void setSellerMessage(String sellerMessage) {
		this.sellerMessage = sellerMessage;
	}
	public String getSellerAccount() {
		return sellerAccount;
	}
	public void setSellerAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}
	
}
