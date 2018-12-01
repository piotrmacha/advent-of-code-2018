package pl.piotrmacha.aoc2018.day1

import java.nio.file.{Files, Paths}

object Main extends App {
  def loadFile(filename: String): Array[Int] =
    Files.readAllLines(Paths.get(filename)).stream()
      .mapToInt(line => Integer.parseInt(line.stripPrefix("+")))
      .toArray

  if (args.length < 1) {
    throw new RuntimeException("Provide input filename as argument")
  }

  val input = loadFile(args(0))
  val resultStep1 = Part1.run(input)
  val resultStep2 = Part2.run(input)

  println(s"Step 1 = $resultStep1")
  println(s"Step 2 = $resultStep2")
}
