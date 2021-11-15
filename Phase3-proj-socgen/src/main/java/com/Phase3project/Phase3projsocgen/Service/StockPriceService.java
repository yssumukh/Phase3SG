package com.Phase3project.Phase3projsocgen.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Phase3project.Phase3projsocgen.Entity.CompanyCompareRequest;
import com.Phase3project.Phase3projsocgen.Entity.Companystockexchangemap;
import com.Phase3project.Phase3projsocgen.Entity.StockPrice;
import com.Phase3project.Phase3projsocgen.Repository.Companystockexchangemaprepository;
import com.Phase3project.Phase3projsocgen.Repository.StockPriceRepository;

@Service
public class StockPriceService {

	@Autowired
	StockPriceRepository stkpricerepo;
	@Autowired
	Companystockexchangemaprepository csemaprepo;

	public List<StockPrice> getStockPricesForCompanyComparison(CompanyCompareRequest compareRequest) {
		
		Date fromDate = compareRequest.getFromPeriod();
		Date toDate = compareRequest.getToPeriod();
		System.out.println(compareRequest.getCompanyname() + compareRequest.getExchangename());
		Companystockexchangemap csemap = csemaprepo.findByCompanyNameAndExchangeName(compareRequest.getCompanyname(),
				compareRequest.getExchangename());
		System.out.println(csemap.toString());

		List<StockPrice> stockPrices = stkpricerepo.findByCodeAndName(csemap.getCompanycode(),
				csemap.getStockexchangename());
		System.out.println(stockPrices.toString());
		List<StockPrice> filteredList = stockPrices.stream().filter(stockPrice -> {
			Date date = null;
			date = stockPrice.getDatee();

			return date.after(fromDate) && date.before(toDate);
		}).collect(Collectors.toList());
		return filteredList;
	}

}
