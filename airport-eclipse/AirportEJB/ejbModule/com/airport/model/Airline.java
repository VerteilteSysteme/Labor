package com.airport.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@NamedQuery(name="airline.findAll", query="select a from Airline a order by a.name")

@Entity
public class Airline {
	
	@Id
	@GeneratedValue

	private int id;
	
	@OneToMany(mappedBy = "airline")
	private Set<Airplane> airplanes = new HashSet<Airplane>(0);
	
	private String name;
	
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
	
	public Set<Airplane> getAirplanes() {
		return airplanes;
	}
	
	public void addAirplane(Airplane airplane) {
		airplanes.add(airplane);
	}
	
}

