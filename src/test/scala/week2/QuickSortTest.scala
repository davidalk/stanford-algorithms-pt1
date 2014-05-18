package week2

import org.scalatest._

class QuickSortTest extends FlatSpec {
  
  "The partition function" should "partiion an array accross the index" in {
    val input = Array(-9, -99, -999, 33, 23, 5, 50, 41, 14, 88, 4, 37, -9999, -99999)
    val partitionIndex = 7
    val expected = Array(37, 23, 5, 33, 14, 4, 41, 50, 88)
    val newPivotIndex = QuickSort.partition(input, 3, 11, partitionIndex)
    assert(expected.deep == input.slice(3, 12).deep)
    assert(input(newPivotIndex) == 41)
  }
}

