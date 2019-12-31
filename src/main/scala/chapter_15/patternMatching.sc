abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("abs", e @ UnOp("abs", _)) => e // Abs of Abd returns the inner Abs, variable binding
  case UnOp("-", UnOp("-", e)) => e // Double negation
  case BinOp("+", e, Number(0)) => e // Adding zero
  case BinOp("*", e, Number(1)) => e // Multiplying by one
  case BinOp("*", x, y) if x == Number(0) || y == Number(0) => Number(0) // Multiplying by zero with pattern guard
  case BinOp("*", _, _) => expr // Any value returns the same expression obsly
  case _ => expr
}

/**
  * Sealed classes help the compiler know that only the defined classes in this files are
  * the only ones that exists, this helps to know which patterns are missing
  */
sealed abstract class MyExpress
case class MyVar(name: String) extends MyExpress
case class MyNumber(num: Double) extends MyExpress
case class MyUnOp(operator: String, arg: Expr) extends MyExpress
case class MyBinOp(operator: String, left: Expr, right: Expr) extends MyExpress

def describe(e: MyExpress): String = e match {
  case MyVar(_) => "A variable"
  case MyNumber(_) => "A number"
}
// A warning like this would be thrown
//warning: match may not be exhaustive.
//It would fail on the following inputs: MyBinOp(_, _, _), MyUnOp(_, _)
//describe: (e: MyExpress)String