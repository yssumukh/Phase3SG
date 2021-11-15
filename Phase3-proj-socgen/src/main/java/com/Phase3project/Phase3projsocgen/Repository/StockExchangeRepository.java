package com.Phase3project.Phase3projsocgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Phase3project.Phase3projsocgen.Entity.StockExchange;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {

	StockExchange findByName(String name);
}