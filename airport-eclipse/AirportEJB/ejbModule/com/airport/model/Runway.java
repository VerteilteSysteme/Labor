package com.airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name="runway.findAll", query="select a from Runway a order by a.runwayNo")

@Entity
public class Runway {
	
	@Id
	@GeneratedValue
	private int id;

	private int maxRunways = 4; 	
	private int runwayNo;
	//private boolean isFree = true;

	public Runway(){}

	public Runway(int rwNo) {
		if(rwNo <= maxRunways && rwNo > 0) {
			this.runwayNo = rwNo;	
		}	
	}
	
	public int getrunwayNo() {
		return runwayNo;
	}


	public int getMaxRunways() {
		return maxRunways;
	}

/*	public boolean getStatus() {
		return isFree;
	}

	public void setStatus(boolean status) {
		this.isFree = status;
	}
*/
}
