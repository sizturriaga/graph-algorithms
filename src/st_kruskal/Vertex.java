package st_kruskal;

public class Vertex {

	private String name;
	private Node node; // DistJointSet

	public Vertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
