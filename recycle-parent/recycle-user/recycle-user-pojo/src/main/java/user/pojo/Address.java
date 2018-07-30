package user.pojo;

import java.io.Serializable;

/**
 * 
 * @author JCX
 *
 */
public class Address implements Serializable{
    private Integer id;

    private String addressid;

    private String addressarea;

    private String addressdetailed;

    private String addressname;

    private String addressphone;

    
    
    public Address() {
		super();
	}

	public Address(Integer id, String addressid, String addressarea, String addressdetailed, String addressname,
			String addressphone) {
		super();
		this.id = id;
		this.addressid = addressid;
		this.addressarea = addressarea;
		this.addressdetailed = addressdetailed;
		this.addressname = addressname;
		this.addressphone = addressphone;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressid() {
        return addressid;
    }

    public void setAddressid(String addressid) {
        this.addressid = addressid == null ? null : addressid.trim();
    }

    public String getAddressarea() {
        return addressarea;
    }

    public void setAddressarea(String addressarea) {
        this.addressarea = addressarea == null ? null : addressarea.trim();
    }

    public String getAddressdetailed() {
        return addressdetailed;
    }

    public void setAddressdetailed(String addressdetailed) {
        this.addressdetailed = addressdetailed == null ? null : addressdetailed.trim();
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname == null ? null : addressname.trim();
    }

    public String getAddressphone() {
        return addressphone;
    }

    public void setAddressphone(String addressphone) {
        this.addressphone = addressphone == null ? null : addressphone.trim();
    }
}