package cz.zcu.students.capacityAlocator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.zcu.students.capacityAlocator.model.WorkerSummary;
import cz.zcu.students.capacityAlocator.service.WorkerSummaryService;

@RestController
@RequestMapping("/api/workerSummary")
public class WorkerSummaryController {

	@Autowired
	private WorkerSummaryService workerSummaryService;

	@GetMapping("/{id}/plan/{idPlan}")
	public WorkerSummary retrieveworkerSummary(@PathVariable long id, @PathVariable long idPlan) {
		WorkerSummary workerSummary = workerSummaryService.workerSummary(idPlan, id);

		return workerSummary;
	}

}
