package week3

import scala.collection.mutable.HashMap
import scala.util.Random
import scala.math._
import common.Util

object MinimumCut {
  
  def main(args: Array[String]): Unit = {
    var minCut = Long.MaxValue
    val graph = Util.loadGraph("kargerMinCut.txt")
    val trials = round(ceil(pow(graph.size, 2) * log(graph.size)))
    
    println("Number of trials to perform: " + trials + "\n")
    
    for(i <- 0L to trials) {
      val trialCut = contractGraph(graph)
      val (_, trialCutList) = trialCut.head
      
      if(trialCutList.size < minCut) minCut = trialCutList.size
      
      if(i % 100 == 0) print(". " + minCut + " ")
    }
    
    println("Min cut is " + minCut)
  }

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
      val edges = graph(v1)
      val v2 = edges(Random.nextInt(edges.size))
      contractGraph(contractVertices(v1, v2, graph))
    }
  }
}