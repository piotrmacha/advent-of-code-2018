package pl.piotrmacha.aoc2018.day2

object Part2 {
  def diff(a: Array[Char], b: Array[Char], carry: Array[Char] = Array()): Array[Char] = {
    if (a.isEmpty && b.isEmpty) carry
    else diff(a.tail, b.tail, if (a.head != b.head) carry :+ b.head else carry)
  }

  def diff(a: String, b: String): Array[Char] = diff(a.toCharArray, b.toCharArray)

  def intersection(a: Array[Char], b: Array[Char], carry: Array[Char] = Array()): Array[Char] = {
    if (a.isEmpty && b.isEmpty) carry
    else intersection(a.tail, b.tail, if (a.head == b.head) carry :+ a.head else carry)
  }

  def run(input: Array[String]): String = {
    val ids = input
      .map(id => (id, input))
      .map(t => {
        val (id, inputs) = t
        val pairs = inputs
          .filter(s => s != id)
          .map(pair => diff(id, pair))
        (id, pairs)
      })
      .filter(t => {
        val (_, pairs) = t
        pairs.exists(diff => diff.length == 1)
      })
      .map(t => {
        val (id, _) = t
        id.toCharArray
      })

    if (ids.length != 2) {
      throw new RuntimeException("Invalid input data, no valid result")
    }

    intersection(ids(0), ids(1)).mkString
  }
}
