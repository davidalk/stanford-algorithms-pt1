package week4

import scala.collection.mutable.HashMap

object StronglyConnectedComponents {

  def dfs(graph: Map[Int, List[Int]]): List[Int] = {
    val defaultGraph = graph.withDefault(_ => List())

    val visited = scala.collection.mutable.HashMap[Int, Boolean]().withDefault(_ => false)
    var order = List[Int]()
    
    def dfsVisit(u: Int): Unit = {
      for(v <- defaultGraph(u)) {
        if(!visited(v)) {
           dfsVisit(v)
        }
      }
      order = u :: order
      visited(u) = true
    }
        
    for(vertex <- defaultGraph.keys) {
      if(!visited(vertex)) {
        dfsVisit(vertex)
      }
    }
    
    order
  }

}