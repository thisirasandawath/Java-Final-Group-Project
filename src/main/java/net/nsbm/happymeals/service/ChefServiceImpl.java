package net.nsbm.happymeals.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nsbm.happymeals.model.Chef;
import net.nsbm.happymeals.repository.ChefRepository;

@Service
@Transactional
public class ChefServiceImpl implements ChefService {

	private final ChefRepository chefDao;
	
	public ChefServiceImpl(ChefRepository chefDao) {
		this.chefDao = chefDao;
	}
	@Override
	public void save(Chef chef) {
		chefDao.save(chef);
		
	}
	@Override
	public List<Chef> findAll() {
		return chefDao.findAll();
	}
	@Override
	public void deleteById(int id) {
		chefDao.deleteById(id);
	}
	@Override
	public Chef fetchChefById(int id) {
		return chefDao.findById(id).orElse(null);
	}
	

}
