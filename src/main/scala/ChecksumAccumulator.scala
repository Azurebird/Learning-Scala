import scala.collection.mutable

class ChecksumAccumulator {
  private var sum = 0

  def add(num: Int): Unit = sum += num

  def checksum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache = mutable.Map.empty[String, Int]

  def calculate(key: String): Int = {
    if (cache.contains(key))
      cache(key)
    else {
      val acc = new ChecksumAccumulator
      key.foreach(e => acc.add(e.toByte))
      val cs = acc.checksum()
      cache += (key -> cs)
      cs
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    args.foreach(arg => println(s"$arg: ${ChecksumAccumulator.calculate(arg)}"))
  }
}
