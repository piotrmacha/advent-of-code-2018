package pl.piotrmacha.aoc2018.day4

object Part1 {
  def run(events: Array[Event]): Int = {
    val guards = Guards.fromEvents(events)

    val maxPeriod = guards
      .flatMap(guard => guard.sleepPeriods())
      .maxBy(_.minutes())

    val mostCommonSleepMinute = maxPeriod.guard.sleepPeriods()
      .flatMap(period => Range(period.from.getMinute, period.to.getMinute))
      .foldLeft(Map[Int, Int]())((c, m) => {
        c + {
          m -> (c.getOrElse(m, 0) + 1)
        }
      })
      .maxBy(_._2)._1

    maxPeriod.guard.id * mostCommonSleepMinute
  }
}
