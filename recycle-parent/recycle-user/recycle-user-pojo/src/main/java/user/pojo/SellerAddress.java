package user.pojo;

import java.io.Serializable;

/**
 * 
 * @author JCX
 *
 */
public class SellerAddress implements Serializable{
    private Integer id;

    private Integer addresstype;

    private String addressid;

    private String selleraccount;

    
    
    public SellerAddress() {
		super();
	}

	public SellerAddress(Integer id, Integer addresstype, String addressid, String selleraccount) {
		super();
		this.id = id;
		this.addresstype = addresstype;
		this.addressid = addressid;
		this.selleraccount = selleraccount;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(Integer addresstype) {
        this.addresstype = addresstype;
    }

    public String getAddressid() {
        return addressid;
    }

    public void setAddressid(String addressid) {
        this.addressid = addressid == null ? null : addressid.trim();
    }

    public String getSelleraccount() {
        return selleraccount;
    }

    public void setSelleraccount(String selleraccount) {
        this.selleraccount = selleraccount == null ? null : selleraccount.trim();
    }
}