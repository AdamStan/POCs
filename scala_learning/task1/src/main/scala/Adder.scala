
class Adder {
  def addAllFromList(values: Array[String]): Int = {
    var result = 0;
    values.foreach(num => result += num.toInt)
    return result
  }
}
