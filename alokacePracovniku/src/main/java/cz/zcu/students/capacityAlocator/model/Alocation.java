package cz.zcu.students.capacityAlocator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idWorker;

	private Long idVP;

	private Long idPlan;

	private int manDays;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getManDays() {
		return manDays;
	}

	public void setManDays(int manDays) {
		this.manDays = manDays;
	}

	public Long getIdWorker() {
		return idWorker;
	}

	public void setIdWorker(Long idWorker) {
		this.idWorker = idWorker;
	}

	public Long getIdVP() {
		return idVP;
	}

	public void setIdVP(Long idVP) {
		this.idVP = idVP;
	}

	public Long getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Long idPlan) {
		this.idPlan = idPlan;
	}

}
