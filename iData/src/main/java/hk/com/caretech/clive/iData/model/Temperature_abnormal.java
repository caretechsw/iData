package hk.com.caretech.clive.iData.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Temperature_abnormal {
	
	@Id
	private String dev_timestamp;
	private int elder_id;
	private double temperature;
	private Timestamp timestamp;
	private String device_id;
	
	
	public Temperature_abnormal() {
		super();
	}


	public Temperature_abnormal(String dev_timestamp, int elder_id, double temperature, Timestamp timestamp,
			String device_id) {
		super();
		this.dev_timestamp = dev_timestamp;
		this.elder_id = elder_id;
		this.temperature = temperature;
		this.timestamp = timestamp;
		this.device_id = device_id;
	}


	public String getDev_timestamp() {
		return dev_timestamp;
	}


	public void setDev_timestamp(String dev_timestamp) {
		this.dev_timestamp = dev_timestamp;
	}


	public int getElder_id() {
		return elder_id;
	}


	public void setElder_id(int elder_id) {
		this.elder_id = elder_id;
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


	public String getDevice_id() {
		return device_id;
	}


	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	
	
	
	

}