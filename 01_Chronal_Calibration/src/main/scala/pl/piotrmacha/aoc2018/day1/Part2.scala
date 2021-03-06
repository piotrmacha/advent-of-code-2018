package pl.piotrmacha.aoc2018.day1

object Part2 {
  def find(frequency: Int, seen: Set[Int], input: Array[Int]): Int = {
    val value = frequency + input.head
    if (seen.contains(value)) value
    else find(value, seen + value, input.tail :+ input.head)
  }

  def run(input: Array[Int]): Int = find(0, Set[Int](), input)
}
