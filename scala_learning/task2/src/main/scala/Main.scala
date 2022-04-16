import scala.io.StdIn.readLine

object Main extends App {
  val factorial = new Factorial()
  println("Enter a number to calculate N-factorial")
  var n = readLine()
  var factorialN = n.toIntOption
  while (factorialN.isEmpty) {
    println("This is not a integer!")
    n = readLine()
    factorialN = n.toIntOption
  }
  println("The result " + n + "! is: " + factorial.calculate(factorialN.get))
}