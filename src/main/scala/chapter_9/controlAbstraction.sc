/**
  * Curring
  */
def sumNumbers = (x: Int) => (y: Int) => x + y // Int => (Int => Int)
def sumWithOne = sumNumbers(1) // Int => Int
def sumWithFour = sumNumbers(4) // Int => Int
sumWithOne(9) // Int = 10
sumWithFour(20) // Int = 24


def applyFunctionToArgs =
  (function: (Int, Int) => Int) =>
    (x: Int, y: Int) =>
      function(x, y)
def multiplyNumbers = applyFunctionToArgs(_*_)
def sumTwoNumbers = applyFunctionToArgs((x, y) => x + y)
applyFunctionToArgs(_*_)(6, 3) // Int = 18
multiplyNumbers(6, 3) // Int = 18
sumTwoNumbers(6, 3) // Int = 9

def curriedSum(x: Int)(y: Int) = x + y
curriedSum(2)(3)

// Curly braces may be used instead of parenthesis when calling a function but this only works on single argument methods
// Thats why currying a function lets us use them like this:
curriedSum{ 2 }{ 4 }
// Curly braces are usually used when using a multiline statement like:
curriedSum{ 2 }{
  val anOperation = 2
  val anotherOperation = 6
  anOperation + anotherOperation
}

/**
  * By-Name Parameters
  */
// Suppose we would like to implement an assertion
val evaluateAssert = false
def isTrueByNameParameter(predicate: => Boolean) =
  if(evaluateAssert && !predicate) throw new AssertionError
// We could also implement the previous function like this:
def isTrue(predicate: Boolean) =
  if(evaluateAssert && !predicate) throw new AssertionError
// And use them like this
isTrueByNameParameter(1 < 3)
isTrue(1 < 3)
// The difference between those resides in the evaluation time of the predicate
// ByNameParameters are evaluated when used, while the other is evaluated before passing it to the function
// That's why we can do this ("It's a division by zero o.O")
isTrueByNameParameter(1 / 0 == 3)
// But not this
isTrue(1 / 0 == 3) // ArithmeticException / by zero


