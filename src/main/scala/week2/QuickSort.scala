package week2

import common.Util
import scala.util.Random

object QuickSort {

  var comparisonCount = 0L

  def main(args: Array[String]): Unit = {
    println("QuickSort: ")
    val data = Util.loadFile("QuickSort.txt")
    sort(data, 0, data.length - 1)
    for (i <- 1 until data.length) {
      println(data(i))
    }
    println("ComparisonCount: " + comparisonCount)
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
    pivotBoundary - 1
  }

  def sort(a: Array[Int], left: Int, right: Int): Unit = {
    if (left < right) {
      comparisonCount += right - left
      //****** random
      //val partitionIndex = left + Random.nextInt(right - left)

      //****** left
      //val partitionIndex = left
      //****** right
      //val partitionIndex = right

      //******** median
      val middle = {
        if ((right - left + 1) % 2 == 0)
          (right - left + 1) / 2 + left - 1
        else
          left + (right - left) / 2
      }

      val partitionIndex = {
        if (a(middle) <= a(left) && a(left) <= a(right) || a(right) <= a(left) && a(left) <= a(middle))
          left
        else if (a(left) <= a(middle) && a(middle) <= a(right) || a(right) <= a(middle) && a(middle) <= a(left))
          middle
        else if (a(left) <= a(right) && a(right) <= a(middle) || a(middle) <= a(right) && a(right) <= a(left))
          right
        else {
          println(left, right, middle)
          println(a(left), a(right), a(middle))
          throw new IllegalArgumentException
        }
      }
      //********* median

      val newPivotIndex = partition(a, left, right, partitionIndex)
      sort(a, left, newPivotIndex - 1)
      sort(a, newPivotIndex + 1, right)

    }
  }

}