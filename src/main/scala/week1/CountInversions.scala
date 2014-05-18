package week1

import scala.io.Source
import common.Util

object CountInversions {

  def main(args: Array[String]) = {
    println("Sorted array from file:")
    val input = Util.loadFile("IntegerArray.txt")
    val (array, inversions) = sortAndCount(input)
    println("Total inversions: " + inversions)
  }

  def mergeAndCount(a: Array[Int], b: Array[Int]): (Array[Int], Long) = {
    val outputSize = a.length + b.length
    var (returnArray, inversions) = (Array.fill(outputSize)(0), 0)
    var aIndex, bIndex = 0
    val aWithMarker = a :+ Int.MaxValue
    val bWithMarker = b :+ Int.MaxValue
    for (i <- 0 until outputSize) {
      if (aWithMarker(aIndex) <= bWithMarker(bIndex)) {
        returnArray(i) = aWithMarker(aIndex)
        aIndex += 1
      } else {
        inversions += a.length - aIndex
        returnArray(i) = bWithMarker(bIndex)
        bIndex += 1
      }
    }
    (returnArray, inversions)
  }

  def sortAndCount(in: Array[Int]): (Array[Int], Long) = {
    var outArray = Array[Int]()
    var inversions = 0L
    if (in.size <= 1) {
      outArray = in
    }
    else {
      val splitIndex = (in.length / 2).floor.toInt
      val (a, inversionsA) = sortAndCount(in.slice(0, splitIndex))
      val (b, inversionsB) = sortAndCount(in.slice(splitIndex, in.length))
      val (mergeArray, inversionsMerge) = mergeAndCount(a, b)
      outArray = mergeArray
      inversions = inversionsA + inversionsB + inversionsMerge
    }
    (outArray, inversions)
  }
}