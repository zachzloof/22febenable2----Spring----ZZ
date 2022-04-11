package com.qa.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Fighter;

@RestController //Tells spring that this is a Rest compliant controller
public class FighterController {
	
//	@GetMapping("/helloWorld") // this is an endpoint
//	
//	public String hello() {
//		return "<p>Hello World!</p>";
//	}
	
//LIST - we havent got a db yet so we need to store data somewhere
	private List<Fighter> fighterList = new ArrayList<>();
	
	// CRUD FUNCTIONALITY
	// ResponseEntity is an extension of HttpEntity that represents an HTTP response including status code, headers and body
	
	
	//CREATE
	@PostMapping("/create") //201 - created
	public ResponseEntity<Fighter> createFighter(@RequestBody Fighter f) {
		this.fighterList.add(f);
		Fighter created = this.fighterList.get(this.fighterList.size()-1);
		ResponseEntity<Fighter> response = new ResponseEntity<Fighter>(created, HttpStatus.CREATED);
		return response;
	}
	
	//READ ALL
	@GetMapping("/getAll") //200 - OK
	public ResponseEntity<List<Fighter>> getAllFighters() {
		return ResponseEntity.ok(this.fighterList);
	}
	
	//READ BY ID
	@GetMapping("/get/{id}") //200 - OK
	public Fighter getFighter(@PathVariable Integer id) {
		return this.fighterList.get(id);
	}
	
	// UPDATE
	@PutMapping("/replace/{id}") //202 - accepted
	public ResponseEntity<Fighter> replaceFighter(@PathVariable Integer id, @RequestBody Fighter newFighter) {
		Fighter body = this.fighterList.set(id, newFighter);
		ResponseEntity<Fighter> response = new ResponseEntity<Fighter>(body, HttpStatus.ACCEPTED);
		return response;
	}
	
	// DELETE 
	@DeleteMapping("/remove/{id}") //204-No Content
	public ResponseEntity<?> removeFighter(@PathVariable Integer id) {
		this.fighterList.remove(id.intValue());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
