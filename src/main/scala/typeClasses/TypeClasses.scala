package typeClasses

import java.util.function.DoubleToLongFunction

object TypeClasses extends App {

  trait Math[A]{
    def add(first: A, second: A): A
    def subtract(first: A, second: A): A
    def multiply(first: A, second: A): A
    def divide(first: A, second: A): A
  }

  implicit val doMathsForInt: Math[Int] = new Math[Int] {
    override def add(first: Int, second: Int): Int = first + second

    override def subtract(first: Int, second: Int): Int = first - second

    override def multiply(first: Int, second: Int): Int = first * second

    override def divide(first: Int, second: Int): Int = first / second
  }

  implicit val doMathsForDouble: Math[Double] = new Math[Double] {
    override def add(first: Double, second: Double): Double = first + second

    override def subtract(first: Double, second: Double): Double = first - second

    override def multiply(first: Double, second: Double): Double = first * second

    override def divide(first: Double, second: Double): Double = first / second
  }

  private object DoTheMath {

     def addition[B](first: B, second: B)(implicit m: Math[B]): B = {
      m.add(first, second)
    }


  }

  println("Addition: "+ DoTheMath.addition(23,23))
  println("Addition: "+ DoTheMath.addition(23.1,23.2))

}
