package com.airport.model;

import javax.persistence.*;


@NamedQuery(name="Parkposition.findParkposition", query="select pp from Parkposition pp WHERE pp.reserved = FALSE")

@Entity
public class Parkposition {
	
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
	
	public Airplane getAirplaneOnParkposition() {
		return airplane;
	}
	
	public void setAirplaneOnParkposition(Airplane pp) {
		airplane = pp;
	}
	
	public void reserveParkposition() {
		if (reserved == true) reserved = false;
	}

}
