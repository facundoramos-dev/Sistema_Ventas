package ar.edu.unju.fi.tpfinal.service.imp;

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

	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarProductEncontrado(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProduct() {
		// TODO Auto-generated method stub
		
	}
	
}
