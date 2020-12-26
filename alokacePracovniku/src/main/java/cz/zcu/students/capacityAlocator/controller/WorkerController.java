package pack1.worker;

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

@RestController
public class WorkerController {

	@Autowired
	private static WorkerRepository workerRepository;

	@GetMapping("/workers")
	public static List<Worker> retrieveAllWorkers() {
		return workerRepository.findAll();
	}

	@GetMapping("/workers/{id}")
	public Worker retrieveWorker(@PathVariable long id) {
		Optional<Worker> worker = workerRepository.findById(id);

		if (!worker.isPresent())
			throw new WorkerNotFoundException("id-" + id);

		return worker.get();
	}

	@DeleteMapping("/workers/{id}")
	public void deleteWorker(@PathVariable long id) {
		workerRepository.deleteById(id);
	}

	@PostMapping("/workers")
	public ResponseEntity<Object> createWorker(@RequestBody Worker worker) {
		Worker savedWorker = workerRepository.save(worker);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedWorker.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/workers/{id}")
	public ResponseEntity<Object> updateWorker(@RequestBody Worker worker, @PathVariable long id) {

		Optional<Worker> workerOptional = workerRepository.findById(id);

		if (!workerOptional.isPresent())
			return ResponseEntity.notFound().build();

		worker.setId(id);
		
		workerRepository.save(worker);

		return ResponseEntity.noContent().build();
	}
}
