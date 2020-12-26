package cz.zcu.students.capacityAlocator.service;

import java.util.List;

import cz.zcu.students.capacityAlocator.model.Worker;

public interface WorkerService {

	public List<Worker> retrieveAllWorkers();

	public Worker retrieveWorker(Long id);
	
	public void deleteWorker(Long id);

	public Worker createWorker(Worker worker);	

	public Worker updateWorker(Worker worker, Long id);
	
	public List<Worker> getAllVPs();
}
