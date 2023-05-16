package net.nsbm.happymeals.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.nsbm.happymeals.model.Helper;
import net.nsbm.happymeals.repository.HelperRepository;

@Service
@Transactional
public class HelperServiceImpl implements HelperService{
	
	private final HelperRepository helperDao;
	
	public HelperServiceImpl(HelperRepository helperDao) {
		this.helperDao = helperDao;		
	}

	@Override
	public void save(Helper helper) {
		helperDao.save(helper);
	}

	@Override
	public List<Helper> findAll() {
		return helperDao.findAll();
	}

	@Override
	public void deleteById(int id) {
		helperDao.deleteById(id);
		
	}

	@Override
	public Helper fetchHelperById(int id) {
		return helperDao.findById(id).orElse(null);
	}

}
