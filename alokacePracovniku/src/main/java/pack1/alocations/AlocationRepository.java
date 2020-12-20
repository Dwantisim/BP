package pack1.alocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlocationRepository extends JpaRepository<Alocation, Long>{

}
