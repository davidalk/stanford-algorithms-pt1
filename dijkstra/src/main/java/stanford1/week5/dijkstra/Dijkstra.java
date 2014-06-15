package stanford1.week5.dijkstra;

import java.io.IOException;
import java.util.PriorityQueue;

import stanford1.week5.common.LoadGraphUtil;

public class Dijkstra {

	private Node[] graph;
	private PriorityQueue<Node> priorityQueue;

	public static void main(String... args) {
		Dijkstra dijkstra = null;
		try {
			dijkstra = new Dijkstra("dijkstraData.txt");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		dijkstra.execute();
		Node[] graph = dijkstra.getGraph();
		System.out.println("Output from Dijkstra algorithm: ");
		System.out.println(graph[7].getDistance() + "," +
				graph[37].getDistance() + "," +
				graph[59].getDistance() + "," +
				graph[82].getDistance() + "," +
				graph[99].getDistance() + "," +
				graph[115].getDistance() + "," +
				graph[133].getDistance() + "," +
				graph[165].getDistance() + "," +
				graph[188].getDistance() + "," +
				graph[197].getDistance() );
	}

	public Dijkstra(String filename) throws IOException {
		graph = LoadGraphUtil.loadFile(filename);
		graph[1].setDistance(0);
		priorityQueue = new PriorityQueue<Node>((node1, node2) -> node1.getDistance() - node2.getDistance());
		for(int i=1; i<graph.length; i++) {
			priorityQueue.add(graph[i]);
		}
	}
	
	public void execute() {
		while(!priorityQueue.isEmpty()) {
			Node u = priorityQueue.poll();
			for(Edge vEdges: u.getEdges()) {
				Node vNode = graph[vEdges.getEdgeHead()];
				int alternative = u.getDistance() + vEdges.getLength();
				if(alternative < vNode.getDistance()) {
					vNode.setDistance(alternative);
					vNode.setPrevious(u.getNodeId());
					priorityQueue.remove(vNode);
					priorityQueue.add(vNode);
				}
			}
		}
	}
	
	public Node[] getGraph() {
		return graph;
	}
}
