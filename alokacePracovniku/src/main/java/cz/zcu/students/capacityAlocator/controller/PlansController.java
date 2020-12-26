package cz.zcu.students.capacityAlocator.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cz.zcu.students.capacityAlocator.exceptions.PlanNotFoundException;
import cz.zcu.students.capacityAlocator.model.Plan;
import cz.zcu.students.capacityAlocator.repository.PlanRepository;

@RestController
@RequestMapping("/api/plans")

public class PlansController {

	@Autowired
	private PlanRepository planRepository;

	@GetMapping
	public List<Plan> retrieveAllPlans() {
		return planRepository.findAll();
	}

	@GetMapping("/{id}")
	public Plan retrievePlan(@PathVariable long id) {
		Optional<Plan> plan = planRepository.findById(id);

		if (!plan.isPresent())
			throw new PlanNotFoundException("id-" + id);

		return plan.get();
	}

	@DeleteMapping("/{id}")
	public void deleteWorker(@PathVariable long id) {
		planRepository.deleteById(id);
	}

	@PostMapping
	public ResponseEntity<Object> createPlan(@RequestBody Plan plan) {
		Plan savedPlan = planRepository.save(plan);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPlan.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePlan(@RequestBody Plan plan, @PathVariable long id) {

		Optional<Plan> planOptional = planRepository.findById(id);

		if (!planOptional.isPresent())
			return ResponseEntity.notFound().build();

		plan.setId(id);
		
		planRepository.save(plan);

		return ResponseEntity.noContent().build();
	}
}
