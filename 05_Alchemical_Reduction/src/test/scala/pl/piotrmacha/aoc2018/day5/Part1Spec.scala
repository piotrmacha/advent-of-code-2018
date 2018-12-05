package pl.piotrmacha.aoc2018.day5

import org.scalatest.{FlatSpec, Matchers}

class Part1Spec extends FlatSpec with Matchers {
  "Part 1" should "return 10 for test polymer" in {
    def polymer = PolymerFixture.polymer

    Part1.run(polymer) shouldBe 10
  }
}
