package week4

import scala.collection.mutable.HashMap
import common.Util
import scala.collection.mutable.Stack

object StronglyConnectedComponents {

  def main(args: Array[String]): Unit = {
    val graph = Util.loadDirectedGraph("SCC.txt")
    val result = dfs(graph)
  }

  def dfs(graph: Map[Int, List[Int]]): List[Int] = {
    val defaultGraph = graph.withDefault(_ => List())

    val visited = scala.collection.mutable.HashMap[Int, Boolean]().withDefault(_ => false)
    var order = List[Int]()

    def dfsVisit(u: Int): Unit = {
      val stack = Stack[Int]()
      stack.push(u)

      while (!stack.isEmpty) {
        val v = stack.pop
        if (!visited(v)) {
          visited(v) = true
          order = order :+ v
          defaultGraph(v) map { stack.push(_) }
        }
      }
    }

    for (vertex <- defaultGraph.keys) {
      if (!visited(vertex)) {
        println("Start visit at " + vertex)
        dfsVisit(vertex)
      }
    }

    order
  }
  

}