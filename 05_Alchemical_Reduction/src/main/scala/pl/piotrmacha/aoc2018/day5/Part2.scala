package pl.piotrmacha.aoc2018.day5

object Part2 {
  def run(polymer: String): Int = {
    Range('A', 'Z')
      .toArray
      .map(unit => unit.toChar)
      .map(unit => polymer.filterNot(char => char.equals(unit) || Math.abs(char - unit) == 32))
      .map(Part1.run)
      .min
  }
}
