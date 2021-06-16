package ar.edu.unju.fi.tpfinal.model;

import java.util.Arrays;

public class Product {

	private	char[] codProducto;
	private char[] nomProducto;
	private ProductLine linProducto;
	private char[] escProducto;
	private char[] vendProducto;
	private char[] descProducto;
	private short cantStock;
	private double precioCompra;
	private double msrp;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public char[] getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(char[] codProducto) {
		this.codProducto = codProducto;
	}

	public char[] getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(char[] nomProducto) {
		this.nomProducto = nomProducto;
	}

	public ProductLine getLinProducto() {
		return linProducto;
	}

	public void setLinProducto(ProductLine linProducto) {
		this.linProducto = linProducto;
	}

	public char[] getEscProducto() {
		return escProducto;
	}

	public void setEscProducto(char[] escProducto) {
		this.escProducto = escProducto;
	}

	public char[] getVendProducto() {
		return vendProducto;
	}

	public void setVendProducto(char[] vendProducto) {
		this.vendProducto = vendProducto;
	}

	public char[] getDescProducto() {
		return descProducto;
	}

	public void setDescProducto(char[] descProducto) {
		this.descProducto = descProducto;
	}

	public short getCantStock() {
		return cantStock;
	}

	public void setCantStock(short cantStock) {
		this.cantStock = cantStock;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	@Override
	public String toString() {
		return "Product [codProducto=" + Arrays.toString(codProducto) + ", nomProducto=" + Arrays.toString(nomProducto)
				+ ", linProducto=" + linProducto + ", escProducto=" + Arrays.toString(escProducto) + ", vendProducto="
				+ Arrays.toString(vendProducto) + ", descProducto=" + Arrays.toString(descProducto) + ", cantStock="
				+ cantStock + ", precioCompra=" + precioCompra + ", msrp=" + msrp + "]";
	}

}
