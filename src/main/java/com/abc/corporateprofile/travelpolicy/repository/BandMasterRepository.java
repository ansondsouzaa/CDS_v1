package com.abc.corporateprofile.travelpolicy.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.corporateprofile.travelpolicy.dto.BandMaster;

public interface BandMasterRepository extends JpaRepository<BandMaster, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE BandMaster b SET b.band_name=:band_name, b.modified_by=:modified_by WHERE b.id=:id")
	public void updateBandById(@Param("id") Integer id, @Param("band_name") String band_name,
			@Param("modified_by") Integer modified_by);
}
