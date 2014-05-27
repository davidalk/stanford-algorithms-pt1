package week3

import scala.collection.mutable.HashMap
import scala.util.Random

object MinimumCut {

  def contractVertices(v1: Int, v2: Int, graph: Map[Int, List[Int]]): Map[Int, List[Int]] = {
    var map = graph
    for(key <-  graph(v2)) {
      val listToUpdate = map(key)
      map = map.updated(key, listToUpdate.map(i => if(i==v2) v1 else i))
    }
    val newV1List = (map(v1) ::: graph(v2)).filter(_ != v1)
    map = map.updated(v1, newV1List)
    map - v2
  }

  def contractGraph(graph: Map[Int, List[Int]]): Map[Int, List[Int]] = {
    if (graph.size == 2) {
      graph
    }
    else {
      val keys = graph.keySet.toList
      val v1 = keys(Random.nextInt(keys.size))
      val remainingKeys = keys.filter(_ != v1)
      val v2 = remainingKeys(Random.nextInt(remainingKeys.size))
      contractGraph(contractVertices(v1, v2, graph))
    }
  }
}