package ca.sheridancollege.su11.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.su11.beans.Parent;
import ca.sheridancollege.su11.repositories.ChildRepository;
import ca.sheridancollege.su11.repositories.ParentRepository;
import ca.sheridancollege.su11.services.FirebaseService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/kidsonwheels")
@CrossOrigin(origins="http://localhost:8080")

public class HomeController {
	
//	private ParentRepository parentRepository;
//	private ChildRepository childRepository;
	
	private final FirebaseService firebaseService;
	
//	@GetMapping
//	public List<Parent> getAllUsers(){
//		return parentRepository.findAll();
//	}
//	
	@GetMapping
    public List<Parent> getAllParents() throws ExecutionException, InterruptedException {
        return firebaseService.getAllParents();
    }

    @PostMapping("/parent")
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
