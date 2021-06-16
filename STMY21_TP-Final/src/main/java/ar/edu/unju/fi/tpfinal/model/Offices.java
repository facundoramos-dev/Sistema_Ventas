package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Offices {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long officeCode;
	
	@NotNull(message = "El campo city no puede estar null")
	@Size(min = 3, max=10, message = "El campo city no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "city")
	private String city;
	
	@NotNull(message = "El campo phone no puede estar null")
	@Min(value=1, message = "El valor de la phone debe ser igual o superior a 1")
	@Column (name = "phone")
	private	String phone; 
	
	@NotNull(message = "El campo addressLine1 no puede estar null")
	@Size(min = 3, max=10, message = "El campo addressLine1 no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "addressLine1")
	private String addressLine1;
	
	@NotNull(message = "El campo addressLine2 no puede estar null")
	@Size(min = 3, max=10, message = "El campo addressLine2 no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "addressLine2")
	private String addressLine2;
	
	@NotNull(message = "El campo state no puede estar null")
	@Size(min = 3, max=10, message = "El campo state no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "state")
	private	String state;
	
	@NotNull(message = "El campo state no puede estar null")
	@Size(min = 3, max=10, message = "El campo state no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "country")
	private	String country; 
	
	@NotNull(message = "El campo state no puede estar null")
	@Size(min = 3, max=10, message = "El campo state no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "postalCode")
	private	String postalCode; 
	
	@NotNull(message = "El campo territory no puede estar null")
	@Size(min = 3, max=10, message = "El campo territory no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "territory")
	private String territory;

	
	public Offices() {
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
		return "Offices [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", territory=" + territory + "]";
	}
	
	

}
