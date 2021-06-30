package ar.edu.unju.fi.tpfinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Clase Customer representa a un Cliente
 *
 */
@Entity /* Especifica que la clase es una entidad */
@Table (name = "CUSTOMERS") /* Especifica la tabla principal, llamada CUSTOMERS */
@Component("customerObj") /* Indica que la clase anotada es un componente*/
public class Customer {
	
	@Id  /* Expecifica al atributo CustomerNumber como clave primaria*/
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* GeneratedValue Provee la estrategia de valores de las claves primaria */
	private Long customerNumber;						

	@NotEmpty(message = "Este campo customerName no puede estar vacio") /*Etiquetas de validacion de datos */
	@Size(min = 1, max = 50, message = "El maximo es de 50 caracteres")
	@Column(name = "customerName")										/* Nombre de la columna para este atributo */
	private String customerName;
	
	@NotEmpty(message = "Este campo contactLastName no puede estar vacio")
	@Size(min = 1, max = 50, message = "El maximo es de 50 caracteres")
	@Column(name = "contactLastName")									
	private String contactLastName;
	
	@NotEmpty(message = "Este campo contactFirstName no puede estar vacio")
	@Size(min = 1, max=50, message = "El maximo es de 50 caracteres")
	@Column(name = "contactFirstName")
	private String contactFirstName;
	
	@NotEmpty(message = "El campo phone no puede estar vacio")
	@Size(min = 1, max=50, message = "El maximo es de 50 caracteres")
	@Column(name = "phone")
	private	String phone; 
	
	@NotEmpty(message = "El campo addressLine1 no puede estar vacio")
	@Size(min = 1, max=50, message = "El maximo es de 50 caracteres")
	@Column(name = "addressLine1")
	private String addressLine1;
	
	@Size(min = 0, max=50, message = "El maximo es de 50 caracteres")
	@Column(name = "addressLine2")
	private String addressLine2;
	
	@NotEmpty(message = "El campo city no puede estar vacio")
	@Size(min = 1, max=50, message = "El maximo es de 50 caracteres")
	@Column(name = "city")
	private String city;
	
	@Size(min = 0, max=50, message = "El maximo es de 50 caracteres")
	@Column(name = "state")
	private	String state;
	
	@Size(min = 0, max=15, message = "El maximo es de 15 caracteres")
	@Column(name = "postalCode")
	private	String postalCode;
	
	@NotEmpty(message = "El campo state no puede estar vacio")
	@Size(min = 1, max=50, message = "El maximo es de 50 caracteres")	
	@Column(name = "country")
	private	String country;
	
	@Autowired															/* Inyeccion de dependencia */
	@ManyToOne(fetch=FetchType.LAZY)									/* Estrategia que define que los datos pueden*/
	@JoinColumn(name = "salesRepEmployeeNumber")						/* recuperarse de forma perezosa		*/
	private Employee employee;
	
	@Column(name = "creditLimit", columnDefinition = "DECIMAL(10,2)")	/* Permite definir el valor por defecto  */
	private double creditLimit;
	
	@Autowired
	@OneToMany( mappedBy = "customer1" )								/* Relacion de uno a muchos  Entre Customer y Order*/
	private List<Order> orders = new ArrayList<Order>();				/* Customer puede tener mas de una order */
																		/* Por ello se creo una lista con ordenes*/
	
	/**
	 * Constructor sin parametros
	 */
	public Customer() {
	}

	
	/**
	 * Getters y Setters
	 * 
	 */
	
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	/**
	 * Metodo toString , nos permite recuperar por consola un objeto tipo Customer
	 * 
	 */

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName="
				+ contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", country=" + country + ", employee=" + employee + ", creditLimit="
				+ creditLimit + ", orders=" + orders + "]";
	}

}	