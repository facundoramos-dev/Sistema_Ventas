package ar.edu.unju.fi.tpfinal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Office;

public interface IOfficeRepository extends CrudRepository<Office, Long> {

	public Optional<Office> findByOfficeCode(Long officeCode);
	
}
