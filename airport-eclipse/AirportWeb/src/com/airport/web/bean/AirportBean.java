package com.airport.web.bean;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.airport.model.Airplane;
import com.airport.model.Runway;
import com.airport.session.AirportEJB;

@ManagedBean(name="airportBean")
@ViewScoped
public class AirportBean implements Serializable {
	private static final long serialVersionUID = 1665363412715858198L;

	@EJB
	private AirportEJB airportEJB;
	
	private Airplane airplane;
	private Runway runway;
	
	public AirportBean() {
		System.out.println("AIRPORT: " + UUID.randomUUID());
	}
	
	@PostConstruct
	private void init() {
		airplane = new Airplane();
		for(int i = 1; i<=4; i++){
			if(!airportEJB.runwayExists(i)){
				runway = new Runway(i);
				airportEJB.storeRunway(runway);
			}
		}		
	
	}
	
	public List<Airplane> getAirplanes() {
		return airportEJB.getAirplanes();
	}
	
	public List<Runway> getRunways() {
		return airportEJB.getRunways();
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public Runway getRunway() {
		return runway;
	}
	
	public void store() {
		airportEJB.store(airplane);
		airplane = new Airplane();

	}
}
