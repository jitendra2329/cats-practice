package catsTypeClasses
import cats.Eq
import cats.instances.int._
import cats.instances.option._
import cats.syntax.eq._

object EqTypeClass extends  App {

  private val eqInt = Eq[Int]
  println(eqInt.eqv(12,12))

  println(122 === 123)
  println(122 =!= 123)

  println((Some(1): Option[Int]) === (None: Option[Int]))
  println((Some(1): Option[Int]) =!= (None: Option[Int]))

}
