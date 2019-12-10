var capital = Map("France" -> "Paris")
capital += ("Japan" -> "Tokyo")
capital("France")

def factorial(x: BigInt) : BigInt =
  if (x == 0) 1 else x * factorial(x - 1)

factorial(3)

"Japan" concat "Another"

1.+(3)
1 + 3

1.to(3)
1 to 3

val oneTwo = List(1, 2)
val threeFour = List(3, 4)

// Operator to concat List
oneTwo ::: threeFour

// Operator cons to prepend elements
2 :: threeFour

// Method the append to list, takes N time to append
oneTwo :+ 3

/*
 * Map Example
 */
val setOne = scala.collection.mutable.Set(1, 2, 3, 4)
// returns a new set without modifying setOne
setOne union Set(5)  // scala.collection.mutable.Set[Int] = HashSet(1, 2, 3, 4, 5)
setOne  // scala.collection.mutable.Set[Int] = HashSet(1, 2, 3, 4)
// Modifies setOne
setOne += 5 // scala.collection.mutable.Set[Int] = HashSet(1, 2, 3, 4, 5)
setOne // scala.collection.mutable.Set[Int] = HashSet(1, 2, 3, 4, 5)

/*
 * Map Example
 */
val treasureMap = scala.collection.mutable.Map[Int, String]()
treasureMap += (1 -> "Got to San Andres") // HashMap(1 -> Got to San Andres)
treasureMap += (2 -> "Pay the most expensive hotel")
treasureMap += (3 -> "check under the bed") // HashMap(1 -> Got to San Andres, 2 -> Pay the most expensive hotel, 3 -> check under the bed)
treasureMap(3) // String = check under the bed
