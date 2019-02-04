package st_kruskal;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

	private int nodeCount = 0;
	private int setCount = 0;
	private List<Node> rootNodes; // representatives

	public DisjointSet(List<Vertex> vertexes) {
		this.rootNodes = new ArrayList<>(vertexes.size());
		makeSets(vertexes);
	}

	public int find(Node n) {
		Node currentNode = n;

		while (currentNode.getParent() != null) {
			currentNode = currentNode.getParent();
		}

		Node rootNode = currentNode;
		currentNode = n;

		while (currentNode != rootNode) {
			Node temp = currentNode.getParent();
			currentNode.setParent(rootNode);
			currentNode = temp;
		}

		return rootNode.getId();
	}

	public void union(Node node1, Node node2) {
		int index1 = this.find(node1);
		int index2 = this.find(node2);

		if (index1 == index2) {
			return;
		}

		Node root1 = this.rootNodes.get(index1);
		Node root2 = this.rootNodes.get(index2);

		if (root1.getRank() < root2.getRank()) {
			root1.setParent(root2);
		} else if (root1.getRank() > root2.getRank()) {
			root2.setParent(root1);
		} else {
			root2.setParent(root1);
			root1.setRank(root1.getRank() + 1);
		}

		this.setCount--;
	}

	private void makeSets(List<Vertex> vertexes) {
		for (Vertex v : vertexes) {
			makeSet(v);
		}
	}

	private void makeSet(Vertex v) {
		Node node = new Node(rootNodes.size(), 0, null);
		v.setNode(node);
		this.rootNodes.add(node);
		nodeCount++;
		setCount++;
	}
}
