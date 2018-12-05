package pl.piotrmacha.aoc2018.day5

import scala.annotation.tailrec

object Part1 {
  case class State(index: Int, previous: Char)

  def run(polymer: String): Int = {
    @tailrec
    def findPolymersToRemove(polymer: String, state: State, carry: Set[Int] = Set()): Set[Int] = {
      if (state.index >= polymer.length) return carry

      val current = polymer.charAt(state.index)

      val (newState, newCarry) = if (Math.abs(current - state.previous) == 32 && !carry.contains(state.index - 1)) {
        (State(state.index + 1, current), carry + (state.index - 1) + state.index)
      } else {
        (State(state.index + 1, current), carry)
      }

      findPolymersToRemove(polymer, newState, newCarry)
    }


    def reducePolymer(polymer: String): String = {
      val toDelete = findPolymersToRemove(polymer, State(0, 0))
      if (toDelete.isEmpty) return polymer

      val newPolymer = polymer.toCharArray.indices.collect {
        case i if !toDelete.contains(i) => polymer.charAt(i)
      }.mkString("")

      reducePolymer(newPolymer)
    }

    reducePolymer(polymer).length
  }
}