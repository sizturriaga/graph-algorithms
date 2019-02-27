package tsp_simulated_annealing;

public class City {
	
	private int x;
	private int y;
	
	public City() {
		this.x = (int)(Math.random()*100);
		this.y = (int)(Math.random()*100);
	}
	
	public City(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public double distanceTo(City otherCity) {
		double xDistance = Math.abs(getX()) - otherCity.getX();
		double yDistance = Math.abs(getY()) - otherCity.getY();
		
		double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
		return distance;
	}

	@Override
	public String toString() {
		return this.x+"-"+y;
	}
	
	
	
}
