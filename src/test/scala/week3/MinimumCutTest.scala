package week3

import org.scalatest._
import scala.collection.immutable.HashMap
import common._

class MinimumCutTest extends FlatSpec {

  "The contract function" should "merge vertices correctly without self loops" in {
    val expected = HashMap[Int, List[Int]](
      1 -> List(2, 3, 2, 3),
      2 -> List(1, 1),
      3 -> List(1, 1))

    val graph = Util.loadGraph("test_graph_data.txt")

    val result = MinimumCut.contractVertices(1, 4, graph)
    
    expected.foreach {
      case (k, v) =>
        assert(v == result(k))
    }
  }

  "The contractGraph function" should "contract all edges leaving only one" in {
    val graph = Util.loadGraph("test_graph_data.txt")
    
    val result = MinimumCut.contractGraph(graph)
    
    result.foreach{case (k, v) => println("Key: " + k + " List: " + v)}
    
    assert(result.size == 2)
  }
}