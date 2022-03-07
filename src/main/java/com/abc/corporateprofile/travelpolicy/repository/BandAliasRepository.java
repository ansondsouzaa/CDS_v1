package com.abc.corporateprofile.travelpolicy.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.corporateprofile.travelpolicy.dto.BandAlias;

public interface BandAliasRepository extends JpaRepository<BandAlias, Integer>{

	@Modifying
	@Transactional
	@Query("UPDATE BandAlias b SET b.band_alias=:band_alias, b.modified_by=:modified_by WHERE b.id=:id")
	public void updateAliasById(@Param("id") Integer id, @Param("band_alias") String band_alias,
			@Param("modified_by") Integer modified_by);
}
