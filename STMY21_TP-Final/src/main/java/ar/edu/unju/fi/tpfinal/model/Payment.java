package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "PAYMETS")
@Component("paymentObj")
public class Payment {

	@EmbeddedId
	private PaymentId id;
	
	@Column(name = "CheckNumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long checkNumber;
	
	@NotNull(message = "El campo paymentDate no puede estar vacio")
	@Column (name = "paymentDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	
	@NotNull(message = "El campo amount no puede estar vacio")
	@Column (name = "amount")
	private double amount;
		
	
	
	// Getters y Setters
	
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

	@Override
	public String toString() {
		return "Payment [id=" + id + ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}


	
}
