/**
 * Run with command: sbt "run 12 32"
 */

object Main {
    def main(args: Array[String]) = {
        try {
          val adder = new Adder();
          println("The result = " + adder.addAllFromList(args))
        } catch {
          case e: Exception => println("Values are incorrect!")
        }
    }
}
