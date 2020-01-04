object FunctionalQueue {
  def apply[T](content: T*): FunctionalQueue[T] = {
    val queue = new FunctionalQueue[T](content.toList, content.toList.reverse)
    queue
  }
}

/**
  * Having the class with +T(this is called covariance) as the generic type allows its type to be referenced in a generic way
  * Like this:
  *   val q = FunctionalQueue(1, 2, 3)
  *   val example: FunctionalQueue[Any] = q
  * Without it the compiler would not allow it, but this makes this kind of scenario troublesome:
  *   val q = FunctionalQueue(1, 2, 3)
  *   val example: FunctionalQueue[Any] = q
  *   example.enqueue("string")
  * Since q is a queue of type Int, we need to define a lower bound for enqueue, see explanation below
  *
  * @param leading
  * @param trailing
  * @tparam T
  */
class FunctionalQueue[+T] private(
  private val leading: List[T],
  private val trailing: List[T]
) {

  private def mirror: FunctionalQueue[T] =
    if (leading.isEmpty)
      new FunctionalQueue(trailing.reverse, Nil)
    else
      this

  def head: T = mirror.leading.head

  def tail: FunctionalQueue[T] = {
    val q = mirror
    new FunctionalQueue(q.leading.tail, q.trailing)
  }

  /**
    * This kind of annotation [U >: T] obliges U to be a supertype of T
    */
  def enqueue[U >: T](x: U) = new FunctionalQueue(leading, x :: trailing)

  override val toString: String =
    this.getClass.getName + trailing.reverse.mkString("(", ", ", ")")
}

val q = FunctionalQueue(1, 2, 3) // FunctionalQueue[Int] = FunctionalQueue(1, 2, 3)
q enqueue 4 // FunctionalQueue[Int] = FunctionalQueue(1, 2, 3, 4)
q // FunctionalQueue[Int] = FunctionalQueue(1, 2, 3)

class Cell[+T](init: T) {
  private[this] var current = init
  def get = current
  // This wont compile, see explanation above
  //def set(x: T) = { current = x }
}

//#################
//# CONTRAVARIANT #
//#################
class OutputChannel[-T] {
  def write(x: T) = ???
}

def oChannel = new OutputChannel[Any]
def oChannelExample: OutputChannel[String] = oChannel
