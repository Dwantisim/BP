package cz.zcu.students.capacityAlocator.service;

import java.util.HashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.zcu.students.capacityAlocator.model.Alocation;
import cz.zcu.students.capacityAlocator.model.Plan;
import cz.zcu.students.capacityAlocator.model.Worker;
import cz.zcu.students.capacityAlocator.model.WorkerSummary;

@Service
public class WorkerSummaryServiceImpl implements WorkerSummaryService {
	
	@Autowired
	AlocationService alocationService;
	
	@Autowired
	WorkerService workerService;
	
	@Autowired
	PlanService planService;
	
	public WorkerSummary workerSummary(Long idPlan, Long idWorker) {

		Worker worker = workerService.retrieveWorker(idWorker);
		Plan plan= planService.retrievePlan(idPlan);
		WorkerSummary summary = new WorkerSummary();
		
		summary.setId(worker.getId());
		summary.setShortcut(worker.getShortcut());
		summary.setSection(worker.getSection());
		summary.setHarness(worker.getHarness());
		summary.setHarnessCapacity(Math.round(worker.getHarness() * plan.getDays()));
		summary.setCapacity(Math.round(worker.getHarness() * plan.getDays()) - worker.getReserve() - worker.getAbsence());
		summary.setAbsence(worker.getAbsence());
		summary.setReserve(worker.getReserve());
		summary.setSpecCapacity(0);
		summary.setNote(worker.getNote());
		
		List<Alocation> alocations = alocationService.retrieveAlocationsByPlanAndWorker(idPlan,idWorker);

		HashMap<Long, Integer> alocationMap = summary.getAlocations();
		Integer totalAlocation = 0;
		for (Alocation alocation : alocations) {
			Long idVP = alocation.getIdVP();
			Integer manDays;
			if (alocationMap.containsKey(idVP)) {
				manDays = alocationMap.get(idVP);
			}
			else {
				manDays = 0;
			}

			alocationMap.put(idVP, manDays + alocation.getManDays());
			totalAlocation += alocation.getManDays();
		}
		
		summary.setFreeCapacity(Math.round(worker.getHarness() * plan.getDays()) - worker.getReserve() - worker.getAbsence() - totalAlocation);

		return summary; 
	} 
	
}
