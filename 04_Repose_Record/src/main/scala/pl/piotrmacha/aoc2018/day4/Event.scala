package pl.piotrmacha.aoc2018.day4

import java.time.LocalDateTime

abstract class Event(val date: LocalDateTime, val id: Int)

case class GuardBeginsShift(override val date: LocalDateTime, override val id: Int) extends Event(date, id)

case class GuardFadesAsleep(override val date: LocalDateTime, override val id: Int) extends Event(date, id)

case class GuardWakesUp(override val date: LocalDateTime, override val id: Int) extends Event(date, id)