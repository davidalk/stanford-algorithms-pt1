package common

import scala.io.Source
import scala.collection.mutable.HashMap

object Util {

  def loadFile(filename: String): Array[Int] = {
    val stringArray = Source.fromInputStream(getClass.getResourceAsStream("/" + filename)).getLines.toArray
    stringArray.map(_.toInt)
  }

  def loadGraph(filename: String): Map[Int, List[Int]] = {
    val rows = Source.fromInputStream(getClass.getResourceAsStream("/" + filename)).getLines
    val returnMap = HashMap[Int, List[Int]]()
    rows.foreach(s => {
      val rowList = s.split("\t").toList
      returnMap.put(rowList.head.toInt, rowList.tail.map(_.toInt))
    })

    returnMap.toMap
  }
}