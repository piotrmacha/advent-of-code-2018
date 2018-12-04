package pl.piotrmacha.aoc2018.day4

object Part1 {
  def run(events: Array[Event]): Int = {
    val guards = Guards.fromEvents(events)

    val guard = guards
      .flatMap(guard => guard.sleepPeriods())
      .maxBy(_.minutes())
      .guard

    val sleepMinutes = guard.sleepPeriods()
      .flatMap(period => Range(period.from.getMinute, period.to.getMinute))

    val mostCommonSleepMinute = findMostCommonSleepMinute(sleepMinutes)

    guard.id * mostCommonSleepMinute
  }

  def findMostCommonSleepMinute(minutes: Array[Int], carry: Map[Int, Int] = Map()): Int = {
    if (minutes.isEmpty) return carry.maxBy(_._2)._1

    val minute = minutes.head
    val times = carry.getOrElse(minute, 0) + 1

    findMostCommonSleepMinute(minutes.tail, carry + { minute -> times })
  }
}
