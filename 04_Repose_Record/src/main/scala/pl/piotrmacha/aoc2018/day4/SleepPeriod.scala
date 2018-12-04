package pl.piotrmacha.aoc2018.day4

import java.time.{Duration, LocalDateTime}

case class SleepPeriod(guard: Guard, from: LocalDateTime, to: LocalDateTime) {
  def minutes(): Int = Duration.between(from, to).toMinutesPart
}
