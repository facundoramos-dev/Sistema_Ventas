package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tpfinal.model.Product;


public interface IProductRepository extends JpaRepository<Product, Long>{

	public Product findByProductCode(Long productCode);
}
