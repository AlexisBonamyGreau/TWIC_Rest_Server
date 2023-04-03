package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList<Ville> getInfoVilles(String codePostal) throws SQLException {
		ArrayList<Ville> listVille;
		listVille = new ArrayList<Ville>();
		
		listVille = villeDAO.findAllVilles();
		
		return listVille;
	}

	@Override
	public ArrayList<Ville> getInfoVilles() throws SQLException {
		ArrayList<Ville> listVille;
		listVille = new ArrayList<Ville>();
		
		listVille = villeDAO.findAllVilles();
		
		return listVille;
	}

	@Override
	public void insertVille(String codeInsee, String nom, String codePostal, String libelle, String ligne,
			String latitude, String longitude) {
		villeDAO.insertVille(codeInsee, nom, codePostal, libelle, ligne, latitude, longitude);
	}

	@Override
	public void updateVille(String codeInsee, String nom, String codePostal, String libelle, String ligne,
			String latitude, String longitude) {
		villeDAO.updateVille(codeInsee, nom, codePostal, libelle, ligne, latitude, longitude);
	}

	@Override
	public void deleteVille(String codeInsee) {
		villeDAO.deleteVille(codeInsee);
	}
}
