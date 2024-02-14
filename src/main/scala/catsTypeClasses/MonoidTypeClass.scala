package catsTypeClasses

import cats.Monoid
import cats.instances.int._
import cats.instances.string._
import cats.syntax.monoid._
object MonoidTypeClass extends App {

    private val intMonoid: Monoid[Int] =  Monoid.apply[Int]
    println(intMonoid.combine(23,2))
    println(intMonoid.empty)

    private val stringMonoid: Monoid[String] =  Monoid.apply[String]
    println(stringMonoid.combine("Hello ", "There!"))


    private def combineAll[A](list: List[A])(implicit monoid: Monoid[A]) = {

      list.foldLeft(monoid.empty)((acc, item) => monoid.combine(acc, item))
    }

    private val list = List("My ", "name ", "is ", "Jitendra.")
    println(combineAll(list))
}
