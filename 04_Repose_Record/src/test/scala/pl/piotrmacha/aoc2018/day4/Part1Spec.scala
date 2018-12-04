package pl.piotrmacha.aoc2018.day4

import org.scalatest.{FlatSpec, Matchers}

class Part1Spec extends FlatSpec with Matchers {
  "Part 1" should "return 240 for example events" in {
    val events = EventsFixture.events

    Part1.run(events) shouldBe 240
  }
}
