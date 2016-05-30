package web.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "RegionCode")
public class Region implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2770440236805096170L;

	@Id
	@Column(name = "code")
	private String code;
	
	@Column(name = "town")
	private String town;
	
	@Column(name = "city")
	private String city;
	
	public Region() {}
	
	public Region(String code, String town, String city) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.town = town;
		this.city = city;
	}

	public Region(Region region) {
		// TODO Auto-generated constructor stub
		this.code = region.code;
		this.town = region.town;
		this.city = region.city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
