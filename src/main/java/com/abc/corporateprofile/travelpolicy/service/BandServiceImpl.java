package com.abc.corporateprofile.travelpolicy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.corporateprofile.travelpolicy.dto.BandAlias;
import com.abc.corporateprofile.travelpolicy.dto.BandMaster;
import com.abc.corporateprofile.travelpolicy.repository.BandAliasRepository;
import com.abc.corporateprofile.travelpolicy.repository.BandMasterRepository;

@Service("bandservice")
@Transactional
public class BandServiceImpl implements BandService {

// All Repositories

	@Autowired
	BandMasterRepository bandMasterRepository;
	
	@Autowired
	BandAliasRepository bandAliasRepository;

// BandMaster Services 

	// Create Bands
	@Override
	public void addBand(BandMaster addBand) {
		bandMasterRepository.save(addBand);
	}

	// Retrieve Bands
	@Override
	public List<BandMaster> listAllBands() {
		return bandMasterRepository.findAll();
	}

	// Update Bands
	@Override
	public void updateBandById(Integer id, String band_name, Integer modified_by) {
		bandMasterRepository.updateBandById(id, band_name, modified_by);
	}

	// Delete Bands
	@Override
	public void deleteBandById(int id) {
		bandMasterRepository.deleteById(id);
	}

// BandAlias Services 

	// Create BandAlias
	@Override
	public void addBandAlias(BandAlias addBandAlias) {
		bandAliasRepository.save(addBandAlias);
	}

	// Retrieve BandAlias
	@Override
	public List<BandAlias> listAllAlias() {
		return bandAliasRepository.findAll();
	}

	// Update BandAlias
	@Override
	public void updateAliasById(Integer id, String band_alias, Integer modified_by) {
		bandAliasRepository.updateAliasById(id, band_alias, modified_by);
	}

	// Delete BandAlias
	@Override
	public void deleteAliasById(int id) {
		bandAliasRepository.deleteById(id);
	}

}
