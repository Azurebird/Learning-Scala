package chapter_6

class Rational(n: Int, d: Int) {
  require(denominator != 0, "denominator must not be 0")

  private val greatestCommonDivisor = gcd(n, d)
  val numerator: Int = n / greatestCommonDivisor
  val denominator: Int = d / greatestCommonDivisor

  // Alternative constructor must always call the primary or other constructor
  def this(n: Int) = this(n, 1)

  /**
    * Adds two rationals
    * @param that The other rational to add
    * @return A new chapter_6.Rational equals to the sum of this rational with that rational
    */
  def +(that: Rational): Rational = new Rational(
    numerator * that.denominator + that.numerator * denominator,
    that.denominator * denominator
  )

  /**
    * Multiplies two rational
    * @param that The other rational the multiply
    * @return A new chapter_6.Rational equals ot the multiplication of this rational with that rational
    */
  def *(that: Rational): Rational = new Rational(
    numerator * that.numerator,
    denominator * that.denominator
  )

  /**
    * Gives a string representation of this chapter_6.Rational
    * @return A String representation of this chapter_6.Rational
    */
  override def toString: String = s"$numerator/$denominator"

  /**
    * Calculates the greatest common divisor of the two given numbers
    * @return The greatest common divisor
    */
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
