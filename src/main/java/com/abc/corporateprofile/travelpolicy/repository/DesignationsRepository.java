package com.abc.corporateprofile.travelpolicy.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.corporateprofile.travelpolicy.dto.Designations;

public interface DesignationsRepository extends JpaRepository<Designations, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE Designations d SET d.designation_name=:designation_name, d.department_name=:department_name, d.modified_by=:modified_by WHERE d.id=:id")
	public void updateDesignationById(@Param("id") Integer id, @Param("designation_name") String designation_name,
			@Param("department_name") String department_name, @Param("modified_by") Integer modified_by);

}