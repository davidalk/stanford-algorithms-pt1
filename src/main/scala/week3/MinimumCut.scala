package week3

import scala.collection.mutable.HashMap

object MinimumCut {

  def contractVertices(v1: Int, v2: Int, graph: Map[Int, List[Int]]): Map[Int, List[Int]] = {
    var newList = graph(v1)
    newList = newList ::: graph(v2).filter(_ != v1)
    val returnMap = graph.filter{ case (k, v) => k!=v2  }
    returnMap.updated(v1, newList)
  }

}