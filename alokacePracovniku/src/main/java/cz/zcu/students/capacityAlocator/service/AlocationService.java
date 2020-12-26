package cz.zcu.students.capacityAlocator.service;

import java.util.List;

import cz.zcu.students.capacityAlocator.model.Alocation;

public interface AlocationService {
	public List<Alocation> retrieveAllAlocations();

	public Alocation retrieveAlocation(long id);

	public List<Alocation> retrieveAlocationsByPlan(Long idPlan);
	
	public List<Alocation> retrieveAlocationsByPlanAndWorker(Long idPlan, Long idWorker);

	public List<Alocation> retrieveAlocationsByWorker(Long idWorker);

	public void deleteAlocation(long id);

	public Alocation createAlocation(Alocation alocation);

	public Alocation updateAlocation(Alocation alocation, long id);
}
