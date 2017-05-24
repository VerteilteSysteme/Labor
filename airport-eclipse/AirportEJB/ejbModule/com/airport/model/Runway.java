package com.airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name="runway.findAll", query="select a from Runway a order by a.runwayNo"),
	@NamedQuery(name="runway.findNo", query="select a from Runway a where a.runwayNo = :no"),
	@NamedQuery(name="runway.findFree", query="select a from Runway a where a.isFree = true order by a.runwayNo"),
})

@Entity
public class Runway {
	
	@Id
	@GeneratedValue
	private int id;	
	private int runwayNo;
	private boolean isFree = true;

	public Runway(){}

	public Runway(int rwNo) {
		this.runwayNo = rwNo;	
	}
	
	public int getrunwayNo() {
		return runwayNo;
	}


	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean status) {
		this.isFree = status;
	}

}
