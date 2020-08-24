package hk.com.caretech.clive.iData.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import hk.com.caretech.clive.iData.controller.TemperatureController;

@Entity
public class Elder {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int bed_no;
	private int status_delete;
	
		public Elder() {
		super();
	}

		public Elder(int id, String name, int bed_no, int status_delete) {
			super();
			this.id = id;
			this.name = name;
			this.bed_no = bed_no;
			this.status_delete = status_delete;
		}

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

		public int getStatus_delete() {
			return status_delete;
		}

		public void setStatus_delete(int status_delete) {
			this.status_delete = status_delete;
		}
		
		
		public static String TAG = Elder.class.getName();

}
