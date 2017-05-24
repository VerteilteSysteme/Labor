package com.airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name="airplane.findAll", query="select a from Airplane a order by a.name")

@Entity
public class Airplane {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private int eta;
	private String arrivalTime;
	private String airline;
	private int runwayNo;
	private int parkingNo;

	
	public int getrunwayNo() {
		return runwayNo;
	}

	public void setrunwayNo(int no) {
		this.runwayNo = no;
	}


	public int getparkingNo() {
		return parkingNo;
	}

	public void setparkingNo(int no) {
		this.parkingNo = no;
	}


	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
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
}
