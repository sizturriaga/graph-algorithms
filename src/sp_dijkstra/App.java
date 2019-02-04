package sp_dijkstra;

public class App {

	public static void main(String[] args) {
		
		/*
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		Vertex vertexF = new Vertex("F");
		Vertex vertexG = new Vertex("G");
		Vertex vertexH = new Vertex("H");
		
		vertexA.addNeigbour(new Edge(5, vertexA, vertexB));
		vertexA.addNeigbour(new Edge(8, vertexA, vertexH));
		vertexA.addNeigbour(new Edge(9, vertexA, vertexE));
		
		vertexB.addNeigbour(new Edge(15, vertexB, vertexD));
		vertexB.addNeigbour(new Edge(12, vertexB, vertexC));
		vertexB.addNeigbour(new Edge(4, vertexB, vertexH));
		
		vertexH.addNeigbour(new Edge(7, vertexH, vertexC));
		vertexH.addNeigbour(new Edge(6, vertexH, vertexF));
		
		vertexE.addNeigbour(new Edge(5, vertexE, vertexH));
		vertexE.addNeigbour(new Edge(4, vertexE, vertexF));
		vertexE.addNeigbour(new Edge(20, vertexE, vertexG));
		
		vertexC.addNeigbour(new Edge(3, vertexC, vertexD));
		vertexC.addNeigbour(new Edge(11, vertexC, vertexG));
		
		vertexF.addNeigbour(new Edge(1, vertexF, vertexC));
		vertexF.addNeigbour(new Edge(13, vertexF, vertexG));
		
		vertexD.addNeigbour(new Edge(9, vertexF, vertexG));
		*/
		
		
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");

		vertexA.addNeigbour(new Edge(5, vertexA, vertexB));
		vertexA.addNeigbour(new Edge(10, vertexA, vertexC));
		vertexB.addNeigbour(new Edge(1, vertexB, vertexC));
		vertexC.addNeigbour(new Edge(3, vertexC, vertexA));
		
		DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
		algorithm.computePath(vertexA);
		
		System.out.println(algorithm.getShortestPath(vertexC));
	}
	
	

}
