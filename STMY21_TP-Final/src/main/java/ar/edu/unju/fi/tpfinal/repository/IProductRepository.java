package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tpfinal.model.Product;


public interface IProductRepository extends JpaRepository<Product, Long>{

	/**
	 * Encuentra un producto por su codigo de producto
	 * @param productCode
	 * @return Objeto producto
	 */
	public Product findByProductCode(Long productCode);
}
