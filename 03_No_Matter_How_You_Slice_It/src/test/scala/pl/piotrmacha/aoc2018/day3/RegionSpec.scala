package pl.piotrmacha.aoc2018.day3

import org.scalatest.{FlatSpec, Matchers}

class RegionSpec extends FlatSpec with Matchers {
  "Region.points()" should "return array of occupied points" in {
    val claim = Region(Point(4, 4), 4, 4)

    claim.points() shouldEqual Array(
      Point(4, 4), Point(5, 4), Point(6, 4), Point(7, 4),
      Point(4, 5), Point(5, 5), Point(6, 5), Point(7, 5),
      Point(4, 6), Point(5, 6), Point(6, 6), Point(7, 6),
      Point(4, 7), Point(5, 7), Point(6, 7), Point(7, 7),
    )
  }

  "Region.overlaps()" should "return array of overlaps" in {
    val region1 = Region(Point(1, 2), 2, 2)
    val region2 = Region(Point(2, 1), 2, 3)
    val region3 = Region(Point(0, 3), 2, 5)

    val overlaps = region1.overlaps(Array(region2, region3))
    overlaps shouldEqual  Array(
      Region(Point(2, 2), 1, 2),
      Region(Point(1, 3), 1, 1),
    )
  }
}
