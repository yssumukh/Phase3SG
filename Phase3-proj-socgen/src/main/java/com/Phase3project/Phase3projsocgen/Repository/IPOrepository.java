package com.Phase3project.Phase3projsocgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Phase3project.Phase3projsocgen.Entity.IPODetail;

@Repository
public interface IPOrepository extends JpaRepository<IPODetail, Long> {

}
