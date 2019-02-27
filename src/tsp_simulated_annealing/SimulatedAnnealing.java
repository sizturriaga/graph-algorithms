package tsp_simulated_annealing;

public class SimulatedAnnealing {

	private SingleTour best;

	public void simulation() {

		double tempereture = 1000;
		double coolingRate = 0.003;

		SingleTour currentSolution = new SingleTour();
		currentSolution.generateIndividual();
		double currentEnergy = currentSolution.getDistance();

		System.out.println("Initial solution distance: " + currentEnergy);

		best = new SingleTour(currentSolution.getTour());

		while (tempereture > 1) {

			SingleTour newSolution = new SingleTour(currentSolution.getTour());

			int randomIndex1 = (int) (newSolution.tourSize() * Math.random());
			City city1 = newSolution.getCity(randomIndex1);

			int randomIndex2 = (int) (newSolution.tourSize() * Math.random());
			City city2 = newSolution.getCity(randomIndex2);

			newSolution.setCity(randomIndex2, city1);
			newSolution.setCity(randomIndex1, city2);

			double neibourEnergy = newSolution.getDistance();

			if (acceptanceProbability(currentEnergy, neibourEnergy, tempereture) > Math.random()) {
				currentSolution = new SingleTour(newSolution.getTour());
			}

			if (currentSolution.getDistance() < best.getDistance()) {
				best = new SingleTour(currentSolution.getTour());
			}

			tempereture *= 1 - coolingRate;
		}

	}

	private double acceptanceProbability(double currentEnergy, double neibourEnergy, double tempereture) {

		if (neibourEnergy < currentEnergy) {
			return 1;
		}
		return Math.exp((currentEnergy - neibourEnergy) / tempereture);
	}

	public SingleTour getBest() {
		return best;
	}

}
