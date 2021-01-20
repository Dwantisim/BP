package pack1.alocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlocationRepository extends JpaRepository<Alocation, Long>{

    public List<Alocation> findByWorkerId(Long workerId);
}
