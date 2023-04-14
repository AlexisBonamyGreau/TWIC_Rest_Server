package com.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Ville;

@Controller
public class VilleController {
	
    @RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();

		List<Ville> listVille = new ArrayList<Ville>();

		try {
            URL url = new URL("http://localhost:8080/api/all-villes");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
				Gson gson = new Gson();
				Ville[] ville = gson.fromJson(output, Ville[].class);
				for (Ville v : ville) {
					listVille.add(v);
				}
			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}

		mv.addObject("villes", listVille);
		mv.setViewName("distance");

		return mv;
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();

		List<Ville> listVille = new ArrayList<Ville>();

		try {
            URL url = new URL("http://localhost:8080/api/all-villes");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
				Gson gson = new Gson();
				Ville[] ville = gson.fromJson(output, Ville[].class);
				for (Ville v : ville) {
					listVille.add(v);
				}
			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}

		mv.addObject("villes", listVille);
		
		mv.setViewName("all_villes");

		return mv;
	}

	@RequestMapping("/config")
	public ModelAndView config() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("conf_villes");

		return mv;
	}
}
