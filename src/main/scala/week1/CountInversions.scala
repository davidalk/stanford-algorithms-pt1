package week1

import scala.io.Source

object CountInversions {

  def main(args: Array[String]) {
    println("Hello World!")
  }

  def loadFile(filename: String): Array[Int] = {
    val stringArray = Source.fromInputStream(getClass.getResourceAsStream("/" + filename)).getLines.toArray
    stringArray.map(x => x.toInt)
  }
}