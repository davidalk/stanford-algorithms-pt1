package stanford1.week5.dijkstra;

import java.util.ArrayList;
import java.util.List;


public class Node {
	
	public static final int MAX_DISTANCE = 1000000;
	
	private int distance;
	
	private Integer previous;
	
	private List<Edge> edges;
	
	public Node() {
		edges = new ArrayList<Edge>();
		previous = null;
		distance = Node.MAX_DISTANCE;
		
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Integer getPrevious() {
		return previous;
	}

	public void setPrevious(Integer previous) {
		this.previous = previous;
	}
	
	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}
	
	public List<Edge> getEdges() {
		return edges;
	}

}
