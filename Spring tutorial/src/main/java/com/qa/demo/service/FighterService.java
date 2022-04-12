package com.qa.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.demo.domain.Fighter;
import com.qa.demo.repo.FighterRepo;
import com.qa.demo.services.ServiceIF;
// THIS COULD IMPLEMENT AN INTERFACE
//THIS IS BETTER PRACTICE

@Service // stores the main business logic of the application
public class FighterService implements ServiceIF<Fighter>{
		
//	// the list as we do not have a database yet
//	private List<Fighter> fighterList = new ArrayList<>();
//	
//	
	
	private FighterRepo repo;
	
	@Autowired
	public FighterService(FighterRepo repo) {
		super();
		this.repo=repo;
	}
	
	//CRUD
	
	//INSERT INTO FIGHTER
	public Fighter create(Fighter f) {
//		this.fighterList.add(f);
//		Fighter created = this.fighterList.get(this.fighterList.size() -1); NO LONGER NEEDDED
		Fighter created = this.repo.save(f);
		return created;
		
	}
	
	
	// SELECT * FROM FIGHTER
	public List<Fighter> getAll() {
//		return this.fighterList;
		return this.repo.findAll();
	}
	
	
	// SELECT * FROM FIGHTER WHERE ID = X
	public Fighter getById(Integer id) {
//		return this.fighterList.get(id);
		Optional<Fighter> found = this.repo.findById(id);
		return found.get();
	}
	
	
	// UPDATE
	public Fighter replace(Integer id, Fighter newFighter) {
//		Fighter body = this.fighterList.set(id, newFighter);
//		return body;
		Fighter existing = this.repo.findById(id).get();
		existing.setAge(newFighter.getAge());
		existing.setHeight(newFighter.getHeight());
		existing.setName(newFighter.getName());
		existing.setReach(newFighter.getReach());
		Fighter updated = this.repo.save(existing);
		return updated;
	}
	
	// DELETE FROM FIGHTER WHERE ID = X
	public void remove(@PathVariable Integer id) {
//		this.fighterList.remove(id.intValue()); //INT VALUE TO FORCE THE RIGHT METHOD .REMOVE
		this.repo.deleteById(id);
	}
	
	// SELECT * FROM FIGHTER WHERE NAME = X
	public List<Fighter> getFighterByName(String name) {
		List<Fighter> found = this.repo.findByNameIgnoreCase(name);
		return found;
	}
	// SELECT * FROM FIGHTER WHERE AGE = X
		public List<Fighter> getFighterByAge(Integer age) {
			List<Fighter> found = this.repo.findByAge(age);
			return found;
	}
}
