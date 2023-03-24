package com.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	
	public ArrayList<Ville> findAllVilles() throws SQLException {
		System.out.println("findAllVilles");
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

	    try {
			 // Charger le pilote JDBC
			 Class.forName("org.mariadb.jdbc.Driver");
			
			 // Établir une connexion
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/villes", "root", "root");
			
			 // Créer une déclaration
			 stmt = conn.createStatement();
			
			 // Exécuter une requête
			 rs = stmt.executeQuery("SELECT * FROM ville_france;");
			
			 // Traiter les résultats
			 while (rs.next()) {
				 String code_insee = rs.getString("Code_commune_INSEE");
				 String nom = rs.getString("Nom_commune");
				 String code_postal = rs.getString("Code_postal");
				 String libelle = rs.getString("Libelle_acheminement");
				 String ligne = rs.getString("Ligne_5");
				 String latitude = rs.getString("Latitude");
				 String longitude = rs.getString("Longitude");
				 
				 Ville ville = new Ville();
				 ville.setCode_insee(code_insee);
				 ville.setNom(nom);
		 		 ville.setCode_postal(code_postal);
				 ville.setLibelle(libelle);
				 ville.setLigne(ligne);
				 ville.setLatitude(latitude);
				 ville.setLongitude(longitude);
						
				 listVille.add(ville);
			     }
			  } catch (SQLException ex) {
			     ex.printStackTrace();
			  } catch (ClassNotFoundException ex) {
			     ex.printStackTrace();
			  } finally {
			     // Fermer les ressources
		         try {
		            if (rs != null) rs.close();
		            if (stmt != null) stmt.close();
		            if (conn != null) conn.close();
		         } catch (SQLException ex) {
		            ex.printStackTrace();
		         }
		      }
	    
		return listVille;
	}
}
