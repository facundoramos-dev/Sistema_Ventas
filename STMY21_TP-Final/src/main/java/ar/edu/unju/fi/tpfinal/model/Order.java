package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "ORDERS")
@Component("orderObj")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderNumber;
	
	@NotNull(message = "El campo ordenDate no puede estar vacio")
	@Column (name = "ordenDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	
	@NotNull(message = "El campo requiredDate no puede estar vacio")
	@Column (name = "requiredDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate requiredDate;
	
	@NotNull(message = "El campo shippedDate no puede estar vacio")
	@Column (name = "shippedDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate shippedDate;
	
	@NotEmpty(message = "El campo status no puede estar vacio")
	@Size(min = 1, max = 15, message = "El maximo es de 15 caracteres")
	@Column (name = "status")
	private String status;
	
	@NotEmpty(message = "El campo comments no puede estar vacio")
	@Size(min = 1, max = 15, message = "El maximo es de 15 caracteres")
	@Column (name = "comments", columnDefinition = "TEXT")
	private String comments;
	
	@Autowired
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "customerNumber")
	private Customer customer1;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
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

	public Customer getCustomer1() {
		return customer1;
	}

	public void setCustomer1(Customer customer1) {
		this.customer1 = customer1;
	}

	
	
	
}
	