package com.Phase3project.Phase3projsocgen.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.Phase3project.Phase3projsocgen.Entity.Companystockexchangemap;
import com.Phase3project.Phase3projsocgen.Entity.StockExchange;
import com.Phase3project.Phase3projsocgen.Repository.StockExchangeRepository;
import com.Phase3project.Phase3projsocgen.Service.CompanyService;
import com.Phase3project.Phase3projsocgen.Service.StockExchangeService;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("/stockexchanges")
public class StockExchangeController {
	@Autowired
	private StockExchangeService stockexchangeservice;
	
	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	@GetMapping(path = "")
	public ResponseEntity<List<StockExchange>> getStockExchanges() {
		return ResponseEntity.ok(stockexchangeservice.getStockExchanges());
	}

	@PostMapping(path = "")
	public ResponseEntity<?> addStockExchange(@RequestBody StockExchange stockexchange) {
		return ResponseEntity.ok(stockexchangeservice.addStockExchange(stockexchange));
	}

	@GetMapping(path = "/{id}/companies")
	public ResponseEntity<List<Company>> getAllCompanies(@PathVariable long id) {
		return ResponseEntity.ok(stockexchangeservice.getAllCompanies(id));
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteCompany(@PathVariable long id) {
		stockExchangeRepository.deleteById(id);
		
	}

}
