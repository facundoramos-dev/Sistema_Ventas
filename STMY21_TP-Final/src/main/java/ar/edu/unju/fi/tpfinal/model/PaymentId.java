package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Embeddable
public class PaymentId implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinColumn(name="customerNumber")
	private Customer customerNumber;
	
	@ManyToMany
	@JoinColumn(name="checkNumber")
	private Payment checkNumber;

	
	// Constructor
	public PaymentId(Customer customerNumber, Payment checkNumber) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
	}

	public PaymentId() {
		super();
	}
	
	// Getters y Setters

	public Customer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Payment getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(Payment checkNumber) {
		this.checkNumber = checkNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
