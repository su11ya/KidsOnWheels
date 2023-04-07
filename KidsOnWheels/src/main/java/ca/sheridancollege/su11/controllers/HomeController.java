package ca.sheridancollege.su11.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.su11.beans.Parent;
import ca.sheridancollege.su11.repositories.ChildRepository;
import ca.sheridancollege.su11.repositories.ParentRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/kidsonwheels")
@CrossOrigin(origins="http://localhost:8080")

public class HomeController {
	
	private ParentRepository parentRepository;
	private ChildRepository childRepository;
	
	@GetMapping
	public List<Parent> getAllUsers(){
		return parentRepository.findAll();
	}
	
	

}
