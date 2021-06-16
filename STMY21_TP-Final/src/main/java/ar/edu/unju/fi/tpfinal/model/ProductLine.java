package ar.edu.unju.fi.tpfinal.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "PRODUCTLINES")
@Component("productLineObj")
public class ProductLine {
	
	@Id
	@NotNull(message = "El campo productLine no puede estar vacio")
	@Size(max = 50, message = "Como maximo debe tener 50 caracteres")
	@Column (name = "productLine")
	private	String productLine;
	
	@Size(max = 4000, message = "Como maximo debe tener 4000 caracteres")
	@Column (name = "textDescription")
	private String textDescription;
	
	@Column (name = "htmlDescription")
	private String htmlDescription;
	
	@Column (name = "image")
	private byte[] image;
	
	public ProductLine() {
		// TODO Auto-generated constructor stub
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
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

	@Override
	public String toString() {
		return "ProductLine [productLine=" + productLine + ", textDescription=" + textDescription + ", htmlDescription="
				+ htmlDescription + ", image=" + Arrays.toString(image) + "]";
	}

}
