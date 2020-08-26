package hk.com.caretech.clive.iData.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Temperature {
	

	@Id
	private String dev_timestamp;
	private int elder_id;
	private float temperature;
	private Timestamp timestamp;
	private String device_id;
	private int status_delete;
	
		public Temperature() {
		super();
	}



		public Temperature(String dev_timestamp, int elder_id, float temperature, Timestamp timestamp,
				String device_id, int status_delete) {
			super();
			this.dev_timestamp = dev_timestamp;
			this.elder_id = elder_id;
			this.temperature = temperature;
			this.timestamp = timestamp;
			this.device_id = device_id;
			this.status_delete = status_delete;
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

		public float getTemperature() {
			return temperature;
		}

		public void setTemperature(float temperature) {
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



		public int getStatus_delete() {
			return status_delete;
		}



		public void setStatus_delete(int status_delete) {
			this.status_delete = status_delete;
		}
		
		public static String TAG = Temperature.class.getName();
		
	
}
