package week6

import org.scalatest._

class TwoSumProblemTest extends FlatSpec {

  "The twoSum function" should "return true when its array contains two elements that sum to the target" in {
    val list = List(5L, 8L, 19L, 88L, 40L, 30L)
    
    val lookup = list.toSet
    
    val returned = TwoSumProblem.twoSum(list, lookup, 49)
    
    assert(true == returned)
  }
  
  "The twoSum function" should "return false when no sum is found" in {
    val list = List(5L, 8L, 19L, 88L, 40L, 30L)
    
    val lookup = list.toSet
    
    val returned = TwoSumProblem.twoSum(list, lookup, 500)
    
    assert(false == returned)
  }

}