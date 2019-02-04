package sp_dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
	
	private String name;
	private List<Edge> adjacenciesList;
	private boolean visited;
	private Vertex predecesor;
	private double distance = Double.MAX_VALUE;
	
	public Vertex(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<>();
	}
	
	public void addNeigbour(Edge edge) {
		this.adjacenciesList.add(edge);
	}
	
	public String getName() {
		return name;
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

	public boolean isVisited() {
		return visited;
	}

	public Vertex getPredecesor() {
		return predecesor;
	}

	public double getDistance() {
		return distance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setPredecesor(Vertex predecesor) {
		this.predecesor = predecesor;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Vertex otherVertex) {
		return Double.compare(this.distance, otherVertex.getDistance());
	}	
	
	@Override
	public String toString() {
		return this.name;
	}

}
