package pl.piotrmacha.aoc2018.day1

import org.scalatest.{FlatSpec, Matchers}

class Part2Spec extends FlatSpec with Matchers {
  "Part 2" should "return repeated frequency" in {
    val changes = Array(1, -2, 3, 1)
    Part2.run(changes) should be (2)
  }
}
