package com.airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQuery(name="runway.findFreeRunway", query="select rw from Runway rw where rw.reserved = FALSE")

@Entity
public class Runway {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private Boolean reserved = false;
	
	@OneToOne
	private Airplane airplane;
	
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
	
	public Boolean getStatus() {
		return reserved;
	}
	
	public void setStatus(Boolean status) {
		reserved = status;
	}
	
	public Airplane getAirplaneOnRunway() {
		return airplane;
	}
	
	public void setAirplaneOnRunway(Airplane ap) {
		airplane = ap;
	}
	
	public void reserveRunway() {
		if (reserved == true) reserved = false;
	}

}
