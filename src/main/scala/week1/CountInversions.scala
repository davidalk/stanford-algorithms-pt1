package week1

import scala.io.Source

object CountInversions {

  def main(args: Array[String]) {
    println("Hello World!")
  }

  def loadFile(filename: String): Array[Int] = {
    val stringArray = Source.fromInputStream(getClass.getResourceAsStream("/" + filename)).getLines.toArray
    stringArray.map(_.toInt)
  }

  def merge(a: Array[Int], b: Array[Int]): Array[Int] = {
    val outputSize = a.length + b.length
    val returnArray = Array.fill(outputSize)(0)
    var aIndex, bIndex = 0
    val aWithMarker = a :+ Int.MaxValue
    val bWithMarker = b :+ Int.MaxValue
    for (i <- 0 until outputSize) {
      if (aWithMarker(aIndex) <= bWithMarker(bIndex)) {
        returnArray(i) = aWithMarker(aIndex)
        aIndex += 1
      } else {
        returnArray(i) = bWithMarker(bIndex)
        bIndex += 1
      }
    }
    returnArray
  }
}