package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Embeddable
public class PaymentId implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@OneToOne
	@JoinColumn(name="customerNumber")
	private Customer customerNumber;
	
	@Column(name = "checkNumber")
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //solo sirve con entidaddes simples no incrustadas
	private Long checkNumber;

	public PaymentId() {
		// TODO Auto-generated constructor stub
	}

	public PaymentId(Customer customerNumber) {
		super();
		this.customerNumber = customerNumber;
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
