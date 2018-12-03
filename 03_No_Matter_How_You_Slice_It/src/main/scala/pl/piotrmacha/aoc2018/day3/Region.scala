package pl.piotrmacha.aoc2018.day3

case class Region(position: Point, width: Int, height: Int) {
  def points(): Array[Point] =
    for (y <- Array.range(0, height); x <- Array.range(0, width))
      yield Point(position.x + x, position.y + y)

  def overlaps(regions: Array[Region], carry: Array[Region] = Array()): Array[Region] = {
    if (regions.isEmpty) carry
    else {
      val head = regions.head

      val x1 = position.x
      val x2 = head.position.x
      val y1 = position.y
      val y2 = head.position.y
      val w1 = width
      val w2 = head.width
      val h1 = height
      val h2 = head.height

      val ow = Math.max(0, Math.min(x2 + w2, x1 + w1) - Math.max(x2, x1))
      val oh = Math.max(0, Math.min(y2 + h2, y1 + h1) - Math.max(y2, y1))

      if (ow * oh > 0) {
        overlaps(regions.tail, carry :+ Region(Point(Math.max(x2, x1), Math.max(y2, y1)), ow, oh))
      } else {
        overlaps(regions.tail, carry)
      }
    }
  }
}
