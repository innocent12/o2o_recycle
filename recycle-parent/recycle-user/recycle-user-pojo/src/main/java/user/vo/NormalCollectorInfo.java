package user.vo;

import java.io.Serializable;

public class NormalCollectorInfo implements Serializable{

	private String collectorAccount;
	private String collectorName;
	private String collectorPhone;
	
	public String getCollectorAccount() {
		return collectorAccount;
	}
	public void setCollectorAccount(String collectorAccount) {
		this.collectorAccount = collectorAccount;
	}
	public String getCollectorName() {
		return collectorName;
	}
	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}
	public String getCollectorPhone() {
		return collectorPhone;
	}
	public void setCollectorPhone(String collectorPhone) {
		this.collectorPhone = collectorPhone;
	}
	
	
}
