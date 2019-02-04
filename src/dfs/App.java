package dfs;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		Vertex vertex1 = new Vertex("1");
		Vertex vertex2 = new Vertex("2");
		Vertex vertex3 = new Vertex("3");
		Vertex vertex4 = new Vertex("4");
		Vertex vertex5 = new Vertex("5");
		
		vertex1.addNeighbour(vertex2);
		vertex1.addNeighbour(vertex3);
		vertex3.addNeighbour(vertex4);
		vertex4.addNeighbour(vertex5);		
		
		List<Vertex> list = new ArrayList<>();
		list.add(vertex1);
		list.add(vertex2);
		list.add(vertex3);
		list.add(vertex4);
		list.add(vertex5);
		
		
		DFS dfs = new DFS();
		dfs.dfs(list);
	}

}
