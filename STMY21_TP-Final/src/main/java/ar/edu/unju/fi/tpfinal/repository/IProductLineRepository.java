package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineRepository extends JpaRepository<ProductLine, String>{

	public ProductLine findByProductLine (String productLine);
}
