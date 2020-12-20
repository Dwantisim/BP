package pack1.alocations;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pack1.worker.Worker;
import pack1.worker.WorkerController;

@SpringBootApplication
public class Alocation {
	@Id
	@GeneratedValue
	private Long id;

	private Worker worker;
	private Worker VP;
	private int value;
	public Alocation(Long id, Worker worker, Worker vP, int value) {
		super();
		this.id = id;
		this.worker = worker;
		VP = vP;
		this.value = value;
	
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	public Worker getVP() {
		return VP;
	}
	public void setVP(Worker vP) {
		VP = vP;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public static List<Alocation> getAllAlocations () {
		List<Alocation> alocations = AlocationController.retrieveAllAlocations();
		return alocations;
		
	}
}
