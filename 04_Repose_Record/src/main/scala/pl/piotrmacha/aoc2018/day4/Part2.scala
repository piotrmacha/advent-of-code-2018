package pl.piotrmacha.aoc2018.day4

object Part2 {
  def run(events: Array[Event]): Int = {
    val guards = Guards.fromEvents(events)

    val result = guards
      .map(guard => {
        val minutes = guard.sleepPeriods()
            .flatMap(period => Range(period.from.getMinute, period.to.getMinute))

        if (minutes.isEmpty) (guard, (0, 0))
        else (guard, findMostCommonSleepMinuteWithOccurrences(minutes))
      })
      .maxBy(_._2._2)

    result._1.id * result._2._1
  }

  def findMostCommonSleepMinuteWithOccurrences(minutes: Array[Int], carry: Map[Int, Int] = Map()): (Int, Int) = {
    if (minutes.isEmpty) return carry.maxBy(_._2)

    val minute = minutes.head
    val times = carry.getOrElse(minute, 0) + 1

    findMostCommonSleepMinuteWithOccurrences(minutes.tail, carry + { minute -> times })
  }
}
