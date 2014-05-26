package week3

import org.scalatest._
import scala.collection.immutable.HashMap
import common._

class MinimumCutTest extends FlatSpec {

  "The contract function" should "merge vertices correctly without self loops" in {
    val expected = HashMap[Int, List[Int]](
      1 -> List(2, 3, 4, 2, 3),
      2 -> List(1, 4),
      3 -> List(1, 4))

    val graph = Util.loadGraph("test_graph_data.txt")

    val result = MinimumCut.contractVertices(1, 4, graph)

    expected.foreach {
      case (k, v) =>
        assert(v == result(k))
    }
  }

}