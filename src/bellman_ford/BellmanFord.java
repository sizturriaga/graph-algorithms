package bellman_ford;

import java.util.List;

public class BellmanFord {

	private List<Edge> edgeList;
	private List<Vertex> vertexList;
	
	public BellmanFord(List<Edge> edgeList, List<Vertex> vertexList) {
		this.edgeList = edgeList;
		this.vertexList = vertexList;
	}
	
	public void bellmanFord(Vertex sourceVertex) {
		
		sourceVertex.setDistance(0);
		
		for (int i = 0; i < vertexList.size(); i++) {
			for (Edge edge : edgeList) {
				if(edge.getStartVertex().getDistance() == Double.MAX_VALUE) continue; 
				
				double newDistance = edge.getStartVertex().getDistance() + edge.getWeight();
				
				if(newDistance < edge.getTargetVertex().getDistance()) {
					edge.getTargetVertex().setDistance(newDistance); 
					edge.getTargetVertex().setPreviousVertex(edge.getStartVertex());
				}
			}
			
		}
		
		for (Edge edge : edgeList) {
			if(edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
				
				if(hasCycle(edge)) {
					System.out.println("There's a cycle");
					return;
				}
				
			}
		}
		
	}

	private boolean hasCycle(Edge edge) {
		return (edge.getStartVertex().getDistance() + edge.getWeight()) < edge.getTargetVertex().getDistance();
	}
	
	public void shortestPathTo(Vertex targetVertex){
		if(targetVertex.getDistance() == Double.MAX_VALUE) System.out.println("There's no path");
		
		Vertex actualVertex = targetVertex;
		
		while (actualVertex != null) {
			System.out.print(actualVertex+" - ");
			actualVertex = actualVertex.getPreviousVertex();
		}
		
		
	} 
}
