package com.vitoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vitoria.models.Flowers;
import com.vitoria.repositories.FlowersRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@EnableAutoConfiguration
@RequestMapping("/flowers")
public class FlowersController {

	@Autowired
	private FlowersRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Flowers>> findAll(){
		List<Flowers> allFlowers=repo.findAll();
		return ResponseEntity.ok().body(allFlowers);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Flowers> insert(@RequestBody Flowers flower){
		Flowers entity=flower;
		repo.save(entity);
		return ResponseEntity.ok().body(entity);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}	
}
