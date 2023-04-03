package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	
	public ArrayList<Ville> getInfoVilles(String codePostal) throws SQLException;
	public ArrayList<Ville> getInfoVilles() throws SQLException;
    public void insertVille(String codeInsee, String nom, String codePostal, String libelle, String ligne,
            String latitude, String longitude);
	public void updateVille(String codeInsee, String nom, String codePostal, String libelle, String ligne,
			String latitude, String longitude);
    public void deleteVille(String codeInsee);

}
