package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VilleController {
	
    @RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		
		// mv.addObject("distance", 300);
		mv.setViewName("distance");

		return mv;
	}

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		
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
