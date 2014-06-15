package stanford1.week5.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import stanford1.week5.dijkstra.Edge;
import stanford1.week5.dijkstra.Node;

public class LoadGraphUtil {

	public static Node[] loadFile(String filename) throws IOException {
		BufferedReader in = null;
		List<String> lines = new ArrayList<String>();
		try {
			in = new BufferedReader(new InputStreamReader(LoadGraphUtil.class.getClass().getResourceAsStream("/" + filename)));
			String line = null;
			while ((line = in.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			in.close();
		}
		
		Node[] graph = new Node[lines.size() + 1];
		graph[0] = null;
		for(String line : lines) {
			String[] elements = line.split("\t");
			int nodeId = Integer.valueOf(elements[0]);
			Node newNode = new Node();
			for(int i=1; i<elements.length; i++) {
				String[] edgeDetails = elements[i].split(",");
				newNode.addEdge(new Edge(Integer.valueOf(edgeDetails[0]), Integer.valueOf(edgeDetails[1])));
			}
			graph[nodeId] = newNode;
		}
		return graph;
	}

}
