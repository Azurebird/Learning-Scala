import scala.collection.mutable.{ArrayBuffer, ListBuffer}

//#############
//# SEQUENCES #
//#############
// Lists inmutable and linked
val colors = List("red", "blue", "green")

// Arrays equivalent to a simple array Int[]
val fiveInts = new Array[Int](5) // Initialize an array of length 5
val fiveToOne = Array(5, 4, 3, 2, 1) // When you know the elements

// List Buffers O(1) append and prepend operations
val buf = new ListBuffer[Int]
buf += 1 // buf.type = ListBuffer(1)
buf += 2 // buf.type = ListBuffer(1, 2)
buf += 3 // buf.type = ListBuffer(1, 2, 3)
0 +=: buf // buf.type = ListBuffer(0, 1, 2, 3)

// ArrayBuffer works much like an ArrayList
val arrBuf = new ArrayBuffer[Int]()
arrBuf += 1
arrBuf += 2
3 +=: arrBuf

// Part of the rest of the chapter covers TUPLES, Sets and Maps, bunt since we already studied them on previous chapters
// Ill Skip them