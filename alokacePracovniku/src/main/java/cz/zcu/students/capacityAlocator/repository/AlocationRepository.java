package cz.zcu.students.capacityAlocator.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.zcu.students.capacityAlocator.model.Alocation;

@Repository
public interface AlocationRepository extends JpaRepository<Alocation, Long>{
	List<Alocation> findByIdPlan(Long idPlan);
	List<Alocation> findByIdWorker(Long idWorker);
	List<Alocation> findByIdPlanAndIdWorker(Long idPlan, Long idWorker);
}
