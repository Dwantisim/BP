package cz.zcu.students.capacityAlocator.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cz.zcu.students.capacityAlocator.model.Worker;
import cz.zcu.students.capacityAlocator.service.WorkerService;

@RestController
@RequestMapping("/api")
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@GetMapping("/workers")
	public ResponseEntity<List<Worker>> retrieveAllWorkers() {
		List<Worker> workers = workerService.retrieveAllWorkers();

		return ResponseEntity.ok(workers);
	}

	@GetMapping("/vps")
	public ResponseEntity<List<Worker>> retrieveAllVPs() {
		List<Worker> workers = workerService.getAllVPs();

		return ResponseEntity.ok(workers);
	}

	@GetMapping("/workers/{id}")
	public Worker retrieveWorker(@PathVariable Long id) {
		Worker worker = workerService.retrieveWorker(id);

		return worker;
	}

	@DeleteMapping("/workers/{id}")
	public void deleteWorker(@PathVariable Long id) {
		workerService.deleteWorker(id);
	}

	@PostMapping("/workers")
	public ResponseEntity<Object> createWorker(@RequestBody Worker worker) {
		Worker savedWorker = workerService.createWorker(worker);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedWorker.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/workers/{id}")
	public ResponseEntity<Object> updateWorker(@RequestBody Worker worker, @PathVariable Long id) {

		worker = workerService.updateWorker(worker, id);

		return ResponseEntity.accepted().build();
	}
}
