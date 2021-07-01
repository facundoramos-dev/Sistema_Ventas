package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Product;

public interface IProductService {

	public Product getProduct();
	
	//Obtener todas las oficinas
	public List<Product> getProducts();
	
	public void agregarProduct(Product product);
	
	public void agregarProductEncontrado(Product product);
	
	public void eliminarProduct(Long productCode);
	
	public Product getProductPorCodigo(Long productCode);
	
	public Optional<Product> getProductPorCodigoId(Long productCode);
	
	public void cacheProducto(List<Product> productos);
	
	public List<Product> obtenerCache();
	
	public void vaciarCacheProducto();

	public List<Product> selecionarProductos(List<String> valores);
	
}
