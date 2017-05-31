package com.airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name="parkingPosition.findAll", query="select a from ParkingPosition a order by a.parkingPos"),
	@NamedQuery(name="parkingPosition.findNo", query="select a from ParkingPosition a where a.parkingPos = :no"),
	@NamedQuery(name="parkingPosition.findFree", query="select a from ParkingPosition a where a.isFree = true order by a.parkingPos"),
})

@Entity
public class ParkingPosition {
	
	@Id
	@GeneratedValue
	private int id;	
	private int parkingPos;
	private boolean isFree = true;

	public ParkingPosition(){}

	public ParkingPosition(int rwNo) {
		this.parkingPos = rwNo;	
	}
	
	public int getparkingPosition() {
		return parkingPos;
	}


	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean status) {
		this.isFree = status;
	}
}