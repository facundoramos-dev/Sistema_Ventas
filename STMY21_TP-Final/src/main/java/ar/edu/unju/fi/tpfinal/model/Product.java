package ar.edu.unju.fi.tpfinal.model;

import java.util.Arrays;

public class Product {

	private	char[] codigo;
	private char[] nombre;
	private ProductLine producto;
	private char[] escala;
	private char[] vendedor;
	private char[] descripcion;
	private short cantidad;
	private double precioCompra;
	private double msrp;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public char[] getCodigo() {
		return codigo;
	}

	public void setCodigo(char[] codigo) {
		this.codigo = codigo;
	}

	public char[] getNombre() {
		return nombre;
	}

	public void setNombre(char[] nombre) {
		this.nombre = nombre;
	}

	public ProductLine getProducto() {
		return producto;
	}

	public void setProducto(ProductLine producto) {
		this.producto = producto;
	}

	public char[] getEscala() {
		return escala;
	}

	public void setEscala(char[] escala) {
		this.escala = escala;
	}

	public char[] getVendedor() {
		return vendedor;
	}

	public void setVendedor(char[] vendedor) {
		this.vendedor = vendedor;
	}

	public char[] getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(char[] descripcion) {
		this.descripcion = descripcion;
	}

	public short getCantidad() {
		return cantidad;
	}

	public void setCantidad(short cantidad) {
		this.cantidad = cantidad;
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
		return "Product [codigo=" + Arrays.toString(codigo) + ", nombre=" + Arrays.toString(nombre) + ", producto="
				+ producto + ", escala=" + Arrays.toString(escala) + ", vendedor=" + Arrays.toString(vendedor)
				+ ", descripcion=" + Arrays.toString(descripcion) + ", cantidad=" + cantidad + ", precioCompra="
				+ precioCompra + ", msrp=" + msrp + "]";
	}
	
}
