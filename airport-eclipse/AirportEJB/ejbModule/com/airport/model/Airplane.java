package com.airport.model;

import javax.persistence.*;

@NamedQueries({
    @NamedQuery(name="airplane.findAll",
                query="select a from Airplane a order by a.name"),
    @NamedQuery(name="airplane.Landing",
    query="select a from Airplane a where a.landing = TRUE"),
    @NamedQuery(name="airplane.byAirline",
    query="select a from Airplane a where a.airline = :airline AND a.landing = FALSE")
}) 

@Entity
public class Airplane {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private boolean landing = false;
	
	@ManyToOne(cascade = CascadeType.ALL)

	private Airline airline;

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
	
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	public Airline getAirline() {
		return airline;
	}
	
	public boolean getLanding() {
		return landing;
	}
	
	public void setLanding() {
		landing = true;
	}
	
	public void stopLanding() {
		landing = false;
	} 
}
