package prim_eager;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{

	private String name;
	private Edge minEdge; //shortest edge to the actual MST from the non MST vertex
	private boolean visited;
	private Vertex previousVertex;
	private double distance = Double.POSITIVE_INFINITY; //to detect whether heap is in need of refresh because of better weighted edge
	private List<Edge> adjacencies;

	public Vertex(String name) {
		this.name = name;
		this.adjacencies = new ArrayList<>();
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public List<Edge> getAdjacencies() {
		return adjacencies;
	}

	public void setAdjacencies(List<Edge> adjacencies) {
		this.adjacencies = adjacencies;
	}

	public Edge getMinEdge() {
		return minEdge;
	}

	public void setMinEdge(Edge minEdge) {
		this.minEdge = minEdge;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void addEdge(Edge edge) {
		this.adjacencies.add(edge);
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Vertex vertex) {
		return Double.compare(this.getDistance(), vertex.getDistance());
	}
}
