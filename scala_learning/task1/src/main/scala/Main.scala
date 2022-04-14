/**
 * Run with command: sbt "run 12 32"
 */

object Main {
    def main(args: Array[String]) = {
        println("Hello, world")
        var number1 = args(0)
        var number2 = args(1)
        try {
          println("The result = " + new Adder().add(number1, number2))
        } catch {
          case e: Exception => println("Values are incorrect!")
        }
    }
}
