package com.abc.corporateprofile.travelpolicy.service;

import java.util.List;

import com.abc.corporateprofile.travelpolicy.dto.BandAlias;
import com.abc.corporateprofile.travelpolicy.dto.BandMaster;

public interface BandService {

// BandMaster 

	// Create
	public void addBand(BandMaster addBand);

	// Retrieve
	public List<BandMaster> listAllBands();

	// Update
	public void updateBandById(Integer id, String band_name, Integer modified_by);

	// Delete
	public void deleteBandById(int id);

// BandMaster

	// Create
	public void addBandAlias(BandAlias addBandAlias);

	// Retrieve
	public List<BandAlias> listAllAlias();

	// Update
	public void updateAliasById(Integer id, String band_alias, Integer modified_by);

	// Delete
	public void deleteAliasById(int id);

}
