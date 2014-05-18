package common

import scala.io.Source

object Util {
  
    def loadFile(filename: String): Array[Int] = {
    val stringArray = Source.fromInputStream(getClass.getResourceAsStream("/" + filename)).getLines.toArray
    stringArray.map(_.toInt)
  }

}