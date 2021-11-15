package com.Phase3project.Phase3projsocgen.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Phase3project.Phase3projsocgen.Entity.IPODetail;
import com.Phase3project.Phase3projsocgen.Repository.IPOrepository;

@Service
public class IPOService {

	@Autowired
	private IPOrepository iporepo;

	public List<IPODetail> getAllIPO() {
		List<IPODetail> ipos = iporepo.findAll();
		return ipos;
	}

}
