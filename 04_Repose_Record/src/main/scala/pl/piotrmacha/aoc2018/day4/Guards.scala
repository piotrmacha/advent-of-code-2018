package pl.piotrmacha.aoc2018.day4

import java.time.ZoneOffset

object Guards {
  def fromEvents(events: Array[Event]): Array[Guard] =
    events
      .sortBy(_.date.toEpochSecond(ZoneOffset.UTC))
      .groupBy(_.id)
      .map(e => Guard(e._1, e._2))
      .toArray
}
