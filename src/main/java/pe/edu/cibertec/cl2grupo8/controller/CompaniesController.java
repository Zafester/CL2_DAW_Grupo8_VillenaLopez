package pe.edu.cibertec.cl2grupo8.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.cl2grupo8.model.bd.Companies;
import pe.edu.cibertec.cl2grupo8.model.request.CompaniesRequest;
import pe.edu.cibertec.cl2grupo8.model.response.ResultadoResponse;
import pe.edu.cibertec.cl2grupo8.service.CompaniesService;

@Controller
@RequestMapping("/companies")
public class CompaniesController {
	@Autowired
	private CompaniesService companiesService;
	@GetMapping("/frmcompanies")
	public String frmCrudCompanies(Model model) {
		model.addAttribute("listacompanies", companiesService.listarCompanies());
		return "companies/frmcompanies";
	}
	
	@PostMapping("/registrarCompanies")
	@ResponseBody
	public ResultadoResponse registrarCompanies(
			@RequestBody CompaniesRequest companiesRequest ){
		String mensaje = "La compañia se registro correctamente";
		Boolean respuesta = true;
		try {
			Companies objComp = new Companies();
			if(companiesRequest.getId_companies() > 0) {
				objComp.setId_company(companiesRequest.getId_companies());
			}
			objComp.setId_company(companiesRequest.getId_companies());
			objComp.setName_company(companiesRequest.getName_company());
			companiesService.registrarCompanies(objComp);
		} catch (Exception ex) {
			mensaje = "Compañia no registrada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
		
	}
	
	@DeleteMapping("/eliminarCompanie")
	@ResponseBody
	public ResultadoResponse eliminarCompanie(@RequestBody CompaniesRequest companiesRequest) {
		String mensaje = "Companie Eliminada Correctamente";
		Boolean respuesta = true;
		try {
			companiesService.eliminarCompanies(companiesRequest.getId_companies());
		} catch (Exception e) {
			mensaje = "Companie no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@GetMapping("/listarCompanies")
	@ResponseBody
	public List<Companies> listarCompanies(){
		return companiesService.listarCompanies();
	}

}
