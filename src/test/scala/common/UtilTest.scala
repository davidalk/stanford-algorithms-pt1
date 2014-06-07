package common

import scala.collection.immutable.HashMap
import org.scalatest._

class UtilTest extends FlatSpec {

  "The source file" should "be loaded and returned as an array" in {
    val expected = Array(12, 18, 55, 220, 1250)
    val result = Util.loadFile("test_file.txt")
    assert(expected.deep == result.deep)
  }

  "The graph file" should "be loaded as a map of lists" in {
    val expected = HashMap[Int, List[Int]](
      1 -> List(2, 3, 4),
      2 -> List(1, 4),
      3 -> List(1, 4),
      4 -> List(1, 2, 3))

    val result = Util.loadGraph("test_graph_data.txt")

    expected.foreach {
      case (k, v) =>
        assert(v == result(k))
    }
  }

  "The directed graph file" should "be loaded as a map of lists" in {
    val expected = HashMap[Int, List[Int]](
        1 -> List(2, 3, 4),
        3 -> List(4),
        4 -> List(2))
        
    val result = Util.loadDirectedGraph("test_directed_graph.txt")
    
    expected.foreach {
      case (k, v) =>
        assert(v == result(k).sorted)
    }
  }
}