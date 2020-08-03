package hk.com.caretech.clive.iData.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Temperature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int temperature_id;
	private float temperature;
	private int elder_ID;
	private Timestamp timestamp;
	
	
	public Temperature(int temperature_id, float temperature, int elder_ID, Timestamp timestamp) {
		super();
		this.temperature_id = temperature_id;
		this.temperature = temperature;
		this.elder_ID = elder_ID;
		this.timestamp = timestamp;}
	
//	@ManyToOne
//	@JoinColumn(name = "elderid")
//	private Elder elder;
//	
//	public Elder getElder() {
//		return elder;
//	}
//	public void setElder(Elder elder) {
//		this.elder = elder;
//}
	
	
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public int getTemperatureID() {
		return temperature_id;
	}
	public void setTemperatureID(int temperatureID) {
		this.temperature_id = temperatureID;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getElderID() {
		return elder_ID;
	}
	public void setElderID(int elderID) {
		this.elder_ID = elderID;
	}

}
