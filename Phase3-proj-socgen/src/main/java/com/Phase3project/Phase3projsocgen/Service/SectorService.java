package com.Phase3project.Phase3projsocgen.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Phase3project.Phase3projsocgen.Entity.Company;
import com.Phase3project.Phase3projsocgen.Entity.Sector;
import com.Phase3project.Phase3projsocgen.Repository.SectorRepository;

@Service
public class SectorService {
	
	@Autowired
	SectorRepository sectorrepo;

	public Sector findById(long id) {
		Optional<Sector> sector = sectorrepo.findById(id);
		if (!sector.isPresent())
			return null;
		return sector.get();
	}

	public Sector save(Sector sector) {
		sectorrepo.save(sector);
		return sector;
	}

	public void deleteById(long id) {
		sectorrepo.deleteById(id);

	}

	public List<Company> getCompanies(long id) {
		Optional<Sector> sector = sectorrepo.findById(id);
		List<Company> companies = sector.get().getCompanies();
		return companies;
	}

	public List<Sector> findAll() {
		List<Sector> sectors = sectorrepo.findAll();
		return sectors;
	}

}
