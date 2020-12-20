package cz.zcu.hanzelin.bp.WorkerAllocation.controller;



//ToDo - remove static

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pack1.worker.Worker;

@RestController
public class AlocationController {

	@Autowired
	private static  AlocationRepository alocationRepository;

	@GetMapping("/alocations")
	public static  List<Alocation> retrieveAllAlocations() {
		return alocationRepository.findAll();
	}

	@GetMapping("/alocations/{id}")
	public Alocation retrieveAlocation(@PathVariable long id) {
		Optional<Alocation> alocation = alocationRepository.findById(id);

		if (!alocation.isPresent())
			throw new AlocationNotFoundException("id-" + id);

		return alocation.get();
	}
	@GetMapping("/alocations/{Aloca}")
	public Alocation retrieveAlocation(@PathVariable Worker worker) {
		Optional<Alocation> alocation = alocationRepository.findById(worker.getId());

		if (!alocation.isPresent())
			throw new AlocationNotFoundException("worker-" + worker);

		return alocation.get();
	}

	@DeleteMapping("/alocations/{id}")
	public void deleteAlocation(@PathVariable long id) {
		alocationRepository.deleteById(id);
	}

	@PostMapping("/alocations")
	public ResponseEntity<Object> createAlocation(@RequestBody Alocation alocation) {
		Alocation savedAlocation = alocationRepository.save(alocation);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedAlocation.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/alocations/{id}")
	public ResponseEntity<Object> updateAlocation(@RequestBody Alocation alocation, @PathVariable long id) {

		Optional<Alocation> alocationOptional = alocationRepository.findById(id);

		if (!alocationOptional.isPresent())
			return ResponseEntity.notFound().build();

		alocation.setId(id);
		
		alocationRepository.save(alocation);

		return ResponseEntity.noContent().build();
	}
}
