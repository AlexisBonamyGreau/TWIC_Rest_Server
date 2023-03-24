package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class Get_All {
	
	@Autowired
	VilleBLO villeBLOService;
	
	@RequestMapping(value="/villes", method=RequestMethod.GET)
	public Ville get(@RequestParam(required=false, value="codePostal") String codePostal) throws SQLException {
		System.out.println("get : " + codePostal);
		
		ArrayList<Ville> listVille = villeBLOService.getInfoVilles(codePostal);
		for (int i=0; i<listVille.size(); i++) {
			if (listVille.get(i).getCode_postal().equals(codePostal)) {
				return listVille.get(i);
			}
		}
		
		return null;
	}
}
