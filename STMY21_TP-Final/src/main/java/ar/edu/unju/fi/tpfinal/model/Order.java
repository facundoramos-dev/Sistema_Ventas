package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "ORDENS")
@Component("ordenObj")
public class Orden {

	@Id
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "")
	private int ordenNumber;
	
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "ordenDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ordenDate;
	
	@Column (name = "requiredDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate requiredDate;
	
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "shippedDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate shippedDate;
	
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "status")
	private String status;
	
	@Column (name = "comments")
	private String comments;
	
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "customerNumber")
	private Customer customerNumber;
	
	public Orden() {
		// TODO Auto-generated constructor stub
	}

	public int getOrdenNumber() {
		return ordenNumber;
	}

	public void setOrdenNumber(int ordenNumber) {
		this.ordenNumber = ordenNumber;
	}

	public LocalDate getOrdenDate() {
		return ordenDate;
	}

	public void setOrdenDate(LocalDate ordenDate) {
		this.ordenDate = ordenDate;
	}

	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(LocalDate requiredDate) {
		this.requiredDate = requiredDate;
	}

	public LocalDate getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(LocalDate shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public String toString() {
		return "Orden [ordenNumber=" + ordenNumber + ", ordenDate=" + ordenDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + "]";
	}
	
}
