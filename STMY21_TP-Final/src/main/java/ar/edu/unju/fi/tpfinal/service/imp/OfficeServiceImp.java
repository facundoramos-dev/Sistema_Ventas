package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Office;
import ar.edu.unju.fi.tpfinal.repository.IOfficeRepository;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Service("officeService")
public class OfficeServiceImp implements IOfficeService {

	private static final Log LOGGER = LogFactory.getLog(OfficeServiceImp.class);
	
	List<Office> officeEncontrado = new ArrayList<Office>(); 
	
	@Autowired
	private IOfficeRepository officeRepository;
	@Autowired
	private Office office;

	@Override
	public Office getOffice() {
		LOGGER.info("METHOD: getOffice - devuelve un objeto Office");
		
		return office;
	}

	@Override
	public Optional<Office> getOfficePorCodigo(Long officeCode) {
		LOGGER.info("METHOD: getOfficePorCodigo - busca y devuelve un objeto Office por su codigo de oficina");
		
		Optional<Office> office = officeRepository.findById(officeCode);
		return office;
	}

	@Override
	public List<Office> getOffices() {
		LOGGER.info("METHOD: getOffices - devuelve un listado de Office");
		
		List<Office> offices =(List<Office>) officeRepository.findAll();
		return offices;
	}

	@Override
	public void agregarOffice(Office office) {
		LOGGER.info("METHOD: agregarOffice - Objeto Office agregado");
		
		LOGGER.info("METHOD: ageOffice - devuelve un objeto Office");
		
		officeRepository.save(office);
	}

	@Override
	public void agregarOfficeEncontrado(Office office) {
		List<Office> officeEncontrado = new ArrayList<Office>(); 
		officeEncontrado.add(office);
	}

	@Override
	public void eliminarOffice(Long officeCode) {
		LOGGER.info("METHOD: eliminarOffice - objeto Office eliminado");
		
		officeRepository.deleteById(officeCode);
	}

	@Override
	public List<Office> obtenerOfficeEncontrado() {
		return officeEncontrado;
	}

	@Override
	public void quitarOfficeLista(Long officeCode) {
		for (int i=0; i < officeEncontrado.size(); i++) {
			if(officeEncontrado.get(i).getOfficeCode() == officeCode) {
				officeEncontrado.remove(i);
			}
		}
	}
	
}
