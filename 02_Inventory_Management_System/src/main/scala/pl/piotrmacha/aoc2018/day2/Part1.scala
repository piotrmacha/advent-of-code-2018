package pl.piotrmacha.aoc2018.day2

object Part1 {
  def count(input: String): Map[Char, Int] = {
    def step(string: String, map: Map[Char, Int]): Map[Char, Int] = {
      if (string.isEmpty) map
      else {
        val character = string(0)
        val times = map.getOrElse(character, 0) + 1
        step(string.substring(1), map + (character -> times))
      }
    }

    step(input, Map[Char, Int]())
  }

  def run(input: Array[String]): Int = {
    val map = input.map(count).map(m => m.values)
    map.count(s => s.exists(c => c == 2)) * map.count(s => s.exists(c => c == 3))
  }
}
