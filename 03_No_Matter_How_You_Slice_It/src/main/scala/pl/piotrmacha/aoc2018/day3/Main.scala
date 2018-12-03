package pl.piotrmacha.aoc2018.day3

import java.nio.file.{Files, Paths}

import scala.util.matching.Regex


object Main extends App {
  def loadFile(filename: String): Array[Claim] = {
    val regex: Regex = "#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)".r
    val lines = Files.readAllLines(Paths.get(filename))

    lines.toArray(Array.ofDim[String](lines.size)).map(line => {
      val m = regex.findFirstMatchIn(line).get

      Claim(
        m.group(1).toInt,
        Region(Point(m.group(2).toInt, m.group(3).toInt), m.group(4).toInt, m.group(5).toInt)
      )
    })
  }

  if (args.length < 1) {
    throw new RuntimeException("Provide input filename as argument")
  }

  val input = loadFile(args(0))
  val resultStep1 = Part1.run(input)
  val resultStep2 = Part2.run(input)

  println(s"Step 1 = $resultStep1")
  println(s"Step 2 = $resultStep2")
}
