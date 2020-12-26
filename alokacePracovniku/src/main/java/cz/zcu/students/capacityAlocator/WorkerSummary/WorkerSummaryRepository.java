package pack1.WorkerSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerSummaryRepository extends JpaRepository<WorkerSummary, Long>{

}
