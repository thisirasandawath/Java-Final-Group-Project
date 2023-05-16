package net.nsbm.happymeals.service;

import java.util.List;

import net.nsbm.happymeals.model.Helper;

public interface HelperService {
	
	void save(Helper helper);

	List<Helper> findAll();
	
	void deleteById(int id);

	Helper fetchHelperById(int id);
}
