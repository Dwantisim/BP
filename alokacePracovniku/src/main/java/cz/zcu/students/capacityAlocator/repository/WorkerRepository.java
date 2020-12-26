package cz.zcu.students.capacityAlocator.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.zcu.students.capacityAlocator.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
