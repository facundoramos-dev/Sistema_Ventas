package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class PaymentId implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name="customer_Number")
	private Customer customerNumber;
	
	@JoinColumn(name = "check_Number")
	private Long checkNumber;

	public PaymentId() {
		// TODO Auto-generated constructor stub
	}

	public PaymentId(Customer customerNumber, Long checkNumber) {
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

	public Long getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(Long checkNumber) {
		this.checkNumber = checkNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
