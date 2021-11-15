package com.Phase3project.Phase3projsocgen.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Phase3project.Phase3projsocgen.Entity.Company;
import com.Phase3project.Phase3projsocgen.Entity.IPODetail;
import com.Phase3project.Phase3projsocgen.Entity.Sector;
import com.Phase3project.Phase3projsocgen.Repository.Companyrepository;
import com.Phase3project.Phase3projsocgen.Repository.IPOrepository;
import com.Phase3project.Phase3projsocgen.Repository.SectorRepository;

@Service
public class CompanyService {

	@Autowired
	private Companyrepository companyrepo;

	@Autowired
	private SectorRepository sectorrepo;

	@Autowired
	private IPOrepository iporepo;

	public List<Company> getCompanies() {
		List<Company> companies = companyrepo.findAll();
		return companies;
	}

	public Company findById(Long id) {
		Optional<Company> company = companyrepo.findById(id);
		if (!company.isPresent())
			return null;
		return company.get();
	}

	public IPODetail getCompanyIPODetails(Long id) {
		Optional<Company> company = companyrepo.findById(id);
		if (!company.isPresent())
			return null;
		IPODetail ipo = company.get().getIpo();
		return ipo;
	}

	public Object addCompany(Company company) {

		Sector sector = sectorrepo.findByName(company.getSectorname());
		if (sector == null)
			return null;
		company.setSector(sector);
		company = companyrepo.save(company);
		return company;
	}

	public void deleteCompany(long id) {
		companyrepo.deleteById(id);
	}

	public Company addIpoToCompany(String companyName, IPODetail ipo) {

		Company company = companyrepo.findByName(companyName);
		if (company == null)
			return null;
		ipo.setCompany(company);
		iporepo.save(ipo);

		company.setIpo(ipo);
		company = companyrepo.save(company);
		return company;
	}

}
