package week2

import common.Util
import scala.util.Random

object QuickSort {

  def main(args: Array[String]): Unit = {
    println("QuickSort: ")
    val data = Util.loadFile("QuickSort.txt")
    sort(data, 0, data.length - 1)
    for(i <- 1 until data.length) {
      println(data(i))
    }
  }

  def partition(a: Array[Int], left: Int, right: Int, pivotIndex: Int): Int = {
    val pivotVal = a(pivotIndex)
    a(pivotIndex) = a(left)
    a(left) = pivotVal
    var pivotBoundary = left + 1
    for (j <- left + 1 to right) {
      if (a(j) < pivotVal) {
        val temp = a(j)
        a(j) = a(pivotBoundary)
        a(pivotBoundary) = temp
        pivotBoundary += 1
      }
    }
    val temp = a(left)
    a(left) = a(pivotBoundary - 1)
    a(pivotBoundary - 1) = temp
    pivotBoundary -1 
  }

  def sort(a: Array[Int], left: Int, right: Int): Unit = {
    if (left < right) {
      val partitionIndex = left + Random.nextInt(right - left)
      val newPivotIndex = partition(a, left, right, partitionIndex)
      sort(a, left, newPivotIndex-1)
      sort(a, newPivotIndex+1, right)
    }
  }

}