package pl.piotrmacha.aoc2018.day4

import org.scalatest.{FlatSpec, Matchers}

class Part2Spec extends FlatSpec with Matchers {
  "Part 2" should "return 4455 for example events" in {
    val events = EventsFixture.events

    Part2.run(events) shouldBe 4455
  }
}
