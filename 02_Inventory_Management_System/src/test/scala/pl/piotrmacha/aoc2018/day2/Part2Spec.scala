package pl.piotrmacha.aoc2018.day2

import org.scalatest.{FlatSpec, Matchers}

class Part2Spec extends FlatSpec with Matchers {
  "Part 2" should "return 'fgij' for given input" in {
    val input = Array("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "vwxyz")

    Part2.run(input) should be ("fgij")
  }
}
