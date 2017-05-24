package com.airport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;

@NamedQueries({
@NamedQuery(name="airplane.findAll", query="select a from Airplane a order by a.name"),
@NamedQuery(name="airplane.findId", query="select a from Airplane a where a.id = :id"),
})

@Entity
public class Airplane {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private int eta;
	private String arrivalTime;
	@OneToOne
	private Runway runway;


	public Runway getRunway(){
		return runway;
	}

	public void setRunway(Runway runway) {
		this.runway = runway;
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
