package scc_kosaraju;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Vertex> vertexList;
	private List<Edge> edgeList;
	
	public Graph() {}
	
	public Graph(List<Vertex> vertexList, List<Edge> edgeList) {
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}

	public List<Vertex> getVertexList() {
		return vertexList;
	}

	public void setVertexList(List<Vertex> vertexList) {
		this.vertexList = vertexList;
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}

	public void setEdgeList(List<Edge> edgeList) {
		this.edgeList = edgeList;
	}
	
	public Graph getTransposedGraph() {
		
		Graph transposedGraph = new Graph();
		List<Vertex> transposedVertexList = new ArrayList<>();
		
		for (Vertex vertex : vertexList) {
			transposedVertexList.add(vertex);
		}
		
		for (Edge edge : edgeList) {
			transposedVertexList.get(transposedVertexList.indexOf(edge.getTargetVertex())).addNeighbour(edge.getStartVertex());
		}
		
		transposedGraph.setVertexList(transposedVertexList);
		
		return transposedGraph;
		
	}
	
}
