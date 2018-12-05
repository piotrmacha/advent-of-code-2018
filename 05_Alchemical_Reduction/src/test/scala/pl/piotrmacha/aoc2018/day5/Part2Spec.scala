package pl.piotrmacha.aoc2018.day5

import org.scalatest.{FlatSpec, Matchers}

class Part2Spec extends FlatSpec with Matchers {
  "Part 2" should "return 4 for test polymer" in {
    def polymer = PolymerFixture.polymer

    Part2.run(polymer) shouldBe 4
  }
}
