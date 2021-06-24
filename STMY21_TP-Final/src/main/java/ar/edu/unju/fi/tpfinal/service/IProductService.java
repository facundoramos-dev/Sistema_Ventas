package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Product;

public interface IProductService {

	public Product getProduct();
	
	//Obtener todas las oficinas
	public List<Product> getProducts();
	
	public void agregarProduct(Product product);
	
	public void agregarProductEncontrado(Product product);
	
	public void eliminarProduct(String productCode);
	
	public Product getProductPorCodigo(String productCode);
	
}
