package dfs_cycle_detection;

import java.util.List;

public class CycleDetection {
	
	public void detectCycle(List<Vertex> vertexList) {
		
		for (Vertex vertex : vertexList) {
			if(!vertex.isVisited()) {
				dfs(vertex);
			}
		}
	}

	private void dfs(Vertex vertex) {
		
		System.out.println("DFS on vertex "+vertex);
		vertex.setBeingVisited(true);
		vertex.setVisited(true);
		
		for (Vertex v : vertex.getAdjacenciesList()) {
			System.out.println("Visiting the neighbours of vertex "+vertex);
			if(v.isBeingVisited()) {
				System.out.println("There is a backward edge: so there is a cycle!!!");
				break;
			}
			
			if(!v.isVisited()) {
				System.out.println("Visiting vertex "+v+" recursivelly...");
				//v.setVisited(true);
				dfs(v);
				System.out.println("Return recursion");
			}
		}
		
		System.out.println("Set vertex "+vertex+" beingVisited = false and visited = true");
		vertex.setBeingVisited(false);
		//vertex.setVisited(true);
		
	}
}
