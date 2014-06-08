package week4

import scala.collection.mutable.HashMap
import common.Util
import scala.collection.mutable.Stack

object StronglyConnectedComponents {

  def main(args: Array[String]): Unit = {
    val graph = Util.loadDirectedGraph("SCC.txt")

    val order = dfs(graph)
    println(order)
    val invertedGraph = Util.loadInvertedDirectedGraph("SCC.txt")
    val scc = dfsSccCount(invertedGraph, order)
    println(scc.sorted.reverse)

  }

  def dfsSccCount(graph: Map[Int, List[Int]], order: List[Int]): List[Int] = {
    println("starting scc count")

    val defaultGraph = graph.withDefault(_ => List())

    val visited = scala.collection.mutable.HashMap[Int, Boolean]().withDefault(_ => false)

    var sccList = List[Int]()

    def dfsVisit(u: Int): Int = {
      val stack = Stack[Int]()
      stack.push(u)
      var count = 0

      while (!stack.isEmpty) {
        val v = stack.pop
        if (!visited(v)) {
          count = count + 1
          visited(v) = true
          defaultGraph(v) map { stack.push(_) }
        }
      }
      count
    }

    for (vertex <- order) {
      if (!visited(vertex)) {
        println("Start visit at " + vertex)
        sccList = dfsVisit(vertex) :: sccList
      }
    }

    sccList
  }

  def dfs(graph: Map[Int, List[Int]]): List[Int] = {
    var order = List[Int]()
    val defaultGraph = graph.withDefault(_ => List())
    val visited = scala.collection.mutable.HashMap[Int, Boolean]().withDefault(_ => false)

    def dfsVisit(u: Int): Unit = {
      val stack = Stack[Int]()
      stack.push(u)

      while (!stack.isEmpty) {
        val v = stack.pop
        if (!visited(v)) {
          visited(v) = true
          order = v :: order
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