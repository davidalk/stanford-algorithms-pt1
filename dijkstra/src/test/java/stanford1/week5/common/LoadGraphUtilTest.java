package stanford1.week5.common;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import stanford1.week5.dijkstra.Edge;
import stanford1.week5.dijkstra.Node;

@RunWith(JUnit4.class)
public class LoadGraphUtilTest {
	
	@Test
	public void loadFileMethodLoadsTestGraph() throws IOException {
		Node[] expected = new Node[6];
		
		expected[0] = null;
		
		expected[1] = new Node();
		expected[1].addEdge(new Edge(2, 30));
		expected[1].addEdge(new Edge(4, 13));
		
		expected[2] = new Node();
		expected[2].addEdge(new Edge(3, 80));
		expected[2].addEdge(new Edge(5, 43));
		expected[2].addEdge(new Edge(4, 8));
		
		expected[3] = new Node();
		expected[3].addEdge(new Edge(2, 90));
		expected[3].addEdge(new Edge(1, 23));
		
		expected[4] = new Node();
		expected[4].addEdge(new Edge(5, 3));
		expected[4].addEdge(new Edge(3, 59));
		expected[4].addEdge(new Edge(1, 17));
		
		expected[5] = new Node();
		expected[5].addEdge(new Edge(4, 450));
		expected[5].addEdge(new Edge(2, 43));
		expected[5].addEdge(new Edge(1, 150));
		
		Node[] result = LoadGraphUtil.loadFile("test_data.txt");
		
		for(int i=0; i<6; i++) {
			assertEquals(expected[i], result[i]);
		}
	}

}
