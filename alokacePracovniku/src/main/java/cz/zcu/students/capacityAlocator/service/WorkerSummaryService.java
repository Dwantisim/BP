package cz.zcu.students.capacityAlocator.service;

import cz.zcu.students.capacityAlocator.model.WorkerSummary;

public interface WorkerSummaryService {
	public WorkerSummary workerSummary(Long idPlan, Long idWorker);
}
