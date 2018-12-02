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
    var twos = 0
    var threes = 0

    input.map(count).map(m => m.values).foreach(count => {
      if (count.exists(p => p == 2)) twos = twos + 1
      if (count.exists(p => p == 3)) threes = threes + 1
    })

    twos * threes
  }
}
