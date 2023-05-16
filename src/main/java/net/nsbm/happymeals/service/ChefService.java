package net.nsbm.happymeals.service;

import java.util.List;

import net.nsbm.happymeals.model.Chef;

public interface ChefService {

	void save(Chef chef);

	List<Chef> findAll();

	void deleteById(int id);
	
	Chef fetchChefById(int id);
}
