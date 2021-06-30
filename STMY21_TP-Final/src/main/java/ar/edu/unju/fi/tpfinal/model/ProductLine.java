package ar.edu.unju.fi.tpfinal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "PRODUCTLINES")
@Component("productLineObj")
public class ProductLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "productLine")
	private	String productLineName;
	
	@Size(min = 0,max = 4000, message = "El maximo es de 4000 caracteres")
	@Column (name = "textDescription")
	private String textDescription;
	
	@Column (name = "htmlDescription",columnDefinition = "MEDIUMTEXT")
	private String htmlDescription;
	
	@Lob
	@Column (name = "image",columnDefinition = "MEDIUMBLOB")
	private byte[] image;
	
	@Autowired 
	@OneToMany(mappedBy = "productLine" ,fetch=FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	public ProductLine() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductLineName() {
		return productLineName;
	}

	public void setProductLineName(String productLineName) {
		this.productLineName = productLineName;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductLine [id=" + id + ", productLineName=" + productLineName + ", textDescription=" + textDescription
				+ ", htmlDescription=" + htmlDescription + ", image=" + Arrays.toString(image) + ", products="
				+ products + "]";
	}
	
}
