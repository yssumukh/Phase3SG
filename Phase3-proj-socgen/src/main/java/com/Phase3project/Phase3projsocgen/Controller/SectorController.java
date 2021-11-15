package com.Phase3project.Phase3projsocgen.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Phase3project.Phase3projsocgen.Entity.Company;
import com.Phase3project.Phase3projsocgen.Entity.Sector;
import com.Phase3project.Phase3projsocgen.Repository.SectorRepository;
import com.Phase3project.Phase3projsocgen.Service.SectorService;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("/sectors")
public class SectorController {

	@Autowired
	private SectorService sectorService;
	@Autowired
	private SectorRepository secrepo;
	
	@GetMapping(path = "")
	public ResponseEntity<List<Sector>> findAll() {
		return ResponseEntity.ok(sectorService.findAll());
	}

	@GetMapping(path = "/{id}")
	 public ResponseEntity<Sector> findById(@PathVariable String id)

    {
        Optional<Sector> sectorDto = secrepo.findById(Long.valueOf(id));
//        if(sectorDto == null) {
//            throw new SectorNotFoundException("Sector not found for id : " + id);
//        }
        return ResponseEntity.ok(sectorDto.get());
    }

    @PostMapping(path = "")
    public ResponseEntity<Sector> save(@RequestBody Sector sectorDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(secrepo.save(sectorDto));
    }

    @PutMapping(path = "")
    public ResponseEntity<Sector> update(@RequestBody Sector sectorDto)
    {
        Sector updatedSectorDto = secrepo.save(sectorDto);
//        if(updatedSectorDto == null) {
//            throw new SectorNotFoundException("Sector not found for id : " + sectorDto.getId());
//        }
        return ResponseEntity.ok(updatedSectorDto);
    }

	
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable long id) {
		sectorService.deleteById(id);
	}

	@GetMapping(path = "/{id}/companies")
	public ResponseEntity<List<Company>> getCompanies(@PathVariable long id) {
		List<Company> companies = sectorService.getCompanies(id);

		return ResponseEntity.ok(companies);
	}

}
