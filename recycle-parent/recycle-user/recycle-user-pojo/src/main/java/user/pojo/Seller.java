package user.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author JCX
 *
 */
public class Seller implements Serializable{

	private Integer id;

    private String selleraccount;

    private String sellername;

    private String sellerpassword;

    private String selleropenid;

    private String sellerphone;

    private Double sellerbalance;

    private Date sellerrigisterdate;

    private String sellerlevel;

    private String sellerpicture;

    private Double xsite;

    private Double ysite;
       

    public Seller() {
		super();
	}

	public Seller(Integer id, String selleraccount, String sellername, String sellerpassword, String selleropenid,
			String sellerphone, Double sellerbalance, Date sellerrigisterdate, String sellerlevel, String sellerpicture,
			Double xsite, Double ysite) {
		super();
		this.id = id;
		this.selleraccount = selleraccount;
		this.sellername = sellername;
		this.sellerpassword = sellerpassword;
		this.selleropenid = selleropenid;
		this.sellerphone = sellerphone;
		this.sellerbalance = sellerbalance;
		this.sellerrigisterdate = sellerrigisterdate;
		this.sellerlevel = sellerlevel;
		this.sellerpicture = sellerpicture;
		this.xsite = xsite;
		this.ysite = ysite;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSelleraccount() {
        return selleraccount;
    }

    public void setSelleraccount(String selleraccount) {
        this.selleraccount = selleraccount == null ? null : selleraccount.trim();
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername == null ? null : sellername.trim();
    }

    public String getSellerpassword() {
        return sellerpassword;
    }

    public void setSellerpassword(String sellerpassword) {
        this.sellerpassword = sellerpassword == null ? null : sellerpassword.trim();
    }

    public String getSelleropenid() {
        return selleropenid;
    }

    public void setSelleropenid(String selleropenid) {
        this.selleropenid = selleropenid == null ? null : selleropenid.trim();
    }

    public String getSellerphone() {
        return sellerphone;
    }

    public void setSellerphone(String sellerphone) {
        this.sellerphone = sellerphone == null ? null : sellerphone.trim();
    }

    public Double getSellerbalance() {
        return sellerbalance;
    }

    public void setSellerbalance(Double sellerbalance) {
        this.sellerbalance = sellerbalance;
    }

    public Date getSellerrigisterdate() {
        return sellerrigisterdate;
    }

    public void setSellerrigisterdate(Date sellerrigisterdate) {
        this.sellerrigisterdate = sellerrigisterdate;
    }

    public String getSellerlevel() {
        return sellerlevel;
    }

    public void setSellerlevel(String sellerlevel) {
        this.sellerlevel = sellerlevel == null ? null : sellerlevel.trim();
    }

    public String getSellerpicture() {
        return sellerpicture;
    }

    public void setSellerpicture(String sellerpicture) {
        this.sellerpicture = sellerpicture == null ? null : sellerpicture.trim();
    }

    public Double getXsite() {
        return xsite;
    }

    public void setXsite(Double xsite) {
        this.xsite = xsite;
    }

    public Double getYsite() {
        return ysite;
    }

    public void setYsite(Double ysite) {
        this.ysite = ysite;
    }
}