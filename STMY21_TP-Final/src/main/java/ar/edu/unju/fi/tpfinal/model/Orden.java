package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;

public class Orden {

	private int numOrden;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechOrden;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechRequerida;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechEnviada;
	private char[] estado;
	private String comentario;
	private Customer numCliente;
	
	public Orden() {
		// TODO Auto-generated constructor stub
	}

	public int getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(int numOrden) {
		this.numOrden = numOrden;
	}

	public LocalDate getFechOrden() {
		return fechOrden;
	}

	public void setFechOrden(LocalDate fechOrden) {
		this.fechOrden = fechOrden;
	}

	public LocalDate getFechRequerida() {
		return fechRequerida;
	}

	public void setFechRequerida(LocalDate fechRequerida) {
		this.fechRequerida = fechRequerida;
	}

	public LocalDate getFechEnviada() {
		return fechEnviada;
	}

	public void setFechEnviada(LocalDate fechEnviada) {
		this.fechEnviada = fechEnviada;
	}

	public char[] getEstado() {
		return estado;
	}

	public void setEstado(char[] estado) {
		this.estado = estado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Customer getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(Customer numCliente) {
		this.numCliente = numCliente;
	}

	@Override
	public String toString() {
		return "Orden [numOrden=" + numOrden + ", fechOrden=" + fechOrden + ", fechRequerida=" + fechRequerida
				+ ", fechEnviada=" + fechEnviada + ", estado=" + Arrays.toString(estado) + ", comentario=" + comentario
				+ "]";
	}
	
}
