package pl.piotrmacha.aoc2018.day4

import java.nio.file.{Files, Paths}
import java.time.{LocalDateTime, ZoneOffset}

import scala.util.matching.Regex

object Main extends App {
  def loadFile(filename: String): Array[Event] = {
    val regex: Regex = "\\[([0-9]+)\\-([0-9]+)\\-([0-9]+) ([0-9]+):([0-9]+)\\] (wakes|falls|Guard) #?([0-9]+|)".r
    val lines = Files.readAllLines(Paths.get(filename))

    var id = 0

    lines
      .toArray(Array.ofDim[String](lines.size))
      .map(line => {
        val m = regex.findFirstMatchIn(line).get

        val date = LocalDateTime.of(
          m.group(1).toInt,
          m.group(2).toInt,
          m.group(3).toInt,
          m.group(4).toInt,
          m.group(5).toInt
        )

        (date, m)
      })
      .sortBy(_._1.toEpochSecond(ZoneOffset.UTC))
      .map(tuple => {
        val date = tuple._1
        val m = tuple._2

        m.group(6) match {
          case "Guard" => {
            id = m.group(7).toInt
            GuardBeginsShift(date, id)
          }
          case "falls" => GuardFadesAsleep(date, id)
          case "wakes" => GuardWakesUp(date, id)
          case _ => throw new RuntimeException("Invalid input")
        }
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
