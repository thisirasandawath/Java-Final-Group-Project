package net.nsbm.happymeals.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.nsbm.happymeals.model.Helper;
import net.nsbm.happymeals.service.HelperService;

@RequestMapping("/api/v1")
@RestController
public class HelperController {

	private final HelperService helperService;
	
	public HelperController(HelperService helperService) {
		this.helperService = helperService;
		
	}
	@GetMapping("/fetch-all-helpers")
    List<Helper> allHelpers() {
        return helperService.findAll();
    }
	
}
