val args = Array("1", "2", "3", "4")

// Imperative function not pure since it has the side effect of printing in the SO
def printArgsImperative(args: Array[String]): Unit = {
  var i = 0;
  while (i < args.length) {
    print(args(i))
    i += 1
  }
}

// Functional pure function since it does not have side effects
def printArgsFunctional(args: Array[String]): String = args.mkString

printArgsImperative(args) // 1234
print(printArgsFunctional(args)) // 1234
