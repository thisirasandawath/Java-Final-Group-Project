package net.nsbm.happymeals.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.nsbm.happymeals.model.Chef;
import net.nsbm.happymeals.service.ChefService;
@RequestMapping("/api/v1")
@RestController
public class ChefController {
	
	private final ChefService chefService;
	
	public ChefController(ChefService chefService2) {
		this.chefService = chefService2;
		
	}
	
	@GetMapping("/fetch-all-chefs")
    List<Chef> allChefs() {
        return chefService.findAll();
    }
	


}
