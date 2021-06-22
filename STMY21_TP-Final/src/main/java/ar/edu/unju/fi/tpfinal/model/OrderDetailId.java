package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class OrderDetailId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name = "productCode")
	private Product productCode;
	
	@OneToOne
	@JoinColumn(name = "orderNumber")
	private Order orderNumber;
	
	public OrderDetailId() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetailId(Product productCode, Order orderNumber) {
		super();
		this.productCode = productCode;
		this.orderNumber = orderNumber;
	}

	public Product getProductCode() {
		return productCode;
	}

	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	public Order getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Order orderNumber) {
		this.orderNumber = orderNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
