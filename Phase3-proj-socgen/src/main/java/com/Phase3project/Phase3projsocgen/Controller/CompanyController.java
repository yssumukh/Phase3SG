package com.Phase3project.Phase3projsocgen.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Phase3project.Phase3projsocgen.Entity.Company;
import com.Phase3project.Phase3projsocgen.Entity.IPODetail;
import com.Phase3project.Phase3projsocgen.Entity.Sector;
import com.Phase3project.Phase3projsocgen.Service.CompanyService;
import com.Phase3project.Phase3projsocgen.Repository.Companyrepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/companies")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@GetMapping(path = "")
	public ResponseEntity<List<Company>> getCompanies() {
		return ResponseEntity.ok(companyService.getCompanies());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Company> getCompanyDetails(@PathVariable Long id) {
		Company company = companyService.findById(id);
		return ResponseEntity.ok(company);
	}

	@GetMapping(path = "/{id}/ipos")
	public ResponseEntity<IPODetail> getCompanyIpoDetails(@PathVariable Long id) {
		IPODetail ipo = companyService.getCompanyIPODetails(id);
		return ResponseEntity.ok(ipo);
	}

	@PostMapping(path = "")
	public ResponseEntity<?> addCompany(@RequestBody Company company) {
		return ResponseEntity.ok(companyService.addCompany(company));
	}

	@DeleteMapping(path = "/{id}")
	public void deleteCompany(@PathVariable long id) {
		companyService.deleteCompany(id);
	}

	@PostMapping(path = "/{companyName}/ipos")
	public void addIpoToCompany(@PathVariable String companyName, @RequestBody IPODetail ipo) {
		Company company = companyService.addIpoToCompany(companyName, ipo);
		/*
		 * if(company == null) { throw new CompanyException("Company not with name : " +
		 * companyName); }
		 */
	}

}