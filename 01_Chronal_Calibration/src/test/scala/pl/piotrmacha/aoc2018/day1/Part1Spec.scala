package pl.piotrmacha.aoc2018.day1

import org.scalatest.{FlatSpec, Matchers}

class Part1Spec extends FlatSpec with Matchers {
  "Step 1" should "return correct frequency" in {
    val changes = Array(1, -2, 3, 1)
    Part1.run(changes) should be (3)
  }
}
