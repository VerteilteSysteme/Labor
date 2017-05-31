package com.airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@NamedQueries({
	@NamedQuery(name="parkingPosition.findAll", query="select a from ParkingPosition a order by a.parkingPositionNo"),
	@NamedQuery(name="parkingPosition.findPos", query="select a from ParkingPosition a where a.parkingPositionNo = :pos"),
	@NamedQuery(name="parkingPosition.findFree", query="select a from ParkingPosition a where a.isFree = true order by a.parkingPositionNo"),
})

@Entity
public class ParkingPosition {
	
	@Id
	@GeneratedValue
	private int id;	
	private int parkingPositionNo;
	private boolean isFree = true;

	public ParkingPosition(){}

	public ParkingPosition(int rwNo) {
		this.parkingPositionNo = rwNo;	
	}
	
	public int getparkingPositionNo() {
		return parkingPositionNo;
	}


	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean status) {
		this.isFree = status;
	}
}