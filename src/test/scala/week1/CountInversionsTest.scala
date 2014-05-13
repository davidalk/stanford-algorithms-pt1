package week1

import org.scalatest._

class CountInversionsTest extends FlatSpec {

  "The source file" should "be loaded and returned as an array" in {
    val expected = Array(12, 18, 55, 220, 1250)
    val result = CountInversions.loadFile("test_file.txt")
    assert(expected.deep == result.deep)
  }

  "The mergeAndCout function" should "combine two sorted arrays and return an ordered array" in {
    val a = Array(3, 8, 10, 50, 100)
    val b = Array(2, 15, 50, 88, 92, 200, 350)
    val expected = Array(2, 3, 8, 10, 15, 50, 50, 88, 92, 100, 200, 350)
    val (result, inversions) = CountInversions.mergeAndCount(a, b)
    assert(expected.deep == result.deep)
  }

  it should "return the correct number of inversions" in {
    val a = Array(3, 8, 10, 50, 100)
    val b = Array(2, 15, 50, 88, 92, 200, 350)
    val expected = 10
    val (array, result) = CountInversions.mergeAndCount(a, b)
    assert(expected == result)
  }

  it should "correctly merge two single element arrays" in {
    val a = Array(33)
    val b = Array(14)
    val expected = Array(14, 33)
    val (result, inversions) = CountInversions.mergeAndCount(a, b)
    assert(expected.deep == result.deep)
  }

  "The sourtAndCount function" should "return a fully sorted array" in {
    val input = Array(100, 32, 9, 17, 88, 380, 1253, 48, 39, 5)
    val expected = Array(5, 9, 17, 32, 39, 48, 88, 100, 380, 1253)
    val (result, inversions) = CountInversions.sortAndCount(input)
    assert(expected.deep == result.deep)
  }

  it should "return the correct number of inversions" in {
    val input = Array(1, 3, 5, 2, 4, 6)
    val expected = 3
    val (array, result) = CountInversions.sortAndCount(input)
    assert(expected == result)
  }
}