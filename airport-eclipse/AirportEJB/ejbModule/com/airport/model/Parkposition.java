package com.airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name="Parkposition.findAll", query="select a from Parkposition a order by a.parkpositionNo"),
	@NamedQuery(name="Parkposition.findNo", query="select a from Parkposition a where a.parkpositionNo = :no"),
	@NamedQuery(name="Parkposition.findFree", query="select a from Parkposition a where a.isFree = true order by a.parkpositionNo"),
})

@Entity
public class Parkposition {
	
	@Id
	@GeneratedValue
	private int id;	
	private int parkpositionNo;
	private boolean isFree = true;

	public Parkposition(){}

	public Parkposition(int ppNo) {
		this.parkpositionNo = ppNo;	
	}
	
	public int getparkpositionNo() {
		return parkpositionNo;
	}


	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean status) {
		this.isFree = status;
	}


}
