package mf_max_flow;

public class Edge {
	
	private Vertex fromVertex;
	private Vertex targetVertex;
	private final double capacity;
	private double flow;
	
	Edge(Vertex fromVertex, Vertex targerVertex, double capacity){
		this.fromVertex = fromVertex;
		this.targetVertex = targerVertex;
		this.capacity = capacity;
		this.flow = 0.0;
	}
	
	Edge(Edge edge){
		this.fromVertex = edge.getFromVertex();
		this.targetVertex = edge.targetVertex;
		this.capacity = edge.getCapacity();
		this.flow = edge.getFlow();
	}

	public Vertex getFromVertex() {
		return fromVertex;
	}

	public void setFromVertex(Vertex fromVertex) {
		this.fromVertex = fromVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}

	public double getCapacity() {
		return capacity;
	}
	
	public Vertex getOther(Vertex vertex) {
		if(vertex == this.fromVertex) {
			return this.targetVertex;
		}else{
			return this.fromVertex;
		}
	}
	
	public double getResidualCapacity(Vertex vertex) {
		if(vertex == this.fromVertex) {
			return this.flow;
		}else {
			return this.capacity - this.flow;
		}
	}
	
	public void addResidualFlowTo(Vertex vertex, double deltaFlow) {
		if(vertex == this.fromVertex) {
			flow = flow - deltaFlow;
		}else {
			flow = flow + deltaFlow;
		}
	}
	
	@Override
	public String toString() {
		return this.fromVertex+"-"+this.targetVertex+"-"+this.flow+"-"+this.capacity;
	}
	
	
	
}
