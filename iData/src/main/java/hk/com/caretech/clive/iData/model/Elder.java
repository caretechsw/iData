package hk.com.caretech.clive.iData.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Elder {
	
	public Elder() {
		super();
	}
	public Elder(int id, String name, int bed_no) {
		super();
		this.id = id;
		this.name = name;
		this.bed_no = bed_no;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int bed_no;
	
//	
//	@OneToMany(mappedBy = "elderid")
//	private List<Temperature> temperatures;
//
//	public List<Temperature> getTemperatures() {
//		return temperatures;	}
//	public void setTemperatures(List<Temperature> temperatures) {
//		this.temperatures = temperatures;
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBed_no() {
		return bed_no;
	}
	public void setBed_no(int bed_no) {
		this.bed_no = bed_no;
	}
}
