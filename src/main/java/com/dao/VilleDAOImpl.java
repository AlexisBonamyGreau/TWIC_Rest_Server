package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	
	public ArrayList<Ville> findAllVilles() throws SQLException {
		System.out.println("findAllVilles");
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
//		Connection conn = getConnection();
		
		Ville ville = new Ville();
		ville.setCode_insee("49007");
		ville.setNom("ANGERS");
		ville.setCode_postal("49000");
		ville.setLibelle("");
		ville.setLigne("");
		ville.setLatitude("");
		ville.setLongitude("");
		
		listVille.add(ville);
		
		return listVille;
	}
	
	public Connection getConnection() throws SQLException {

	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", "root");
	    connectionProps.put("password", "root");

	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8080/", connectionProps);
	    
	    System.out.println("Connected to database");
	    return conn;
	}

}
