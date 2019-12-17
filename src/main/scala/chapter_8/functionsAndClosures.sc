/**
  * Methods
  */
object MyClass {
  def myMethod(number: Int): Unit = {
    println(number)
  }
}

/**
  * First class functions
  */
val plusOne = (x: Int) => x + 1
plusOne(4)

/**
  * Short forms syntax
  */
val someNumbers = List(1, 2, 3, 4, 5)
someNumbers.filter(x => x > 3) // List[Int](4, 5)
someNumbers.reduce((x, acc) => x + acc) // Int = 15
someNumbers.foreach(x => println(x))

/**
  * Placeholder Syntax
  */
someNumbers.filter(_ > 3) // List[Int](4, 5)
someNumbers.reduce(_+_) // Int = 15
someNumbers.foreach(println _)

/**
  * Partially applied functions
  */
val sum3Numbers = (a: Int, b: Int, c: Int) => a + b + c
val sum2Numbers = sum3Numbers(1, _, _)
val sum1Number = sum2Numbers(2, _)
sum1Number(3) // 1 + 2 + 3 = 6

/**
  * Closures
  */
val fixedValue = 8
val closureFunction = (x: Int) => x + fixedValue
// closureFunction is a closure since it has a "free" variable.
// The name "closure" arises from the act of "closing" the function literal by "capturing" the bindings of its free variable.

/**
  * Special functions
  */
def joinStrings(strings: String*): String = strings.mkString(" ")
joinStrings("this", "is", "an", "example")

/**
  * Named arguments
  */
def speed(distance: Float, time: Float): Float = distance / time
val speedOne = speed(time = 10, distance = 5)
val speedTwo = speed(5, 10)
speedOne == speedTwo // Boolean = true

/**
  * Tail recursion
  */
// No easy to explain with an example
