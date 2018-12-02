package pl.piotrmacha.aoc2018.day2

object Part2 {
  def diff(a: Array[Char], b: Array[Char], carry: Array[Char] = Array()): Array[Char] = {
    if (a.isEmpty && b.isEmpty) carry
    else diff(a.tail, b.tail, if (a.head != b.head) carry :+ b.head else carry)
  }

  def intersection(a: Array[Char], b: Array[Char], carry: Array[Char] = Array()): Array[Char] = {
    if (a.isEmpty && b.isEmpty) carry
    else intersection(a.tail, b.tail, if (a.head == b.head) carry :+ a.head else carry)
  }

  def run(input: Array[String]): String = {
    val ids = input.map(id => (id, input.filter(p => p != id)))
      .map(t => (t._1, t._2.map(pair => diff(pair.toCharArray, t._1.toCharArray))))
      .filter(t => t._2.exists(diff => diff.length == 1))
      .map(t => t._1)
      .map(s => s.toCharArray)

    if (ids.length != 2) {
      throw new RuntimeException("Invalid input data, no valid result")
    }

    intersection(ids(0), ids(1)).mkString
  }
}
