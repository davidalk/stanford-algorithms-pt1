package week1

import org.scalatest._

class CountInversionsTest extends FlatSpec {

  "A source file" should "be loaded and returned as an array" in {
    val expected = Array(12, 18, 55, 220, 1250)
    val result = CountInversions.loadFile("test_file.txt")
    assert(expected.deep == result.deep)
  }

}