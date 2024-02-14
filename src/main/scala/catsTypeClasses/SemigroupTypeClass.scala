package catsTypeClasses

import cats.Semigroup
import cats.instances.string._
import cats.syntax.semigroup._
object SemigroupTypeClass extends App {

  val res = Semigroup.apply[String].combine("Hello ", "there!")
  println(res)

  val result = Option(2) |+| Option(23)
  println(result)

  val stringResult = Option("Hi, ") |+| Option("How ") |+| Option("are") |+| Option(" you")
  println(stringResult.get)
}
