// Unlike Java, fields and types may also be abstract
trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class NotAbstract extends Abstract {
  override type T = (String, Int)

  override def transform(x: T): T = (s"transformed $x._1", x._2 * 2)

  override val initial = ("a", 1)
  override var current = ("a", 2)
}

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int

  require(denomArg != 0)

  private val g = gcd(numerArg, denomArg)

  val numer = numerArg / g
  val denom = denomArg / g

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString = numer + "/" + denom
}
