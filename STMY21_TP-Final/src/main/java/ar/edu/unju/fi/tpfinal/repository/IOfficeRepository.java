package ar.edu.unju.fi.tpfinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.tpfinal.model.Office;

public interface IOfficeRepository extends JpaRepository<Office, Long> {

	public Office findByOfficeCode(Long officeCode);
	
	public Optional<Office> findById(Long officeCode);
	
}
