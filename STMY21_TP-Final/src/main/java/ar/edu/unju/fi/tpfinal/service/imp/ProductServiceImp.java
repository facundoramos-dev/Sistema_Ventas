package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.repository.IProductRepository;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Service("productService")
public class ProductServiceImp implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
}
