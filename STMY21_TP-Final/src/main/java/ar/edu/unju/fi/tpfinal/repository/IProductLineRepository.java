package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.tpfinal.model.ProductLine;

public interface IProductLineRepository extends JpaRepository<ProductLine, Long>{

	/**
	 * Encuentra un objeto Linea de producto por su id
	 * @param id
	 * @return ProductLine
	 */
	public ProductLine findByid (Long id);
}
