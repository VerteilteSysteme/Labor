package com.airport.web.bean;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.lang.Integer;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.airport.model.Airplane;
import com.airport.model.Runway;
import com.airport.model.Parkposition;
import com.airport.session.AirportEJB;

@ManagedBean(name="airportBean")
@ViewScoped
public class AirportBean implements Serializable {
	private static final long serialVersionUID = 1665363412715858198L;

	@EJB
	private AirportEJB airportEJB;

	private String debug = "";
	
	private Airplane airplane;
	private Runway runway;
	private Parkposition parkposition;

	private String airplaneId = "a";
	private String runwayId = "a";
	private String parkpositionId = "a";
	
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

	public List<String> getAirplaneNames(){
		List<Airplane> airplanes = getAirplanes();
		List<String> names = new ArrayList<String>();
		for(int i = 0; i<airplanes.size(); i++){
			names.add(airplanes.get(i).getName());
		}
		return names;
	}

	public List<String> getAirplaneIds(){
		List<Airplane> airplanes = getAirplanes();
		List<String> ids = new ArrayList<String>();
		for(int i = 0; i<airplanes.size(); i++){
			ids.add(String.valueOf(airplanes.get(i).getId()));
		}
		return ids;
	}
	
	public List<Parkposition> getParkpositions() {
		return airportEJB.getParkpositions();
	}

	public List<String> getParkpositionIds(){
		List<Parkposition> parkpositions = getParkpositions();
		List<String> ids = new ArrayList<String>();
		for(int i = 0; i<parkpositions.size(); i++){
			ids.add(String.valueOf(parkpositions.get(i).getparkpositionNo()));
		}
		return ids;
	}
	
	public List<String> getFreeParkpositionIds(){
		List<Parkposition> parkpositions = getFreeParkpositions();
		List<String> ids = new ArrayList<String>();
		for(int i=0; i<parkpositions.size(); i++){
			ids.add(String.valueOf(parkpositions.get(i).getparkpositionNo()));
		}
		return ids;
	}


	public List<String> getFreeRunwayIds(){
		List<Runway> runways = getFreeRunways();
		List<String> ids = new ArrayList<String>();
		for(int i=0; i<runways.size(); i++){
			ids.add(String.valueOf(runways.get(i).getrunwayNo()));
		}
		return ids;
	}

	public List<Runway> getFreeRunways(){
		return airportEJB.getFreeRunways();
	}
	
	public List<Parkposition> getFreeParkpositions(){
		return airportEJB.getFreeParkpositions();
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
	
	public Parkposition getParkposition(){
		return parkposition;
	}

	public String getAirplaneId() {
		return airplaneId;
	}
	public void setAirplaneId(String id) {
		this.airplaneId = id;
	}
	public String getRunwayId() {
		return runwayId;
	}
	public void setRunwayId(String id) {
		this.runwayId = id;
	}

	public String getParkpositionId() {
		return parkpositionId;
	}
	public void setParkpositionId(String id) {
		this.parkpositionId = id;
	}
	
	public String getDebug(){	
		return debug;
	}
	
	public void store() {
		airportEJB.store(airplane);
		airplane = new Airplane();
	}

	public void saveAirplaneRunway() {
		if (airplaneId != "a" && runwayId != "a") {
		int aid = Integer.parseInt(airplaneId);
		int rid = Integer.parseInt(runwayId);
		airportEJB.saveAirplaneRunway(aid,rid);
		}
	}
}
