package pe.edu.cibertec.cl2grupo8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.cl2grupo8.model.bd.Companies;
import pe.edu.cibertec.cl2grupo8.repository.CompaniesRepository;

@Service
public class CompaniesService {
	@Autowired
	private CompaniesRepository companiesRepository;
	public List<Companies> listarCompanies(){
		return companiesRepository.findAll();
	}
	public void registrarCompanies(Companies companies) {
		companiesRepository.save(companies);
	}
	public void eliminarCompanies(Integer id_companies) {
		companiesRepository.deleteById(id_companies);
	}
}
