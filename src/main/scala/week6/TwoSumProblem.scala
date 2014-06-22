package week6

import scala.annotation.tailrec
import common.Util

object TwoSumProblem {

  val MIN_TARGET = -10000
  val MAX_TARGET = 10000
  
  def main(args: Array[String]): Unit = {
    val inputList = Util.loadFileLongs("algo1-programming_prob-2sum.txt").toList
    val inputSet = inputList.toSet
    
    var count = 0
    
    for(i <- MIN_TARGET to MAX_TARGET) {
      println(i)
      if(twoSum(inputList, inputSet, i)) count = count + 1
    }
    
    println("Total number of two sum in range: " + count)
  }
  
  @tailrec
  def twoSum(list: List[Long], lookup: Set[Long], target: Int): Boolean = list match {
    case Nil => false
    case x :: xs => if(lookup.contains(target - x)) true else twoSum(xs, lookup, target)
  }
  
}