package sp_dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

	public void computePath(Vertex sourceVertex) {
		sourceVertex.setDistance(0);
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceVertex);
		
		while (!priorityQueue.isEmpty()) {
			Vertex actualVertex = priorityQueue.poll(); 
			
			for (Edge edge : actualVertex.getAdjacenciesList()) {
				Vertex v = edge.getTargetVertex();
				double newDistance = actualVertex.getDistance() + edge.getWeight();
				if(newDistance < v.getDistance()) {
					//priorityQueue.remove(v);
					
					v.setDistance(newDistance);
					v.setPredecesor(actualVertex);
					
					if(!v.isVisited()) {
						v.setVisited(true);
						priorityQueue.add(v);
					}
				}
				
			}
		}
	}
	
	public List<Vertex> getShortestPath(Vertex targetVertex){
		List<Vertex> shortestPathToTarget = new ArrayList<>();

		for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecesor()) {
			shortestPathToTarget.add(vertex);
		}
		
		Collections.reverse(shortestPathToTarget);
		
		return shortestPathToTarget;
	}
}
