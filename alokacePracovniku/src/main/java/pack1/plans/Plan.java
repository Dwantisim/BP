package pack1.plans;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plan {
	@Id
	@GeneratedValue
	private Long id;
	
    private int days;
    private LocalDate startDate;
    private LocalDate endDate;
    private int month;
    private boolean monthlyDated;
    private String log;

    
    public Plan() {
		super();
	}

	public Plan(Long id, int days, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.days = days;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDays() {
		return this.days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public LocalDate getStartDate() {
		return this.startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return this.endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
		
		
}

