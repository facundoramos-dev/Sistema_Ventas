package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class PaymentId implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name="customerNumber")
	private Customer customerNumber;
	
	@Column(name = "checkNumber")
	private long checkNumber;

	public PaymentId() {
		// TODO Auto-generated constructor stub
	}

	public PaymentId(Customer customerNumber, long checkNumber) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
	}

	public Customer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public long getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(long checkNumber) {
		this.checkNumber = checkNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}
