package pl.piotrmacha.aoc2018.day4

import java.time.LocalDateTime

object EventsFixture {
  def events: Array[Event] = Array(
    GuardBeginsShift(LocalDateTime.of(1518, 11, 1, 0, 0), 10),
    GuardFadesAsleep(LocalDateTime.of(1518, 11, 1, 0, 5), 10),
    GuardWakesUp(LocalDateTime.of(1518, 11, 1, 0, 25), 10),
    GuardFadesAsleep(LocalDateTime.of(1518, 11, 1, 0, 30), 10),
    GuardWakesUp(LocalDateTime.of(1518, 11, 1, 0, 55), 10),

    GuardBeginsShift(LocalDateTime.of(1518, 11, 1, 23, 58), 99),
    GuardFadesAsleep(LocalDateTime.of(1518, 11, 2, 0, 40), 99),
    GuardWakesUp(LocalDateTime.of(1518, 11, 2, 0, 50), 99),

    GuardBeginsShift(LocalDateTime.of(1518, 11, 3, 0, 5), 10),
    GuardFadesAsleep(LocalDateTime.of(1518, 11, 3, 0, 24), 10),
    GuardWakesUp(LocalDateTime.of(1518, 11, 3, 0, 29), 10),

    GuardBeginsShift(LocalDateTime.of(1518, 11, 4, 0, 2), 99),
    GuardFadesAsleep(LocalDateTime.of(1518, 11, 4, 0, 36), 99),
    GuardWakesUp(LocalDateTime.of(1518, 11, 4, 0, 46), 99),

    GuardBeginsShift(LocalDateTime.of(1518, 11, 5, 0, 3), 99),
    GuardFadesAsleep(LocalDateTime.of(1518, 11, 5, 0, 45), 99),
    GuardWakesUp(LocalDateTime.of(1518, 11, 5, 0, 55), 99),
  )
}
