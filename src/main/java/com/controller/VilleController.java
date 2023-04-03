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
public class VilleController {
	
	@Autowired
	VilleBLO villeBLOService;


	// Method GET without filter
	@RequestMapping(value="/all-villes", method=RequestMethod.GET)
	public ArrayList<Ville> getAll() throws SQLException {
		System.out.println("getAll");
		
		return villeBLOService.getInfoVilles();
	}

	// Method GET with filter on codeInsee
	@RequestMapping(value="/villes", method=RequestMethod.GET)
	public Ville get(@RequestParam(required=false, value="codeInsee") String codeInsee) throws SQLException {
		System.out.println("get : " + codeInsee);
		
		ArrayList<Ville> listVille = villeBLOService.getInfoVilles(codeInsee);
		for (int i=0; i<listVille.size(); i++) {
			if (listVille.get(i).getCode_insee().equals(codeInsee)) {
				return listVille.get(i);
			}
		}
		return null;
	}

	// Method POST
	@RequestMapping(value="/villes", method=RequestMethod.POST)
	public void post(@RequestParam(required=false, value="codeInsee") String codeInsee,
			@RequestParam(required=false, value="nom") String nom,
			@RequestParam(required=false, value="codePostal") String codePostal,
			@RequestParam(required=false, value="libelle") String libelle,
			@RequestParam(required=false, value="ligne") String ligne,
			@RequestParam(required=false, value="latitude") String latitude,
			@RequestParam(required=false, value="longitude") String longitude) throws SQLException {
		System.out.println("post : " + codeInsee + " " + nom + " " + codePostal + " " + libelle + " " + ligne + " " + latitude + " " + longitude);
		
		villeBLOService.insertVille(codeInsee, nom, codePostal, libelle, ligne, latitude, longitude);
	}

	// Method PUT (update)
	@RequestMapping(value="/villes", method=RequestMethod.PUT)
	public void put(@RequestParam(required=false, value="codeInsee") String codeInsee,
			@RequestParam(required=false, value="nom") String nom,
			@RequestParam(required=false, value="codePostal") String codePostal,
			@RequestParam(required=false, value="libelle") String libelle,
			@RequestParam(required=false, value="ligne") String ligne,
			@RequestParam(required=false, value="latitude") String latitude,
			@RequestParam(required=false, value="longitude") String longitude) throws SQLException {
		System.out.println("put : " + codeInsee + " " + nom + " " + codePostal + " " + libelle + " " + ligne + " " + latitude + " " + longitude);
		
		villeBLOService.updateVille(codeInsee, nom, codePostal, libelle, ligne, latitude, longitude);
	}

	// Method DELETE
	@RequestMapping(value="/villes", method=RequestMethod.DELETE)
	public void delete(@RequestParam(required=false, value="codeInsee") String codeInsee) throws SQLException {
		System.out.println("delete : " + codeInsee);
		
		villeBLOService.deleteVille(codeInsee);
	}
}
