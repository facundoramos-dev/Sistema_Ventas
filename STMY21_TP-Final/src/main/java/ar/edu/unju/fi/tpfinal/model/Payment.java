package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "PAYMENTS")
@Component("paymentObj")
public class Payment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PaymentId id;
	
	@NotNull(message = "El campo paymentDate no puede estar vacio")
	@Column(name = "paymentDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	
	@NotNull(message = "El campo amount no puede estar vacio")
	@Column(name = "amount", columnDefinition = "DECIMAL(10,2)")
	private double amount;
	
	
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public PaymentId getId() {
		return id;
	}

	public void setId(PaymentId id) {
		this.id = id;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}
	
}
