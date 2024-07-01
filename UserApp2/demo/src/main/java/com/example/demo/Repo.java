package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Repo extends JpaRepository<Model, Integer> {

	@Query("SELECT e.name FROM Model e WHERE e.name = :status")
	List<String> findDetailByName(@Param("status") String status);
	
	@Query("SELECT new com.example.demo.TwoMemberDto(e.name, e.phone) FROM Model e WHERE e.name like %:status%")
	List<TwoMemberDto> findDetailByNamePhone(@Param("status") String status);
	
	
}
