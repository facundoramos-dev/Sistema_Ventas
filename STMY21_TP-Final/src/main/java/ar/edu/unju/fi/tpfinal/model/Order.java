package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
	@NotNull(message = "El campo orderNumber no puede estar null")
	@Column (name = "")
	private int orderNumber;
	
	@NotNull(message = "El campo ordenDate no puede estar vacio")
	@Column (name = "ordenDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	
	@NotNull(message = "El campo requiredDate no puede estar vacio")
	@Column (name = "requiredDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate requiredDate;
	
	@Column (name = "shippedDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate shippedDate;
	
	@NotNull(message = "El campo status no puede estar vacio")
	@Size(max = 15, message = "Como maximo debe tener 15 caracteres")
	@Column (name = "status")
	private String status;
	
	@Column (name = "comments")
	private String comments;
	
	@Autowired
	@NotNull(message = "El campo customerNumber no puede estar vacio")
	@Column (name = "customerNumber")
	private Customer customerNumber;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
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

	public Customer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + "]";
	}

}
