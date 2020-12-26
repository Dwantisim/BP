package cz.zcu.students.capacityAlocator.model;

import java.util.HashMap;

public class WorkerSummary {
	private Long id;

	private String shortcut;
	private String section;
	private Long harness;
	private int reserve;
	private int harnessCapacity;
	private int absence;
	private int capacity;
	private int freeCapacity;
	private int specCapacity;
	private String note;
	private HashMap<Long, Integer> alocations;

	public WorkerSummary() {
		alocations = new HashMap<Long, Integer>();
	}
	
	public HashMap<Long, Integer> getAlocations() {
		return alocations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Long getHarness() {
		return harness;
	}

	public void setHarness(Long harness) {
		this.harness = harness;
	}

	public int getReserve() {
		return reserve;
	}

	public void setReserve(int reserve) {
		this.reserve = reserve;
	}

	public int getHarnessCapacity() {
		return harnessCapacity;
	}

	public void setHarnessCapacity(int harnessCapacity) {
		this.harnessCapacity = harnessCapacity;
	}

	public int getAbsence() {
		return absence;
	}

	public void setAbsence(int absence) {
		this.absence = absence;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getFreeCapacity() {
		return freeCapacity;
	}

	public void setFreeCapacity(int freeCapacity) {
		this.freeCapacity = freeCapacity;
	}

	public int getSpecCapacity() {
		return specCapacity;
	}

	public void setSpecCapacity(int specCapacity) {
		this.specCapacity = specCapacity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
