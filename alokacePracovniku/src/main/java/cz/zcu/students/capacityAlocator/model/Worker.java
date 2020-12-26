package pack1.worker;
import java.util.List;

//ToDo Pull z databáze
//ToDo Absence
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Worker {
	@Id
	@GeneratedValue
	private Long id;
	
    private String forName;
    private String famName;
    private String shortcut;
    private String section;
    private Long harness;

    private int reserve;
    private int absence;
   
    private String note;
    private boolean VP;
    
    public Worker(Long id, String forName, String famName, String shortcut, String section, Long harness, int reserve,
			int absence, String note, boolean vP) {
		super();
		this.id = id;
		this.forName = forName;
		this.famName = famName;
		this.shortcut = shortcut;
		this.section = section;
		this.harness = harness;
		this.reserve = reserve;
		this.absence = absence;
		this.note = note;
		VP = vP;
	}

	public Worker() {
		super();
	}

	public Worker(Long id, String name, String famName) {
		super();
		this.id = id;
		this.forName = name;
		this.famName = famName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return forName;
	}
	public void setName(String name) {
		this.forName = name;
	}
	public String getForName() {
		return forName;
	}

	public void setForName(String forName) {
		this.forName = forName;
	}

	public String getFamName() {
		return famName;
	}

	public void setFamName(String famName) {
		this.famName = famName;
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

	public int getAbsence() {
		return absence;
	}

	public void setAbsence(int absence) {
		this.absence = absence;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getfamName() {
		return famName;
	}
	public void setfamName(String famName) {
		this.famName = famName;
	}

	public static List<Worker> getAllWorkers () {
		List<Worker> workers = WorkerController.retrieveAllWorkers();
		return workers;
		
	}
	public boolean getVP() {
		return VP;
	}

	public void setVP(boolean VP) {
		this.VP = VP;
	}
}

