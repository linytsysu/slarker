package web.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "RegionCode")
public class Region implements Serializable {
	@Id
	@Column(name = "code")
	private String code;
	
	@Column(name = "town")
	private String town;
	
	@Column(name = "city")
	private String city;

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
