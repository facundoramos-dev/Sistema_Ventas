package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.repository.IOfficeRepository;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Service("officeService")
public class OfficeServiceImp implements IOfficeService {

	@Autowired
	IOfficeRepository officeRepository;

	@Override
	public Office getOffice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Office getOfficePorCodigo(Long officeCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Office> getOffices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarOffice(Office office) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarOfficeEncontrado(Office office) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarOffice(Long officeCode) {
		// TODO Auto-generated method stub
		
	}
	
	
}
