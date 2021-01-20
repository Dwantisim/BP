package pack1.WorkerSummary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import pack1.alocations.Alocation;
import pack1.alocations.AlocationController;
import pack1.alocations.AlocationService;
import pack1.vpsToRemove.VPs;
import pack1.worker.Worker;
import pack1.worker.WorkerService;


public class workerSummaryService {
	@Autowired
	private WorkerService workerService;
	@Autowired
	private AlocationService alocationService;

	public  WorkerSummary workerSummary(Worker worker, int days) {
		List<Alocation> alocations = alocationService.getAlocationsByWorker(worker);

		int sumAlocated = alocations.stream().mapToInt(Alocation::getValue).sum(); //součet alokací pracovníka

		 List<Worker> allVPs = workerService.getAllWorkers();

				//new Worker[getAllVPs().size()];
		allVPs.stream().filter(w -> w.isVP() );

		Map<Worker,Integer> workerAlocations = new HashMap<>() ;

		for (Worker VP : allVPs) {
			workerAlocations.put(VP,0);
			for (Alocation alocation : alocations) {

				if(alocation.getVP().equals(VP) && alocation.getWorker().equals(worker)) {

				workerAlocations.put(VP,workerAlocations.get(VP)+alocation.getValue());

				}
			}
		}
		
		WorkerSummary result = WorkerSummary.builder()
				.shortcut(worker.getShortcut())
				//.alocations(workerAlocations)
				.section(worker.getSection())
				.harness(worker.getHarness())
				.harnessCapacity(Math.round(worker.getHarness() * days))
				.capacity(worker.getHarness().intValue() * days - worker.getReserve() - worker.getAbsence())
				.absence(worker.getAbsence())
				.reserve(worker.getReserve())
				.freeCapacity(Math.round(worker.getHarness() * days) - worker.getReserve() - worker.getAbsence() - sumAlocated)
				.specCapacity(0)
				.note(worker.getNote())
				.build()
				;



		/*result.setShortcut(worker.getShortcut());
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
		
		*/
		return result; 
	} 
	/*public static  List<Worker> getAllVPs () {
    	
    	List<Worker> allWorkers = Worker.getAllWorkers();
    	for (Worker worker : allWorkers) {
    		if (worker.getVP() == false) {
    			allWorkers.remove(worker);
    		}
    	}
    	return allWorkers;
    } */
}
