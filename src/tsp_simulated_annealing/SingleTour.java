package tsp_simulated_annealing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleTour {
	
	private List<City> tour;
	private double distance = 0;
	
	public SingleTour() {
		this.tour = new ArrayList<>(Repository.getNumberOfCities());
		for (int i = 0; i < Repository.getNumberOfCities(); i++) {
			this.tour.add(null);
		}
	}
	
	public SingleTour(List<City> tour) {
		List<City> currentTour = new ArrayList<>(tour.size());
		for (int i = 0; i < Repository.getNumberOfCities(); i++) {
			currentTour.add(null);
		}
		
		for (int i = 0; i < tour.size(); i++) {
			currentTour.set(i, tour.get(i));
		}
		
		this.tour = currentTour;
	}
	
	public double getDistance() {
		
		if(this.distance == 0) {
			
			int tourDistance = 0;
			
			for (int cityIndex = 0; cityIndex < tourSize(); cityIndex++) {
				City fromCity = getCity(cityIndex);
				City destinationCity;
				
				if(cityIndex+1 < tourSize()) {
					destinationCity = getCity(cityIndex+1);
				}else {
					destinationCity = getCity(0);
				}
				
				tourDistance += fromCity.distanceTo(destinationCity);
			}
			
			this.distance = tourDistance;
		}
		
		return this.distance;
	}
	
	public List<City> getTour() {
		return tour;
	}
	
	public void generateIndividual() {
		for (int cityIndex = 0; cityIndex < Repository.getNumberOfCities(); cityIndex++) {
			setCity(cityIndex, Repository.getCity(cityIndex));
		}
		
		Collections.shuffle(tour);
	}

	public void setCity(int cityIndex, City city) {
		this.tour.set(cityIndex, city);
		this.distance = 0;
	}

	public City getCity(int tourPosition) {
		return this.tour.get(tourPosition);
	}
	
	public int tourSize() {
		return this.tour.size();
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tourSize(); i++) {
			sb.append(" "+getCity(i));
		}
		
		return sb.toString();
	}
	
}
