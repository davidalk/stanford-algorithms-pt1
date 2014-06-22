package common

import scala.io.Source
import scala.collection.mutable.HashMap

object Util {

  def loadFile(filename: String): Array[Int] = {
    val stringArray = Source.fromInputStream(getClass.getResourceAsStream("/" + filename)).getLines.toArray
    stringArray.map(_.toInt)
  }

  def loadFileLongs(filename: String): Array[Long] = {
    val stringArray = Source.fromInputStream(getClass.getResourceAsStream("/" + filename)).getLines.toArray
    stringArray.map(_.toLong)
  }

  def loadGraph(filename: String): Map[Int, List[Int]] = {
    val rows = Source.fromInputStream(getClass.getResourceAsStream("/" + filename)).getLines
    val returnMap = HashMap[Int, List[Int]]()
    rows.foreach(s => {
      val rowList = s.split("\t").toList.map(_.toInt)
      returnMap.put(rowList.head, rowList.tail)
    })

    returnMap.toMap
  }

  def loadDirectedGraph(filename: String): Map[Int, List[Int]] = {
    val rows = Source.fromInputStream(getClass.getResourceAsStream("/" + filename)).getLines
    val returnMap = HashMap[Int, List[Int]]()
    rows foreach { r =>
      val rowList = r.split(" ").toList.map(_.toInt)
      val tailVertex = rowList(0)
      val headVertex = rowList(1)
      val edges = returnMap.getOrElse(tailVertex, Nil)
      returnMap.put(tailVertex, headVertex :: edges)
    }
    returnMap.toMap
  }

  def loadInvertedDirectedGraph(filename: String): Map[Int, List[Int]] = {
    val rows = Source.fromInputStream(getClass.getResourceAsStream("/" + filename)).getLines
    val returnMap = HashMap[Int, List[Int]]()
    rows foreach { r =>
      val rowList = r.split(" ").toList.map(_.toInt)
      val tailVertex = rowList(1)
      val headVertex = rowList(0)
      val edges = returnMap.getOrElse(tailVertex, Nil)
      returnMap.put(tailVertex, headVertex :: edges)
    }
    returnMap.toMap

  }
}