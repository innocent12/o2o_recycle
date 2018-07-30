package pojo;

import java.io.Serializable;

/**
 * ��ͨjava��
 * @author xutianyu
 *
 */
public class AccessToken implements Serializable{

	public String access_token;
	//��ȡ��access_token
	
	public int valid_time;
	//��Чʱ��
	
	//openid��
	public String openid;
	
	//refresh access_token
	public String refresh_token;
	
	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getValid_time() {
		return valid_time;
	}

	public void setValid_time(int valid_time) {
		this.valid_time = valid_time;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
}
