package st_prim_eager;

public class App {

	public static void main(String[] args) {
		
		Graph graph = new Graph();

		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		
		graph.addVertex(vertex0);
		graph.addVertex(vertex1);
		graph.addVertex(vertex2);

		graph.addEdge(new Edge(vertex0, vertex1, 1));
		graph.addEdge(new Edge(vertex0, vertex2, 8));
		graph.addEdge(new Edge(vertex1, vertex2, 10));

		PrimEagerAlgorithm primAlgorithm = new PrimEagerAlgorithm(graph);
		primAlgorithm.spanningTree();
		primAlgorithm.showMTS();
	}

}
