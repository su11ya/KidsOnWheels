package ca.sheridancollege.su11.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.su11.beans.Parent;
//import ca.sheridancollege.su11.repositories.ChildRepository;
//import ca.sheridancollege.su11.repositories.ParentRepository;
import ca.sheridancollege.su11.services.FirebaseService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
//@RequestMapping("/api/kidsonwheels")
@CrossOrigin(origins="http://localhost:8080")

public class HomeController {
	
//	private ParentRepository parentRepository;
//	private ChildRepository childRepository;
	
	// Inject the FirebaseService instance
	private final FirebaseService firebaseService;
	

	// Get all parents from the Firestore database
	@GetMapping("/api/kidsonwheels")
    public List<Parent> getAllParents() throws ExecutionException, InterruptedException {
        return firebaseService.getAllParents();
    }
	
//	
//	@GetMapping("/")
//    public String index(Model model) throws ExecutionException, InterruptedException {
//        List<Parent> parents = firebaseService.getAllParents();
//        model.addAttribute("parents", parents);
//        return "index";
//    }
//	
//	
	

	// Add a new parent to the Firestore database
    @PostMapping("/api/kidsonwheels/parent")
    public Parent addParent(@RequestBody Parent parent) {
        return firebaseService.addParent(parent);
    }
//	
//    @PostMapping("/parent")
//    public ResponseEntity<String> addParent(@RequestBody Parent parent) {
//    	try {
//            String parentId = firebaseService.addParent(parent);
//            return ResponseEntity.status(HttpStatus.CREATED).body(parentId);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//	

}
