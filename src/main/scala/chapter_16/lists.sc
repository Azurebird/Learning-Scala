// Lists are inmutable and have a recursive structure
val fruit = List("apples", "oranges", "pears")
val nums = List(1, 2, 3, 4)
val diag3 =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val empty = List()

val otherFruit = "pineapple" :: "strawberry" :: Nil
val List(apple, orange) = otherFruit

fruit ::: otherFruit

def concatLists[T](a: List[T], b: List[T]): List[T] = a match {
  case List() => b
  case x :: xs  => x :: concatLists(xs, b)
}

concatLists(1::Nil, 2::Nil)

// Flatten a list
diag3.flatten
diag3.flatMap(_.toList)

// Zip and Unzip a list
nums zip fruit // List[(Int, String)] = List((1,apples), (2,oranges), (3,pears))
fruit.zipWithIndex // List[(String, Int)] = List((apples,0), (oranges,1), (pears,2))

// toArray, copyToArray
nums.toArray

val copyArray = new Array[Int](10) // Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
nums copyToArray copyArray
copyArray // Array[Int] = Array(1, 2, 3, 4, 0, 0, 0, 0, 0, 0)



