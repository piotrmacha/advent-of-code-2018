package pl.piotrmacha.aoc2018.day3

object Part2 {
  def run(claims: Array[Claim]): Int =
    claims
      .find(
        claim => claim.region.overlaps(
          claims
            .filterNot(c => c == claim)
            .map(claim => claim.region)
        ).isEmpty
      )
      .map(claim => claim.id)
      .get
}
