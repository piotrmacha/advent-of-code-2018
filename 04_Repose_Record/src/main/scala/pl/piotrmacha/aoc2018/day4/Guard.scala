package pl.piotrmacha.aoc2018.day4

import java.time.LocalDateTime

case class Guard(id: Int, events: Array[Event]) {

  def sleepPeriods(): Array[SleepPeriod] = sleepPeriods(NotSleeping(), events, Array())

  def sleepPeriods(state: GuardState, events: Array[Event], periods: Array[SleepPeriod]): Array[SleepPeriod] = {
    if (events.isEmpty) return periods

    val (nextState, maybePeriod: Option[SleepPeriod]) = events.head match {
      case event: GuardFadesAsleep => (Sleeping(event.date), None)
      case event: GuardWakesUp => state match {
        case state: Sleeping => (NotSleeping(), Some(SleepPeriod(this, state.from, event.date)))
        case _ => (NotSleeping(), None)
      }
      case _ => (NotSleeping(), None)
    }

    val nextPeriods = maybePeriod.map(p => periods :+ p).getOrElse(periods)

    sleepPeriods(nextState, events.tail, nextPeriods)
  }

  abstract class GuardState()

  case class Sleeping(from: LocalDateTime) extends GuardState

  case class NotSleeping() extends GuardState

}