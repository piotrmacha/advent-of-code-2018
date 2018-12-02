package pl.piotrmacha.aoc2018.day2

import org.scalatest.{FlatSpec, Matchers}

class Part1Spec extends FlatSpec with Matchers {
  "Part 1" should "return 12 for given input" in {
    val input = Array("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")

    Part1.run(input) should be (12)
  }
}
