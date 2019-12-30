abstract class Element {
  def contents: Array[String]

  def above(that: Element): Element = new ArrayElement(this.contents ++ that.contents)
  def beside(that: Element): Element = new ArrayElement(
    for (
      (line1, line2) <- this.contents zip that.contents
    ) yield line1 + line2
  )
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
  def demo(): Unit = {
    println("Element's implementation invoked")
  }

  override def toString: String = contents mkString "\n"
}

object Element {

  def elem(contents: Array[String]) = new ArrayElement(contents)

  def elem(line: String) = new LineElement(line)
}

private class ArrayElement(
  override val contents: Array[String]
) extends Element {
  final override def demo(): Unit = println("ArrayElement's implementation called")
}

private class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width: Int = s.length
  override def height: Int = 1

  // Cannot override demo since it's final
}

// Notes to self
// Use parenthesis method call when there is a side effect