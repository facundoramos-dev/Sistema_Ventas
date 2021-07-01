package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	@Autowired
	List<Product> productosCache;
	
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
	public void eliminarProduct(Long productCode) {
		productRepository.deleteById(productCode);
	}

	@Override
	public Product getProductPorCodigo(Long productCode) {
		Product product = productRepository.findByProductCode(productCode);
		return product;
	}

	@Override
	public Optional<Product> getProductPorCodigoId(Long productCode) {
		Optional<Product> product = productRepository.findById(productCode);
		return product;
	}

	@Override
	public void cacheProducto(List<Product> productos) {
		vaciarCacheProducto();
		if(productos.size()!=0) {
			for(int i=0;i<productos.size();i++) {
				productosCache.add(productos.get(i));
			}
		}
	}

	@Override
	public List<Product> obtenerCache() {
		return productosCache;
	}

	@Override
	public void vaciarCacheProducto() {
		int i=0;
		while(productosCache.size()!=0) {
			productosCache.remove(i);
			i++;
		}
	}
	
	@Override
	public List<Product> selecionarProductos(List<String> valores) {
		List<Product> productos = new ArrayList<Product>();
		for(int i=0;i<valores.size();i++) {
			productos.add(productRepository.findByProductCode(Long.parseLong(valores.get(i))));
		}
		return productos;
	}
	
}
