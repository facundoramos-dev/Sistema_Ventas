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
@Table (name = "ORDERS")
@Component("orderObj")
public class Order {

	@Id
	@NotNull(message = "Este campo no puede estar vacio")
	@Column (name = "")
	private int orderNumber;
	
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "ordenDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	
	@Column (name = "requiredDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate requiredDate;
	
	@NotNull(message = "Este campo fecha no puede estar vacio")
	@Column (name = "shippedDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate shippedDate;
	
	@NotNull(message = "Este campo no puede estar vacio")
	@Column (name = "status")
	private String status;
	
	@Column (name = "comments")
	private String comments;
	
	@NotNull(message = "Este campo  no puede estar vacio")
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
