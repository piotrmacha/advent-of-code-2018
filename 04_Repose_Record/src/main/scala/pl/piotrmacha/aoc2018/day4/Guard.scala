package pl.piotrmacha.aoc2018.day4

import java.time.LocalDateTime

case class Guard(id: Int, events: Array[Event]) {

  def sleepPeriods(): Array[SleepPeriod] = sleepPeriods(NotSleeping(), events, Array())

  def sleepPeriods(state: GuardState, events: Array[Event], periods: Array[SleepPeriod]): Array[SleepPeriod] = {
    if (events.isEmpty) return periods

    events.head match {
      case e: GuardFadesAsleep => sleepPeriods(Sleeping(e.date), events.tail, periods)
      case e: GuardWakesUp => state match {
        case s: Sleeping => sleepPeriods(NotSleeping(), events.tail, periods :+ SleepPeriod(this, s.from, e.date))
        case _ => sleepPeriods(NotSleeping(), events.tail, periods)
      }
      case _ => sleepPeriods(state, events.tail, periods)
    }
  }

  abstract class GuardState()
  case class Sleeping(from: LocalDateTime) extends GuardState
  case class NotSleeping() extends GuardState
}