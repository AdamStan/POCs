class Factorial {
  def calculate(n: Int): Int = {
    var result = 1;
    for (i <- 1 to n) {
      result = result * i
    }
    return result
  }
}
