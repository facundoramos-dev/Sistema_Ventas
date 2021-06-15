package ar.edu.unju.fi.tpfinal.model;

import java.util.Arrays;

public class ProductLine {
	
	private	char[] Linea;
	private char[] descripcionTexto;
	private String descripcionHtml;
	private byte[] imagen;
	
	public ProductLine() {
		// TODO Auto-generated constructor stub
	}

	public char[] getLinea() {
		return Linea;
	}

	public void setLinea(char[] linea) {
		Linea = linea;
	}

	public char[] getDescripcionTexto() {
		return descripcionTexto;
	}

	public void setDescripcionTexto(char[] descripcionTexto) {
		this.descripcionTexto = descripcionTexto;
	}

	public String getDescripcionHtml() {
		return descripcionHtml;
	}

	public void setDescripcionHtml(String descripcionHtml) {
		this.descripcionHtml = descripcionHtml;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "ProductLine [Linea=" + Arrays.toString(Linea) + ", descripcionTexto="
				+ Arrays.toString(descripcionTexto) + ", descripcionHtml=" + descripcionHtml + ", imagen="
				+ Arrays.toString(imagen) + "]";
	}
	
}
