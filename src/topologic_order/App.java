package topologic_order;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {

	public static void main(String[] args) {
		TopologicalOrdering topologicalOrdering = new TopologicalOrdering();

		List<Vertex> graph = new ArrayList<>();
		graph.add(new Vertex("Pantalon"));
		graph.add(new Vertex("Correa"));
		graph.add(new Vertex("Medias"));
		graph.add(new Vertex("Chaqueta"));
		graph.add(new Vertex("Camisa"));
		graph.add(new Vertex("Calzones"));
		graph.add(new Vertex("Zapatos"));
		
		graph.get(5).addNeighbour(graph.get(0));
		graph.get(2).addNeighbour(graph.get(0));
		graph.get(0).addNeighbour(graph.get(1));
		graph.get(0).addNeighbour(graph.get(4));
		graph.get(0).addNeighbour(graph.get(6));
		graph.get(4).addNeighbour(graph.get(1));
		graph.get(1).addNeighbour(graph.get(3));
		
		
		for (int i = 0; i < graph.size(); i++) {
			if(!graph.get(i).isVisited()) {
				topologicalOrdering.dfs(graph.get(i));
			}
		}
		
		Stack<Vertex> stack = topologicalOrdering.getStack();
		
		for (int i = 0; i < graph.size(); i++) {
			Vertex vertex = stack.pop();
			System.err.println(vertex +" -> ");
		}
	}
}
