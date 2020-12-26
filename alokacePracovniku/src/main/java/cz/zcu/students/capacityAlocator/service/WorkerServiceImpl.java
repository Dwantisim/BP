package cz.zcu.students.capacityAlocator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.zcu.students.capacityAlocator.exceptions.WorkerNotFoundException;
import cz.zcu.students.capacityAlocator.model.Worker;
import cz.zcu.students.capacityAlocator.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerRepository workerRepository;

	public List<Worker> retrieveAllWorkers() {
		return workerRepository.findAll();
	}

	public Worker retrieveWorker(Long id) {
		Optional<Worker> worker = workerRepository.findById(id);

		if (!worker.isPresent())
			throw new WorkerNotFoundException("id-" + id);

		return worker.get();
	}

	public void deleteWorker(Long id) {
		workerRepository.deleteById(id);
	}

	public Worker createWorker(Worker worker) {
		return workerRepository.save(worker);
	}
	
	public Worker updateWorker(Worker worker,Long id) {

		Optional<Worker> workerOptional = workerRepository.findById(id);

		if (!workerOptional.isPresent())
			return null;

		worker.setId(id);
		
		Worker updatedWorker = workerRepository.save(worker);

		return updatedWorker;
	}
	
	public List<Worker> getAllVPs () {
    	List<Worker> allWorkers = workerRepository.findAll();
    	List<Worker> vps = new ArrayList<Worker>();
    	for (Worker worker : allWorkers) {
    		if ("A".equals(worker.getVp())) {
    			vps.add(worker);
    		}
    	}
    	return vps;
    }

}
