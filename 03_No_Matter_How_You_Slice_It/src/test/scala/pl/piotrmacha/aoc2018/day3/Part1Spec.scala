package pl.piotrmacha.aoc2018.day3

import org.scalatest.{FlatSpec, Matchers}

class Part1Spec extends FlatSpec with Matchers {
  "Part 1" should "return 4 for given input" in {
    val claims = Array(
      Claim(1, Region(Point(1, 3), 4, 4)),
      Claim(2, Region(Point(3, 1), 4, 4)),
      Claim(3, Region(Point(5, 5), 2, 2))
    )

    Part1.run(claims) should be (4)
  }
}
