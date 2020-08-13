package hk.com.caretech.clive.iData.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Temperature {
	

	public Temperature() {
		super();
	}
	@Id
	private String dev_timestamp;
	private String elder_ID;
	private double temperature;
	private Timestamp timestamp;
	
	public Temperature(String dev_timestamp, String elder_ID, double temperature, Timestamp timestamp) {
		super();
		this.dev_timestamp = dev_timestamp;
		this.elder_ID = elder_ID;
		this.temperature = temperature;
		this.timestamp = timestamp;
	}
	

	public String getDev_timestamp() {
		return dev_timestamp;
	}

	public void setDev_timestamp(String dev_timestamp) {
		this.dev_timestamp = dev_timestamp;
	}

	public String getElder_ID() {
		return elder_ID;
	}

	public void setElder_ID(String elder_ID) {
		this.elder_ID = elder_ID;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
