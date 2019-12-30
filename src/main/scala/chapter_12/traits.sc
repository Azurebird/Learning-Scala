trait Philosophical {
  def philosophize(): Unit = {
    println("I consume memory, therefore I am!")
  }
}

class Frog extends Philosophical {
  override def toString: String = "green"
}

val frog = new Frog
frog.philosophize()

val phil: Philosophical = frog
phil.philosophize()

class Animal
trait HasLegs

class Rana extends Animal with Philosophical with HasLegs {
  override def toString: String = "green"
}