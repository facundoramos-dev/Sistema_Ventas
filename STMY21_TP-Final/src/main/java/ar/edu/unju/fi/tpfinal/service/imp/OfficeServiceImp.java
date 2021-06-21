package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.repository.IOfficeRepository;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Service("officeService")
public class OfficeServiceImp implements IOfficeService {

	@Autowired
	IOfficeRepository officeRepository;
	@Autowired
	Office office;

	@Override
	public Office getOffice() {
		// TODO Auto-generated method stub
		return office;
	}

	@Override
	public Optional<Office> getOfficePorCodigo(Long officeCode) {
		// TODO Auto-generated method stub
		Optional<Office> offices = officeRepository.findById(officeCode);
		return offices;
	}

	@Override
	public List<Office> getOffices() {
		// TODO Auto-generated method stub
		List<Office> offices =(List<Office>) officeRepository.findAll();
		return offices;
	}

	@Override
	public void agregarOffice(Office office) {
		// TODO Auto-generated method stub
		officeRepository.save(office);
	}

	
	@Override
	public void agregarOfficeEncontrado(Office office) {
		// TODO Auto-generated method stub
		List<Office> officeEncontrado = new ArrayList<Office>(); 
		officeEncontrado.add(office);
		
	}

	@Override
	public void eliminarOffice(Long officeCode) {
		// TODO Auto-generated method stub
		officeRepository.deleteById(officeCode);
	}
	
	
}
