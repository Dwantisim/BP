package pack1.WorkerSummary;

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
public class WorkerSummaryController {

	@Autowired
	private WorkerSummaryRepository workerSummaryRepository;

	@GetMapping("/workerSummary")
	public List<WorkerSummary> retrieveAllworkerSummarys() {
		return workerSummaryRepository.findAll();
	}

	@GetMapping("/workerSummary/{id}")
	public WorkerSummary retrieveworkerSummary(@PathVariable long id) {
		Optional<WorkerSummary> workerSummary = workerSummaryRepository.findById(id);

		if (!workerSummary.isPresent())
			throw new WorkerSummaryNotFoundException("id-" + id);

		return workerSummary.get();
	}

	@DeleteMapping("/workerSummary/{id}")
	public void deleteWorker(@PathVariable long id) {
		workerSummaryRepository.deleteById(id);
	}

	@PostMapping("/workerSummary")
	public ResponseEntity<Object> createworkerSummary(@RequestBody WorkerSummary workerSummary) {
		WorkerSummary savedworkerSummary = workerSummaryRepository.save(workerSummary);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedworkerSummary.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/workerSummary/{id}")
	public ResponseEntity<Object> updateworkerSummary(@RequestBody WorkerSummary workerSummary, @PathVariable long id) {

		Optional<WorkerSummary> workerSummaryOptional = workerSummaryRepository.findById(id);

		if (!workerSummaryOptional.isPresent())
			return ResponseEntity.notFound().build();

		workerSummary.setId(id);
		
		workerSummaryRepository.save(workerSummary);

		return ResponseEntity.noContent().build();
	}
}
