package web.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CityTown")
public class CityTown implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "city")
	private String city;
	
	@Column(name = "towns")
	private List<String> towns;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getTowns() {
		return towns;
	}

	public void setTowns(List<String> towns) {
		this.towns = towns;
	}
}
