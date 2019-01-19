package depth_first_search;

import java.util.List;
import java.util.Stack;

public class DFS {
	
	Stack<Vertex> stack;
	
	public DFS() {
		this.stack = new Stack<>();
	}
	
	public void dfs(List<Vertex> vertexList) {
		for (Vertex vertex : vertexList) {
			if(!vertex.isVisited()) {
				//dfsWithStack(vertex);
				dfsRecursive(vertex);
			}
			
		}
	}

	private void dfsWithStack(Vertex rootVertex) {
		this.stack.add(rootVertex);
		//rootVertex.setVisited(true);
		
		while (!stack.isEmpty()) {
			Vertex currentVertex = this.stack.pop();
			currentVertex.setVisited(true);
			System.out.println(currentVertex + " ");
			
			for (Vertex vertex : currentVertex.getNeighbourList()) {
				if(!vertex.isVisited()) {
					//vertex.setVisited(true);
					this.stack.push(vertex);
				}
			}
			
		}
	}

	private void dfsRecursive(Vertex rootVertex) {
		
		System.out.println("v: "+rootVertex);
		
		for (Vertex vertex : rootVertex.getNeighbourList()) {
			if(!vertex.isVisited()) {
				vertex.setVisited(true);
				dfsRecursive(vertex);
			}
			
		}
	}
}
