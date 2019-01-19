package dfs_cycle_detection;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		Vertex vertex1 = new Vertex("A");
		Vertex vertex2 = new Vertex("B");
		Vertex vertex3 = new Vertex("C");
		
		vertex1.addNeighbour(vertex2);
		vertex2.addNeighbour(vertex3);
		vertex3.addNeighbour(vertex1);
		
		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		vertexList.add(vertex3);
		
		CycleDetection cycleDetection = new CycleDetection();
		cycleDetection.detectCycle(vertexList);
	}

}
