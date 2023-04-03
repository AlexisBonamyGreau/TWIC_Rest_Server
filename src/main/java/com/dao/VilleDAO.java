package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	public ArrayList<Ville> findAllVilles() throws SQLException;

    public void insertVille(String codeInsee, String nom, String codePostal, String libelle, String ligne,
            String latitude, String longitude);

    public void updateVille(String codeInsee, String nom, String codePostal, String libelle, String ligne,
            String latitude, String longitude);

    public void deleteVille(String codeInsee);
	
}
