package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

// Detalles de pedido

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;   
import org.springframework.stereotype.Component;

@Entity
@Table (name = "ORDERDETAILS")
@Component("orderDetailObj")
public class OrderDetail implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderDetailId id;
	
	@NotNull(message = "El campo quantityOrdered no puede estar vacio")
	@Column (name = "quantityOrdered")
	private int quantityOrdered;
	
	@NotNull(message = "El campo priceEach no puede estar vacio")
	@Column (name = "priceEach")
	private double priceEach;
	
	@NotNull(message = "El campo orderLineNumber no puede estar vacio")
	@Column (name = "orderLineNumber")
	private short orderLineNumber;
	
	
	
	//Constructor
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	//Getters y Setters


	public OrderDetailId getId() {
		return id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "OrderDetail [id=" + id + ", quantityOrdered=" + quantityOrdered + ", priceEach=" + priceEach
				+ ", orderLineNumber=" + orderLineNumber + "]";
	}


	
}
