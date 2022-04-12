//package com.qa.demo.services;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.qa.demo.domain.Fighter;
//
//
//// THIS IS FOR THE EXCERSIZE ON QA NOT THE TUTORIAL
//@Service
//public class FighterService {
//
//	
//	private List<Fighter> fighters = new ArrayList<>();
//
//    public Fighter addFighter(Fighter fighter) {
//        // Add new Person
//        this.fighters.add(fighter);
//        // Return last added Person from List
//        return this.fighters.get(this.fighters.size() - 1);
//    }
//
//    public List<Fighter> getAllFighters() {
//        // Return the whole List
//        return this.fighters;
//    }
//
//    public Fighter updateFighter(int id, Fighter fighter) {
//        // Remove existing Person with matching 'id'
//        this.fighters.remove(id);
//        // Add new Person in its place
//        this.fighters.add(id, fighter);
//        // Return updated Person from List
//        return this.fighters.get(id);
//    }
//
//    public Fighter removeFighter(int id) {
//        // Remove Person and return it
//        return this.fighters.remove(id);
//    }
//    
//    
//    
////    private FighterService service;
////
////    public FighterController(FighterService service) {
////        super();
////        this.service = service;
////    } THIS CAN BE PLACED INTO THE CONTROLLER TO GIVE ALL OF THESE METHODS TO THE CONTROLLER IN THE FORM OF A SERVICE, THIS IS BEST PRACTICE.
//	
//}
