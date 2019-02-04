package st_prim_lazy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimLazyAlgorithm {
	
	private List<Vertex> unvisitedVertex;
	private List<Edge> spanningTree;
	private PriorityQueue<Edge> edgeHeap;
	private double fullCost;
	
	public PrimLazyAlgorithm(List<Vertex> unvisitedList) {
		this.unvisitedVertex = unvisitedList;
		this.spanningTree = new ArrayList<>();
		this.edgeHeap = new PriorityQueue<>();
	}

	public void primAlgorithm(Vertex vertex) {
		
		this.unvisitedVertex.remove(vertex);
		
		while (!unvisitedVertex.isEmpty()) {
			for (Edge edge : vertex.getAdjacencies()) {
				if(unvisitedVertex.contains(edge.getTargetVertex())) {
					edgeHeap.add(edge);
				}
			}
			
			Edge minEdge = edgeHeap.remove();
			
			spanningTree.add(minEdge);
			this.fullCost += minEdge.getWeight(); 
			
			vertex = minEdge.getTargetVertex();
			this.unvisitedVertex.remove(vertex);
		}
	}
	
	public void showMST() {
		
		System.out.println("The minimun spanning tree cost is: " + this.fullCost);
		
		for (Edge edge : spanningTree) {
			System.out.println(edge.getStartVertex() + " - " +edge.getTargetVertex());
		}
	}
}
