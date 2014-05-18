package common

import org.scalatest._

class UtilTest extends FlatSpec {

    "The source file" should "be loaded and returned as an array" in {
    val expected = Array(12, 18, 55, 220, 1250)
    val result = Util.loadFile("test_file.txt")
    assert(expected.deep == result.deep)
  }
    
}