package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "PRODUCTS")
@Component("productObj")
public class Product {

	@Id
	@NotNull(message = "El campo productCode no puede estar vacio")
	@Size(max = 15, message = "Como maximo debe tener 15 caracteres")
	@Column (name = "productCode")
	private	String productCode;
	
	@NotNull(message = "El campo productName no puede estar vacio")
	@Size(max = 70, message = "Como maximo debe tener 70 caracteres")
	@Column (name = "productName")
	private String productName;
	
	@Valid
	@Autowired
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn (name = "productLine")
	private ProductLine productLine;
	
	@NotNull(message = "El campo productScale no puede estar vacio")
	@Size(max = 10, message = "Como maximo debe tener 10 caracteres")
	@Column (name = "productScale")
	private String productScale;

	@NotNull(message = "El campo productVendor no puede estar vacio")
	@Size(max = 50, message = "Como maximo debe tener 50 caracteres")
	@Column (name = "productVendor")
	private String productVendor;

	@NotNull(message = "El campo productDescription no puede estar vacio")
	@Column (name = "productDescription")
	private String productDescription;

	@NotNull(message = "El campo quantityInStock no puede estar vacio")
	@Column (name = "quantityInStock")
	private short quantityInStock;

	@NotNull(message = "El campo buyPrice no puede estar vacio")
	@Column (name = "buyPrice")
	private double buyPrice;

	@NotNull(message = "El campo MSRP no puede estar vacio")
	@Column (name = "MSRP")
	private double MSRP;
	
	@Valid
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="orderLineNumber")
	OrderDetail orderDetail;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
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

	public short getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(short quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getMSRP() {
		return MSRP;
	}

	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productLine=" + productLine
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", productDescription="
				+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", MSRP="
				+ MSRP + "]";
	}
	
}
