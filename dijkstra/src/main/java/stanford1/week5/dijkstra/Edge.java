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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edgeHead;
		result = prime * result + length;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (edgeHead != other.edgeHead)
			return false;
		if (length != other.length)
			return false;
		return true;
	}

}
