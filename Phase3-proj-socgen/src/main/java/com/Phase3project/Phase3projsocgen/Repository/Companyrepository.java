package com.Phase3project.Phase3projsocgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Phase3project.Phase3projsocgen.Entity.Company;

@Repository
public interface Companyrepository extends JpaRepository<Company, Long> {
	
	Company findByName(String Name);

}