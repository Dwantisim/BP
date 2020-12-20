package pack1.WorkerSummary;

import java.util.List;

import pack1.alocations.Alocation;
import pack1.alocations.AlocationController;
import pack1.worker.Worker;

public class workerSummaryService {
	public static WorkerSummary workerSummary(Worker worker, int days) {
		List<Alocation> lAlocation = AlocationController.retrieveAllAlocations();
		for (Alocation alocation : lAlocation) {
			if (alocation.getWorker() != worker){
				lAlocation.remove(alocation);
			}
		}
		int tempAlocated = 0;
		for (Alocation alocation : lAlocation) {
			tempAlocated += alocation.getValue();
		}
		
		Worker[] allVPs = new Worker[getAllVPs().size()];
		allVPs = (Worker[]) getAllVPs().toArray();
		int[] workerAlocations = new int[allVPs.length];
		int temp = 0;
		for (Worker VP : allVPs) {
			for (Alocation alocation : lAlocation) {
				if(alocation.getVP() == VP && alocation.getWorker() == worker) {
					workerAlocations[temp] = alocation.getValue();
					temp++;
				}
			}
		}
		
		WorkerSummary result = new WorkerSummary();
		
		result.setShortcut(worker.getShortcut());
		result.setAlocations(workerAlocations);
		result.setSection(worker.getSection());
		result.setHarness(worker.getHarness());
		result.setHarnessCapacity(Math.round(worker.getHarness() * days));
		result.setCapacity(Math.round(worker.getHarness() * days) - worker.getReserve() - worker.getAbsence());
		result.setAbsence(worker.getAbsence());
		result.setReserve(worker.getReserve());
		result.setFreeCapacity(Math.round(worker.getHarness() * days) - worker.getReserve() - worker.getAbsence() - tempAlocated);
		result.setSpecCapacity(0);
		result.setNote(worker.getNote());
		
		
		return result; 
	} 
	public static  List<Worker> getAllVPs () {
    	
    	List<Worker> allWorkers = Worker.getAllWorkers();
    	for (Worker worker : allWorkers) {
    		if (worker.getVP() == false) {
    			allWorkers.remove(worker);
    		}
    	}
    	return allWorkers;
    }
}
