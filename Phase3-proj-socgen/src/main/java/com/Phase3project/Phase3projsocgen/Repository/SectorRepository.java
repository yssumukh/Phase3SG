package com.Phase3project.Phase3projsocgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Phase3project.Phase3projsocgen.Entity.Sector;


@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
	
	Sector findByName(String Name);

}