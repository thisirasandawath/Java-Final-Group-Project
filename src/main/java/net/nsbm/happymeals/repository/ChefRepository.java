package net.nsbm.happymeals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.nsbm.happymeals.model.Chef;

public interface ChefRepository extends JpaRepository<Chef, Integer>{
	
	
}
