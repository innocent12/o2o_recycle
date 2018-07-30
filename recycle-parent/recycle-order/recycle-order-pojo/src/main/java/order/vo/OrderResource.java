package order.vo;

import java.io.Serializable;

public class OrderResource implements Serializable{
	
	private double resourceAmount;
	private String resourceName;
	private String resourceType;
	private String resourcePicture;
	

	public double getResourceAmount() {
		return resourceAmount;
	}
	public void setResourceAmount(double resourceAmount) {
		this.resourceAmount = resourceAmount;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public String getResourcePicture() {
		return resourcePicture;
	}
	public void setResourcePicture(String resourcePicture) {
		this.resourcePicture = resourcePicture;
	}
}
