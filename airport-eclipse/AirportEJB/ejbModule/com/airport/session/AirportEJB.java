package com.airport.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.airport.model.Airplane;
import com.airport.model.Runway;

@Stateless
public class AirportEJB {

	@PersistenceContext(unitName="airport")
	private EntityManager entityManager;
	
	public List<Airplane> getAirplanes() {
		Query query = entityManager.createNamedQuery("airplane.findAll");
		
		@SuppressWarnings("unchecked")
		List<Airplane> airplanes = query.getResultList();
		return airplanes;
	}
	
	public List<Runway> getRunways() {
		Query query = entityManager.createNamedQuery("runway.findAll");
		
		@SuppressWarnings("unchecked")
		List<Runway> runways = query.getResultList();
		return runways;
	}

	public boolean runwayExists(int no) {
		Query query = entityManager.createNamedQuery("runway.findNo").setParameter("no", no);
		@SuppressWarnings("unchecked")
		List<Runway> runways = query.getResultList();
		return !runways.isEmpty();
	}
	
	public void store(Airplane airplane) {
		entityManager.persist(airplane);
	}

	public void storeRunway(Runway runway) {
		entityManager.persist(runway);
	}

}
