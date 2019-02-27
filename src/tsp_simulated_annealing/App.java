package tsp_simulated_annealing;

public class App {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 100; i++) {
			Repository.addCity(new City());
		}
		
		SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
		simulatedAnnealing.simulation();
		
		System.out.println("Final approximated solution's distance is: "+simulatedAnnealing.getBest().getDistance());
	}

}
