package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "CUSTOMERS")
@Component("customersObj")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerNumber;

	@NotNull(message = "Este campo customerName no puede estar null")
	@Size(min = 3, message = "El customerName no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "customerName")
	private String customerName;
	
	@NotNull(message = "Este campo contactLastName no puede estar null")
	@Size(min = 3, message = "El contactLastName no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "contactLastName")
	private String contactLastName;
	
	@NotNull(message = "Este campo contactFirstName no puede estar null")
	@Size(min = 3, message = "El contactFirstName no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "contactFirstName")
	private String contactFirstName;
	
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
	
	@NotNull(message = "El campo city no puede estar null")
	@Size(min = 3, max=10, message = "El campo city no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "city")
	private String city;
	
	@NotNull(message = "El campo state no puede estar null")
	@Size(min = 3, max=10, message = "El campo state no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "state")
	private	String state;
	
	@NotNull(message = "El campo state no puede estar null")
	@Size(min = 3, max=10, message = "El campo state no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "postalCode")
	private	String postalCode;
	
	@NotNull(message = "El campo state no puede estar null")
	@Size(min = 3, max=10, message = "El campo state no debe ser vacío, como mínimo debe tener 3 caracteres")
	@Column (name = "country")
	private	String country;
	
	@ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber")
    private Employees employees;
	
	@NotNull(message = "El campo creditLimit no puede estar null")
	@Min(value=1, message = "El valor de la creditLimit debe ser decimal")
	@Column (name = "creditLimit")
	private float creditLimit;

	
	public Customers() {
		// TODO Auto-generated constructor stub

	}


	public Long getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getContactLastName() {
		return contactLastName;
	}


	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}


	public String getContactFirstName() {
		return contactFirstName;
	}


	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public float getCreditLimit() {
		return creditLimit;
	}


	public void setCreditLimit(float creditLimit) {
		this.creditLimit = creditLimit;
	}


	@Override
	public String toString() {
		return "Customers [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName="
				+ contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", country=" + country + ", creditLimit=" + creditLimit + "]";
	}
	
}	
	