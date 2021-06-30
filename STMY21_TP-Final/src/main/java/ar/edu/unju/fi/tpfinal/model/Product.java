package ar.edu.unju.fi.tpfinal.model;

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
import org.springframework.stereotype.Component;

/**
 * 
 * Clase Product representa un Producto
 * 
 */
@Entity
@Table (name = "PRODUCTS")
@Component("productObj")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	Long productCode;
	
	@NotEmpty(message = "El campo productName no puede estar vacio")
	@Size(max = 70, message = "El maximo es de 70 caracteres")
	@Column (name = "productName")
	private String productName;
	
	@Autowired
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name = "productLine_id")
	private ProductLine productLine ;
	
	@NotEmpty(message = "El campo productScale no puede estar vacio")
	@Size(max = 10, message = "El maximo es de 10 caracteres")
	@Column (name = "productScale")
	private String productScale;

	@NotEmpty(message = "El campo productVendor no puede estar vacio")
	@Size(max = 50, message = "El maximo es de 50 caracteres")
	@Column (name = "productVendor")
	private String productVendor;

	@NotEmpty(message = "El campo productDescription no puede estar vacio")
	@Column (name = "productDescription", columnDefinition = "TEXT")
	private String productDescription;
	
	@NotNull(message="El campo quantityInStock no puede estar vacio")
	@Column (name = "quantityInStock")
	private Short quantityInStock;
	
	@NotNull(message="El campo buyPrice no puede estar vacio")
	@Column (name = "buyPrice", columnDefinition = "DECIMAL(10,2)")
	private Double buyPrice;
	
	//	Manufacturer's Suggested Retail Price = Precio de venta sugerido por el fabricante 
	@NotNull(message="El campo MSRP no puede estar vacio")
	@Column (name = "MSRP")
	private Double msrp;
	
	
	/**
	 * Constructor 
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getters y Setters
	 */
	public Long getProductCode() {
		return productCode;
	}

	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductLine getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Short getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Short quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}	

	public Double getMsrp() {
		return msrp;
	}

	public void setMsrp(Double msrp) {
		this.msrp = msrp;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productLine=" + productLine
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", productDescription="
				+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", MSRP="
				+ msrp + "]";
	}

}