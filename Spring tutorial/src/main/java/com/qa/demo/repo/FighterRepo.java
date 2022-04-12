package com.qa.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.domain.Fighter;

@Repository
public interface FighterRepo extends JpaRepository<Fighter, Integer>{
	
	
	//SPRING WILL AUTO-GENERATE ALL OF THE BASIC CRUD FUNCTIONALITY ;););)
	
	List<Fighter> findByNameIgnoreCase(String name);
	List<Fighter> findByAge(Integer age);
	
	
}
