package cz.zcu.students.capacityAlocator.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.zcu.students.capacityAlocator.model.Plan;
import cz.zcu.students.capacityAlocator.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;

	public Plan retrievePlan(Long id) {
		Optional<Plan> plan = planRepository.findById(id);

		if (!plan.isPresent())
			return null;

		return plan.get();
	}
}
