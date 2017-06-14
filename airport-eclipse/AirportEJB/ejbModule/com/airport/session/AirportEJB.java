package com.airport.session;import java.util.List;import javax.ejb.Stateless;import javax.persistence.EntityManager;import javax.persistence.PersistenceContext;import javax.persistence.Query;import com.airport.model.Airplane;import com.airport.model.Runway;import com.airport.model.ParkingPosition;@Statelesspublic class AirportEJB {	@PersistenceContext(unitName="airport")	private EntityManager entityManager;	//Airplane	public List<Airplane> getAirplanes() {		Query query = entityManager.createNamedQuery("airplane.findAll");				@SuppressWarnings("unchecked")		List<Airplane> airplanes = query.getResultList();		return airplanes;	}	public List<Airplane> getAirplanesWithoutRunway() {		Query query = entityManager.createNamedQuery("airplane.findWithoutRunway");				@SuppressWarnings("unchecked")		List<Airplane> airplanes = query.getResultList();		return airplanes;	}	public List<Airplane> getAirplanesWithoutParkingPosition() {		Query query = entityManager.createNamedQuery("airplane.findWithoutParkingPosition");				@SuppressWarnings("unchecked")		List<Airplane> airplanes = query.getResultList();		return airplanes;	}		public List<Airplane> getAirplaneById(int id) {		Query query = entityManager.createNamedQuery("airplane.findId").setParameter("id", id);		@SuppressWarnings("unchecked")		List<Airplane> airplanes = query.getResultList();		return airplanes;	}		public void store(Airplane airplane) {		entityManager.persist(airplane);	}		//Runway	public List<Runway> getRunways() {		Query query = entityManager.createNamedQuery("runway.findAll");				@SuppressWarnings("unchecked")		List<Runway> runways = query.getResultList();		return runways;	}	public boolean runwayExists(int no) {	Query query = entityManager.createNamedQuery("runway.findNo").setParameter("no", no);		@SuppressWarnings("unchecked")		List<Runway> runways = query.getResultList();		return !runways.isEmpty();	}	public List<Runway> getFreeRunways(){		Query query = entityManager.createNamedQuery("runway.findFree");		@SuppressWarnings("unchecked")		List<Runway> runways = query.getResultList();		return runways;	}	public List<Runway> getRunwayById(int id) {		Query query = entityManager.createNamedQuery("runway.findNo").setParameter("no", id);		@SuppressWarnings("unchecked")		List<Runway> runways = query.getResultList();		return runways;	}	public void storeRunway(Runway runway) {		entityManager.persist(runway);	}		//ParkingPosition	public List<ParkingPosition> getParkingPositions() {		Query query = entityManager.createNamedQuery("parkingPosition.findAll");				@SuppressWarnings("unchecked")		List<ParkingPosition> parkingPositions = query.getResultList();		return parkingPositions;	}		public boolean parkingPositionExists(int no) {		Query query = entityManager.createNamedQuery("parkingPosition.findNo").setParameter("no", no);		@SuppressWarnings("unchecked")		List<ParkingPosition> parkingPosition = query.getResultList();		return !parkingPosition.isEmpty();	}		public List<ParkingPosition> getFreeParkingPositions(){		Query query = entityManager.createNamedQuery("parkingPosition.findFree");		@SuppressWarnings("unchecked")		List<ParkingPosition> parkingPosition = query.getResultList();		return parkingPosition;	}		public List<ParkingPosition> getParkingPositionById(int id) {		Query query = entityManager.createNamedQuery("parkingPosition.findNo").setParameter("no", id);		@SuppressWarnings("unchecked")		List<ParkingPosition> parkingPosition = query.getResultList();		return parkingPosition;	}		public void storeParkingPosition(ParkingPosition parkingPosition) {		entityManager.persist(parkingPosition);	}		//AirPlane on Runway	public void saveAirplaneRunway(int aid, int rid){		List<Airplane> aList = getAirplaneById(aid);		List<Runway> rList = getRunwayById(rid);		Airplane a = aList.get(0);		Runway r = rList.get(0);		r.setIsFree(false);		a.setRunway(r);	}	//AirPlane on Parking Position	public void saveAirplaneParkingPosition(int aid, int rid){		List<Airplane> aList = getAirplaneById(aid);		List<ParkingPosition> rList = getParkingPositionById(rid);		Airplane a = aList.get(0);		ParkingPosition r = rList.get(0);		r.setIsFree(false);		a.setParkingPosition(r);	}		public void freeRunway(int aid){		List<Airplane> aList = getAirplaneById(aid);		Airplane a = aList.get(0);		Runway r = a.getRunway();		r.setIsFree(true);		}}