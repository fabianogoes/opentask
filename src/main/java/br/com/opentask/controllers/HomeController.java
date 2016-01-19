package br.com.opentask.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@PersistenceContext
	private EntityManager em;
	
	@RequestMapping
	public String home(){
		System.out.println( em );
		return "home";
	}
	
}
