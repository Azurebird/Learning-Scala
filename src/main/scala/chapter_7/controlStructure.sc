import java.io.{FileNotFoundException, FileReader, IOException}

/**
  * IF Control Structure
  */
val value = if (1 < 3) "thisValue" else "thatValue" // String = thisValue

/**
  * Try/Catch
  */
try {
  val f = new FileReader("input.txt")
} catch {
  // Pattern matching
  case ex: FileNotFoundException => println("FileNotFound")
  case ex: IOException => println("IOException")
}

def f(): Int = try 1 finally return 2
f() // Int = 2

def g(): Int = try 1 finally 2
g() // Int = 1

/**
  * Match Expressions
  */
val firstArg = "eggs"
val matchResult = firstArg match {
  case "salt" => "pepper"
  case "eggs" => "bacon"
  case _ => "Naniii?"
}
matchResult // String = bacon

// IMPORTANT Notes
// Value assignments in java results in the value assigned. In Scala assignment results in the Unit value



