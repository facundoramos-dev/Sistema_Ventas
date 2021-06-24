package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.repository.IProductRepository;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Service("productService")
public class ProductServiceImp implements IProductService {

	@Autowired
	IProductRepository productRepository;

	@Autowired
	Product product;
	
	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> products =(List<Product>) productRepository.findAll();
		return products;
	}

	@Override
	public void agregarProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void agregarProductEncontrado(Product product) {
		List<Product> ProductEncontrado = new ArrayList<Product>(); 
		ProductEncontrado.add(product);
	}

	@Override
	public void eliminarProduct(String productCode) {
		productRepository.deleteById(productCode);
		
	}

	@Override
	public Product getProductPorCodigo(String productCode) {
		
		product = productRepository.findByProductCode(productCode);
		return null;
	}
	
}
