package order.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import order.vo.OrderResource;
import order.vo.VisualOrderInfo;

public class OrderDetail implements Serializable{

	//订单号
	private String orderId;
	//订单货物
	private List<OrderResource> orderItemList;
	//订单信息
	private VisualOrderInfo visualOrderInfo;
	//操作状态，是否成功获取数据
	private String status;
	
	public OrderDetail(){
		orderItemList = new ArrayList<OrderResource>();
		visualOrderInfo = new VisualOrderInfo();
		orderId = "init";
	}
	
	public VisualOrderInfo getVisualOrderInfo() {
		return visualOrderInfo;
	}

	public void setVisualOrderInfo(VisualOrderInfo visualOrderInfo) {
		this.visualOrderInfo = visualOrderInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<OrderResource> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderResource> orderItemList) {
		this.orderItemList = orderItemList;
	}
	
	
}
