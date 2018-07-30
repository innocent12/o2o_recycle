package web.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import order.dto.OrderDetail;
import user.dto.UserInfoDto;

public class FontOrder implements Serializable{

	//订单部分
	private List<OrderDetail> orderDetailList;
	//聚合用户
	private List<UserInfoDto> userInfoDtoList;
	
	private String status; 
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public FontOrder(){
		orderDetailList = new ArrayList<OrderDetail>();
		userInfoDtoList = new ArrayList<UserInfoDto>();
		status = "init";
	}

	public List<UserInfoDto> getUserInfoDtoList() {
		return userInfoDtoList;
	}

	public void setUserInfoDtoList(List<UserInfoDto> userInfoDtoList) {
		this.userInfoDtoList = userInfoDtoList;
	}
	
	public void addUserInfoDto(UserInfoDto userInfoDto){
		if(userInfoDtoList == null){
			System.out.println("空对象");
		}
		userInfoDtoList.add(0,userInfoDto);
	}
	
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	
	public void addOrderDetail(OrderDetail orderDetail){
		if(orderDetailList == null){
			System.out.println("空对象");
		}
		orderDetailList.add(0,orderDetail);
	}
	
}
