package breath_first_search;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public void bfs(Vertex vertex) {
		
		Queue<Vertex> queue = new LinkedList<>();
		vertex.setVisited(true);
		queue.add(vertex);
		
		while (!queue.isEmpty()) {
			
			Vertex actualVertex = queue.remove();
			System.out.println(actualVertex+"");
			
			for (Vertex v : actualVertex.getNeighbourList()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					System.out.println("adding: "+v);
					queue.add(v);
				}
			}
			
		}
	}
}
