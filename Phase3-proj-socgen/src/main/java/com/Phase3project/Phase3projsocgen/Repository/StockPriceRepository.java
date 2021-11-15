package com.Phase3project.Phase3projsocgen.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Phase3project.Phase3projsocgen.Entity.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {

	List<StockPrice> findByCodeAndName(String companycode, String exchangename);
}