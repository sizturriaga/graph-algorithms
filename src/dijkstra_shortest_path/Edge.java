package dijkstra_shortest_path;

public class Edge {
	
	private double weight;
	private Vertex startVertex;
	private Vertex targetVertex;
	
	public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
		super();
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}
	
	public double getWeight() {
		return weight;
	}
	public Vertex getStartVertex() {
		return startVertex;
	}
	public Vertex getTargetVertex() {
		return targetVertex;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}
	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}
	
	
}
