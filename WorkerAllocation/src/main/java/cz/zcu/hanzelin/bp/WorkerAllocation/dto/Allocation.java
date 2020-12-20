package cz.zcu.hanzelin.bp.WorkerAllocation.dto;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Allocation {
	@Id
	@GeneratedValue
	private int id;

	private Worker worker;
	private Worker VP;
	private int value;

	public int getId() {
		return id;
	}
	public void setId(int id) {
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

}
