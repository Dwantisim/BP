package pack1.vpsToRemove;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VPs {
	@Id
	@GeneratedValue
	private Long id;
	
    private String forName;
    private String famName;
    private String shortcut;

    
    public VPs() {
		super();
	}

	public VPs(Long id, String name, String famName) {
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
	public String getfamName() {
		return famName;
	}
	public void setfamName(String famName) {
		this.famName = famName;
	}
		
}

