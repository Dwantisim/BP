package cz.zcu.students.capacityAlocator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.zcu.students.capacityAlocator.model.Alocation;
import cz.zcu.students.capacityAlocator.service.AlocationService;

@RestController	
@RequestMapping("/api/alocation")
public class AlocationController {

	@Autowired
	private AlocationService alocationService;

	@GetMapping
	public List<Alocation> retrieveAllAlocations() {
		return alocationService.retrieveAllAlocations();
	}

	@GetMapping("/{id}")
	public Alocation retrieveAlocation(@PathVariable Long id) {
		Alocation alocation = alocationService.retrieveAlocation(id);

		return alocation;
	}

	@GetMapping("/worker/{idWorker}")
	public List<Alocation> retrieveAlocationByWorker(@PathVariable Long idWorker) {
		List<Alocation> alocations = alocationService.retrieveAlocationsByWorker(idWorker);

		return alocations;
	}

	@DeleteMapping("/{id}")
	public void deleteAlocation(@PathVariable long id) {
		alocationService.deleteAlocation(id);
	}

	@PostMapping
	public ResponseEntity<Alocation> createAlocation(@RequestBody Alocation alocation) {
		Alocation savedAlocation = alocationService.createAlocation(alocation);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedAlocation);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Alocation> updateAlocation(@RequestBody Alocation alocation, @PathVariable long id) {
		Alocation savedAlocation = alocationService.updateAlocation(alocation, id);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedAlocation);
	}
}
