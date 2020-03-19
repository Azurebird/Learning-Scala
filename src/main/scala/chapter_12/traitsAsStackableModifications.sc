import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]()
  override def get() = buf.remove(0)
  override def put(x: Int): Unit = buf += x
}

val basicIntQueue = new BasicIntQueue
basicIntQueue.put(2)
basicIntQueue.put(5)
basicIntQueue.get()
basicIntQueue.get()

trait Doubling extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(2 * x)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x + 1)
}

class MyQueue extends BasicIntQueue with Doubling

val myQueue = new MyQueue
myQueue.put(2)
myQueue.put(5)
myQueue.get()
myQueue.get()