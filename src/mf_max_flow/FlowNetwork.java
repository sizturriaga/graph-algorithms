package mf_max_flow;

import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {

	private int numOfVertices;
	private int numbOfEdges;
	private List<List<Edge>> adjacenciesList;
	
	public FlowNetwork(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		this.numbOfEdges = 0;
		this.adjacenciesList = new ArrayList<>();
		
		for (int i = 0; i < this.numOfVertices; i++) {
			this.adjacenciesList.add(new ArrayList<Edge>());
		}
	}
	
	public int getNumOfVertices() {
		return this.numOfVertices;
	}
	
	public int getNumbOfEdges() {
		return this.numbOfEdges;
	}
	
	public void addEdge(Edge edge) {
		Vertex v = edge.getFromVertex();
		Vertex w = edge.getTargetVertex();
		adjacenciesList.get(v.getId()).add(edge);
		adjacenciesList.get(w.getId()).add(edge);
		numbOfEdges++;
	}
	
	public List<Edge> getAdjacenciesList(Vertex v){
		return this.adjacenciesList.get(v.getId());
	}
	
}
