package stanford1.week5.dijkstra;

public class Edge {
	
	private final int edgeHead;
	
	private final int length;
	
	public Edge(int edgeHead, int length) {
		this.edgeHead = edgeHead;
		this.length = length;
	}

	public int getEdgeHead() {
		return edgeHead;
	}

	public int getLength() {
		return length;
	}

}
