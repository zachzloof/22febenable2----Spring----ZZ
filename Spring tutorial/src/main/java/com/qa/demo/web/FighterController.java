package com.qa.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Fighter;
import com.qa.demo.service.FighterService;

@CrossOrigin
@RestController //Tells spring that this is a Rest compliant controller
public class FighterController {
	
//	@GetMapping("/helloWorld") // this is an endpoint
//	
//	public String hello() {
//		return "<p>Hello World!</p>";
//	} 
	
	private FighterService service;
	
	@Autowired //tells Spring to fetch the FighterService from the context - dependency injection
	public FighterController (FighterService service) {
		super();
		this.service=service;
	}

	
	// CRUD FUNCTIONALITY
	// ResponseEntity is an extension of HttpEntity that represents an HTTP response including status code, headers and body
	
	
	//CREATE
	@PostMapping("/create") //201 - created
	public ResponseEntity<Fighter> createFighter(@RequestBody Fighter f) {
		Fighter created = this.service.create(f);
		ResponseEntity<Fighter> response = new ResponseEntity<Fighter>(created, HttpStatus.CREATED);
		return response;
	}
	
	//READ ALL
	@GetMapping("/getAll") //200 - OK
	public ResponseEntity<List<Fighter>> getAllFighters() {
		return ResponseEntity.ok(this.service.getAll());
	}
	
	//READ BY ID
	@GetMapping("/get/{id}") //200 - OK
	public Fighter getFighter(@PathVariable Integer id) {
		return this.service.getById(id);
	}
	
	// UPDATE
	@PutMapping("/replace/{id}") //202 - accepted
	public ResponseEntity<Fighter> replaceFighter(@PathVariable Integer id, @RequestBody Fighter newFighter) {
		Fighter body = this.service.replace(id, newFighter);
		ResponseEntity<Fighter> response = new ResponseEntity<Fighter>(body, HttpStatus.ACCEPTED);
		return response;
	}
	
	// DELETE 
	@DeleteMapping("/remove/{id}") //204-No Content
	public ResponseEntity<?> removeFighter(@PathVariable Integer id) {
		this.service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// READ BY NAME
	@GetMapping("/getByName/{name}") //200 - OK
	public ResponseEntity<List<Fighter>> getFighterByName(@PathVariable String name) {
		List<Fighter> found = this.service.getFighterByName(name);
		return ResponseEntity.ok(found);
	}
	
	//READ BY AGE
	@GetMapping("/getByAge/{age}")
	public ResponseEntity<List<Fighter>> getFighterByAge(@PathVariable Integer age) {
		List<Fighter> found = this.service.getFighterByAge(age);
		return ResponseEntity.ok(found);
	}
}
