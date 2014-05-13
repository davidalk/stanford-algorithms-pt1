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

  def mergeAndCout(a: Array[Int], b: Array[Int]): Array[Int] = {
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

  def sortAndCount(in: Array[Int]): Array[Int] = {
    var outArray = Array[Int]()
    if (in.size == 1)
      outArray = in
    else {
      val splitIndex = (in.length / 2).floor.toInt
      val a = sortAndCount(in.slice(0, splitIndex))
      val b = sortAndCount(in.slice(splitIndex, in.length))
      outArray = mergeAndCout(a, b)
    }
    outArray
  }
}