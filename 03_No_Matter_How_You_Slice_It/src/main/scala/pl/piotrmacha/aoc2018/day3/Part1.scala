package pl.piotrmacha.aoc2018.day3

object Part1 {
  def run(claims: Array[Claim]): Int =
    claims
      .flatMap(claim => claim.region.overlaps(
        claims
          .filterNot(c => c == claim)
          .map(claim => claim.region)
      ))
      .flatMap(overlap => overlap.points())
      .distinct
      .length
}
