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

	public List<Runway> getFreeRunways(){
		Query query = entityManager.createNamedQuery("runway.findFree");
		@SuppressWarnings("unchecked")
		List<Runway> runways = query.getResultList();
		return runways;
	}

	public List<Runway> getRunwayById(int id) {
		Query query = entityManager.createNamedQuery("runway.findNo").setParameter("no", id);
		@SuppressWarnings("unchecked")
		List<Runway> runways = query.getResultList();
		return runways;
	}

	public List<Airplane> getAirplaneById(int id) {
		Query query = entityManager.createNamedQuery("airplane.findId").setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Airplane> airplanes = query.getResultList();
		return airplanes;
	}
	
	public void store(Airplane airplane) {
		entityManager.persist(airplane);
	}

	public void storeRunway(Runway runway) {
		entityManager.persist(runway);
	}

	public void saveAirplaneRunway(Airplane a, int rid){
		//List<Airplane> aList = getAirplaneById(aid);
		List<Runway> rList = getRunwayById(rid);
		//Airplane a = aList.get(0);
		Runway r = rList.get(0);
		r.setIsFree(false);
		List<Airplane> planes = getAirplaneById(a.getId());
		Airplane b = planes.get(0);
		b.setRunway(r);
		//entityManager.merge(a);
	}

}
