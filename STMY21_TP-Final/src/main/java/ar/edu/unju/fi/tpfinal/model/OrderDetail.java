package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "ORDERDETAILS")
@Component("orderDetailObj")
public class OrderDetail {

	@Id
	@NotNull(message = "El campo orderNumber no puede estar vacio")
	@Column (name = "orderNumber")
	private Order orderNumber;
	
	@Id
	@NotNull(message = "El campo productCode no puede estar vacio")
	@Size(max = 15, message = "Como maximo debe tener 15 caracteres")
	@Column (name = "productCode")
	private Product productCode;
	
	@NotNull(message = "El campo quantityOrdered no puede estar vacio")
	@Column (name = "quantityOrdered")
	private int quantityOrdered;
	
	@NotNull(message = "El campo priceEach no puede estar vacio")
	@Column (name = "priceEach")
	private double priceEach;
	
	@NotNull(message = "El campo orderLineNumber no puede estar vacio")
	@Column (name = "orderLineNumber")
	private short orderLineNumber;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public Order getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Order orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Product getProductCode() {
		return productCode;
	}

	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public short getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(short orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderNumber=" + orderNumber + ", productCode=" + productCode + ", quantityOrdered="
				+ quantityOrdered + ", priceEach=" + priceEach + ", orderLineNumber=" + orderLineNumber + "]";
	}
	
}
