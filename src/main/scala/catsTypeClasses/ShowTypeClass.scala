package catsTypeClasses

import cats.Show
import cats.instances.int._

object ShowTypeClass extends App {

  private val showInt: Show[Int] = Show.apply[Int]
  private val showDouble: Show[Double] = Show.apply[Double]

  println(showInt.show(23).isInstanceOf[String])
  println(showDouble.show(23.5).isInstanceOf[String])
}
