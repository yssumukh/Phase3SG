package com.Phase3project.Phase3projsocgen.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Phase3project.Phase3projsocgen.Entity.Company;
import com.Phase3project.Phase3projsocgen.Entity.CompanyCompareRequest;
import com.Phase3project.Phase3projsocgen.Entity.Companystockexchangemap;
import com.Phase3project.Phase3projsocgen.Entity.StockPrice;
import com.Phase3project.Phase3projsocgen.Repository.Companystockexchangemaprepository;
import com.Phase3project.Phase3projsocgen.Repository.StockPriceRepository;
import com.Phase3project.Phase3projsocgen.Service.StockPriceService;

@RestController
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
@RequestMapping("/stockprices")
public class StockPriceController {
	@Autowired
	StockPriceRepository stkpricerepo;
	@Autowired
	StockPriceService stkpriceservice;
	@Autowired
	Companystockexchangemaprepository cmpstkmaprepo;

	@RequestMapping(value = "/addstockprices", method = RequestMethod.POST)
	public ResponseEntity<List<StockPrice>> stockpriceapi(@RequestBody List<StockPrice> stockprices)
			throws ClassNotFoundException, IOException {
		List<StockPrice> stkprice = new ArrayList<StockPrice>();
		for (StockPrice stockprice : stockprices) {
			System.out.println(stockprice.toString());
			Companystockexchangemap csemap = cmpstkmaprepo.findByCodeAndName(stockprice.getCompanycode(),
					stockprice.getExchangename());
			Company company = csemap.getCompany();
			stockprice.setCompany(company);
			stockprice = stkpricerepo.save(stockprice);
			stkprice.add(stockprice);
		}

		return ResponseEntity.ok(stkprice);
	}

	@PostMapping(path = "/compareCompany")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<StockPrice>> companyComparison(@RequestBody CompanyCompareRequest compareRequest) {
		System.out.println(compareRequest.toString());
		List<StockPrice> stockPrice = stkpriceservice.getStockPricesForCompanyComparison(compareRequest);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		// System.out.println(stockPrice.toString());
		return ResponseEntity.ok(stockPrice);
	}

	@RequestMapping(value = "/getstockprices", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<StockPrice> getstockprice() throws ClassNotFoundException, IOException {

		List<StockPrice> stkprice = stkpricerepo.findAll();

		return stkprice;
	}

	@DeleteMapping(path = "/deleteAll")
	public void deleteAllPrices() {
		stkpricerepo.deleteAll();
	}

}