package typeClasses

import cats.implicits.catsSyntaxEq
import cats.kernel.Eq


object CatCompaireEq extends App {

  final case class Cat(name: String, age: Int, color: String)

  val cat1 = Cat("Garfield", 38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")
  val cat3 = Cat("Garfield", 38, "orange and black")
  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]
  val optionCat3 = Option(cat3)

  private implicit val catCompaire: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
    (cat1.age === cat2.age && cat1.color === cat2.color && cat1.name ===cat2.name)
  }

  println("Cats: "+ (optionCat1 === optionCat2))
  println("Cats: "+ (optionCat1 === optionCat3))
  println("Cats: "+ (optionCat1 =!= optionCat3))
}
