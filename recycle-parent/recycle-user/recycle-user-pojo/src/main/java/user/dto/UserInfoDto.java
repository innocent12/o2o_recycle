package user.dto;

import java.io.Serializable;

import user.vo.NormalCollectorInfo;
import user.vo.NormalSellerInfo;

public class UserInfoDto implements Serializable{
	
	//状态
	private String status;
	//回收员
	private NormalCollectorInfo normalCollector;
	//居民用户
	private NormalSellerInfo normalInfo;
	
	public UserInfoDto(){
		normalCollector = new NormalCollectorInfo();
		normalInfo = new NormalSellerInfo();
		status = "init";
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public NormalCollectorInfo getNormalCollector() {
		return normalCollector;
	}
	public void setNormalCollector(NormalCollectorInfo normalCollector) {
		this.normalCollector = normalCollector;
	}
	public NormalSellerInfo getNormalInfo() {
		return normalInfo;
	}
	public void setNormalInfo(NormalSellerInfo normalInfo) {
		this.normalInfo = normalInfo;
	}
	
	
}
