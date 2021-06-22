package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.repository.IProductLineRepository;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@Service("productLineService")
public class ProductLineService implements IProductLineService {

	@Autowired
	IProductLineRepository productLineRepository;

	@Autowired
	ProductLine productLine;
	
	@Override
	public ProductLine getProductLine() {
		// TODO Auto-generated method stub
		return productLine;
	}

	@Override
	public List<ProductLine> getProductLines(String productLine) {
		// TODO Auto-generated method stub
		List<ProductLine> productLines =(List<ProductLine>) productLineRepository.findAll();
		return productLines;
	}

	@Override
	public void agregarProductLine(ProductLine productLine) {
		// TODO Auto-generated method stub
		productLineRepository.save(productLine);
	}

	@Override
	public void agregarProductLineEncontrado(ProductLine productLine) {
		// TODO Auto-generated method stub
		List<ProductLine> ProductLineEncontrado = new ArrayList<ProductLine>(); 
		ProductLineEncontrado.add(productLine);
	}

}
