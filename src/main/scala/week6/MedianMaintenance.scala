package week6

import scala.collection.mutable.PriorityQueue
import scala.annotation.tailrec
import common.Util


object MedianMaintenance {

  def main(args: Array[String]): Unit = {
    val in = Util.loadFileLongs("Median.txt").toList
    val result = totalOfMedians(in) % 10000
    
    println("The result is: " + result)
    		
  }

  def totalOfMedians(in: List[Long]): Long = {

    @tailrec
    def totalOfMediansIter(in: List[Long], hlow: PriorityQueue[Long], hhigh: PriorityQueue[Long], accu: Long): Long = in match {
      case Nil => accu
      case x :: xs => {
        val hlowMax = if (hlow.headOption == None) 0 else hlow.head
        if (x < hlowMax) hlow.enqueue(x) else hhigh.enqueue(x)
        while (hlow.size != hhigh.size && hlow.size != hhigh.size +1) {
          if (hhigh.size > hlow.size) {
            hlow.enqueue(hhigh.dequeue)
          } else {
            hhigh.enqueue(hlow.dequeue)
          }
        }
        val newHlowMax = if (hlow.headOption == None) 0 else hlow.head
        totalOfMediansIter(xs, hlow, hhigh, accu + newHlowMax)
      }
    }

    val hlow = PriorityQueue[Long]()(Ordering[Long])
    val hhigh = PriorityQueue[Long]()(Ordering[Long].reverse)
    totalOfMediansIter(in, hlow, hhigh, 0)
  }

}