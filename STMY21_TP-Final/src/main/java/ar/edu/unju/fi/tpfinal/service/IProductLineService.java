package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineService {

	public ProductLine getProductLine();
	
	//Obtener todas las oficinas
	public List<ProductLine> getProductLines();
	
	public void agregarProductLine(ProductLine productLine);
	
	public void agregarProductLineEncontrado(ProductLine productLine);
	
	public void eliminarProductLine(String productLine);
	
	public ProductLine getProductLinePorCodigo(String productLine);
	
}
