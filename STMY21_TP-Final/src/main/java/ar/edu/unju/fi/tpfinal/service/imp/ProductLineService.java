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
	ProductLine productLineObj;
	
	@Override
	public ProductLine getProductLine() {
		return productLineObj;
	}

	@Override
	public List<ProductLine> getProductLines(String productLine) {
		List<ProductLine> productLines =(List<ProductLine>) productLineRepository.findAll();
		return productLines;
	}

	@Override
	public void agregarProductLine(ProductLine productLine) {
		productLineRepository.save(productLine);
	}

	@Override
	public void agregarProductLineEncontrado(ProductLine productLine) {
		List<ProductLine> ProductLineEncontrado = new ArrayList<ProductLine>(); 
		ProductLineEncontrado.add(productLine);
	}

	@Override
	public void eliminarProductLine(String productLine) {
		productLineRepository.deleteById(productLine);
		
	}

	@Override
	public ProductLine getProductLinePorCodigo(String productLine) {
		this.productLineObj = productLineRepository.findByProductLine(productLine);
		return this.productLineObj;
	}

}
