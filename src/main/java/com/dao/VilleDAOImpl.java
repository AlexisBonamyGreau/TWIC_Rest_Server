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
			 Class.forName("org.mariadb.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/villes", "root", "root");
			 stmt = conn.createStatement();
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

	@Override
	public void insertVille(String codeInsee, String nom, String codePostal, String libelle, String ligne,
			String latitude, String longitude) {
		System.out.println("insertVille");

		Connection conn = null;
        Statement stmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/villes", "root", "root");
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) VALUES ('" + codeInsee + "', '" + nom + "', '" + codePostal + "', '" + libelle + "', '" + ligne + "', '" + latitude + "', '" + longitude + "');");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void updateVille(String codeInsee, String nom, String codePostal, String libelle, String ligne,
			String latitude, String longitude) {
		System.out.println("updateVille");

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/villes", "root", "root");
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE ville_france SET Nom_commune = '" + nom + "', Code_postal = '" + codePostal + "', Libelle_acheminement = '" + libelle + "', Ligne_5 = '" + ligne + "', Latitude = '" + latitude + "', Longitude = '" + longitude + "' WHERE Code_commune_INSEE = '" + codeInsee + "';");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void deleteVille(String codeInsee) {
		System.out.println("deleteVille " + codeInsee);
	
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/villes", "root", "root");
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM ville_france WHERE Code_commune_INSEE = '" + codeInsee + "';");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
