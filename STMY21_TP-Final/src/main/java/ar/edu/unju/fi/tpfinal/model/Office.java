package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "OFFICES")
@Component("officeObj")
public class Office {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long officeCode;
	
	@NotNull(message = "El campo city no puede estar vacio")
	@Size(max = 50, message = "Como maximo debe tener 50 caracteres")
	@Column (name = "city")
	private String city;
	
	@NotNull(message = "El campo phone no puede estar vacio")
	@Size(max = 50, message = "Como maximo debe tener 50 caracteres")
	@Column (name = "phone")
	private	String phone; 
	
	@NotNull(message = "El campo addressLine1 no puede estar vacio")
	@Size(max = 50, message = "Como maximo debe tener 50 caracteres")
	@Column (name = "addressLine1")
	private String addressLine1;
	
	@Size(max = 50, message = "Como maximo debe tener 50 caracteres")
	@Column (name = "addressLine2")
	private String addressLine2;
	
	@Size(max = 50, message = "Como maximo debe tener 50 caracteres")
	@Column (name = "state")
	private	String state;
	
	@NotNull(message = "El campo country no puede estar vacio")
	@Size(max = 50, message = "Como maximo debe tener 50 caracteres")
	@Column (name = "country")
	private	String country; 
	
	@NotNull(message = "El campo postalCode no puede estar vacio")
	@Size(max = 15, message = "Como maximo debe tener 15 caracteres")
	@Column (name = "postalCode")
	private	String postalCode; 
	
	@NotNull(message = "El campo territory no puede estar vacio")
	@Size(max = 10, message = "Como maximo debe tener 10 caracteres")
	@Column (name = "territory")
	private String territory;

	public Office() {
		// TODO Auto-generated constructor stub
	}

	public Long getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(Long officeCode) {
		this.officeCode = officeCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	@Override
	public String toString() {
		return "Office [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", territory=" + territory + "]";
	}

}
