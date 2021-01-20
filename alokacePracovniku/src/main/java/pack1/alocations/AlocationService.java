package pack1.alocations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack1.worker.Worker;
import pack1.worker.WorkerRepository;

import java.util.List;

@Service
public class AlocationService {

    @Autowired
    private AlocationRepository repository;

    public List<Alocation> getAllAlocations () {

        return repository.findAll();

    }

    public List<Alocation> getAlocationsByWorker(Worker worker){


        return repository.findByWorkerId(worker.getId());
    }



}
