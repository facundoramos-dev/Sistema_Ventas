package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 

/**
 * 
 * Clase que contiene las claves primarias de OrderDetail/ Detalle de orden
 *
 */

@Embeddable												/* Especifica una clase cuyas instancias se almacenan como */
public class OrderDetailId implements Serializable {	/* parte instrinseca de una entidad propietaria */

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "productCode")
	private Product productCode;
	
	@ManyToOne
	@JoinColumn(name = "orderNumber")
	private Order orderNumber;
	
	
/**
 * Constructores
 */
	public OrderDetailId() {
	}

	public OrderDetailId(Product productCode, Order orderNumber) {
		super();
		this.productCode = productCode;
		this.orderNumber = orderNumber;
	}

/**
 * Getters y Setters
 * 
 */
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
