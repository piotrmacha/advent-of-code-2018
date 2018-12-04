package pl.piotrmacha.aoc2018.day4

object Part2 {

  case class MinuteOccurrences(minute: Int, occurrences: Int)

  case class GuardWithMinuteOccurrences(guard: Guard, minutes: MinuteOccurrences)

  def run(events: Array[Event]): Int = {
    val guards = Guards.fromEvents(events)

    val result = guards
      .map(guard => {
        val minutes = guard.sleepPeriods().flatMap(period => Range(period.from.getMinute, period.to.getMinute))

        if (minutes.isEmpty) GuardWithMinuteOccurrences(guard, MinuteOccurrences(0, 0))
        else {
          val max = minutes.foldLeft(Map[Int, Int]())((c, m) => {
            c + {
              m -> (c.getOrElse(m, 0) + 1)
            }
          }).maxBy(_._2)

          GuardWithMinuteOccurrences(guard, MinuteOccurrences(max._1, max._2))
        }
      })
      .maxBy(_.minutes.occurrences)

    result.guard.id * result.minutes.minute
  }
}
