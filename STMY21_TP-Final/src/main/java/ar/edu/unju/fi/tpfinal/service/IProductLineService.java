package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineService {

	public ProductLine getProductLine();
	
	public List<ProductLine> getProductLines();
	
	public void agregarProductLine(ProductLine productLine);
	
	public void agregarProductLineEncontrado(ProductLine productLine);
	
	public void eliminarProductLine(Long id);
	
	public Optional<ProductLine> getProductLinePorCodigo(Long id);
	
}
