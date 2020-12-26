package cz.zcu.students.capacityAlocator.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.zcu.students.capacityAlocator.exceptions.AlocationNotFoundException;
import cz.zcu.students.capacityAlocator.model.Alocation;
import cz.zcu.students.capacityAlocator.repository.AlocationRepository;

@Service
public class AlocationServiceImpl implements AlocationService {

	@Autowired
	private AlocationRepository alocationRepository;

	public List<Alocation> retrieveAllAlocations() {
		return alocationRepository.findAll();
	}

	public List<Alocation> retrieveAlocationsByPlan(Long idPlan) {
		return alocationRepository.findByIdPlan(idPlan);
	}

	public List<Alocation> retrieveAlocationsByPlanAndWorker(Long idPlan, Long idWorker) {
		return alocationRepository.findByIdPlanAndIdWorker(idPlan, idWorker);
	}

	public List<Alocation> retrieveAlocationsByWorker(Long idWorker) {
		return alocationRepository.findByIdWorker(idWorker);
	}

	public Alocation retrieveAlocation(long id) {
		Optional<Alocation> alocation = alocationRepository.findById(id);

		if (!alocation.isPresent())
			throw new AlocationNotFoundException("id-" + id);

		return alocation.get();
	}

	public void deleteAlocation(long id) {
		alocationRepository.deleteById(id);
	}

	public Alocation createAlocation(Alocation alocation) {
		Alocation savedAlocation = alocationRepository.save(alocation);

		return savedAlocation;
	}
	

	public Alocation updateAlocation(Alocation alocation, long id) {

		Optional<Alocation> alocationOptional = alocationRepository.findById(id);

		if (!alocationOptional.isPresent())
			return null;

		alocation.setId(id);
		
		Alocation updatedAlocation = alocationRepository.save(alocation);

		return updatedAlocation;
	}
}
