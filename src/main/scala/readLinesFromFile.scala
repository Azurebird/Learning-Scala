import java.io.FileNotFoundException
import java.util.Optional
import java.util.function.Supplier

import scala.io.Source

/**
  * Reads the lines from a file and prints the content file with each line length at its side
  * An easy example would be to execute this file with itself, like: scala readLinesFromFile.scala readLinesFromFile.scala
  */
object readLinesFromFile {
  def main(args: Array[String]): Unit = {
    val lines = Optional.of(Source.fromFile(args(0)))
      .orElseThrow(supplyFileNotFoundException())
      .getLines()

    lines.foreach(line => {
      val separator = if (line.length < 10) "  | " else " | "
      println(s"${line.length}$separator$line")
    })
  }

  def supplyFileNotFoundException() : Supplier[FileNotFoundException] =
    () => new FileNotFoundException("File not found")
}
