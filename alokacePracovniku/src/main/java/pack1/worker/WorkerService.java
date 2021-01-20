package pack1.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class WorkerService {
    @Autowired
    private WorkerRepository repository;

    public  List<Worker> getAllWorkers () {
        List<Worker> workers = repository.findAll();
        return workers;

    }
}
