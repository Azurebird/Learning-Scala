abstract class AbstractCurrency(initialValue: Long) {
  // This means currency most be a subclass of AbstractCurrency
  type Currency <: AbstractCurrency

  val amount: Long = initialValue
  val designation: String

  def +(that: Currency): Currency = make(that.amount + this.amount)

  def make(amount: Long): Currency

  override def toString: String = s"$amount $designation"
}

class ColombianPeso(amount: Long) extends AbstractCurrency(amount) {
  override type Currency = ColombianPeso
  val designation = "CLP"

  override def make(amount: Long): Currency = new ColombianPeso(amount)
}

class Dollar(amount: Long) extends AbstractCurrency(amount) {
  override type Currency = Dollar
  val designation = "USD"

  override def make(amount: Long): Currency = new Dollar(amount)
}

val colombianPeso = new ColombianPeso(5000)
val dollar = new Dollar(10)
val dolla2r = new Dollar(10)


dollar + dolla2r
