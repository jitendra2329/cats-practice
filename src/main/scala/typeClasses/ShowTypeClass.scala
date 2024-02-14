package typeClasses

trait Show[A] {
  def convertToString(value: A): String
}

object Show {
  implicit val intToString: Show[Int] = new Show[Int] {
    override def convertToString(value: Int): String = {
      value.toString
    }
  }

  implicit val doubleToString: Show[Double] = new Show[Double] {
    override def convertToString(value: Double): String = value.toString
  }

}

object ShowTypeClass extends App {

  import Show._

  private def convertTo[A](value: A)(implicit s: Show[A]): String = {
    s.convertToString(value)
  }
  println(convertTo[Int](23))

  implicit class ConvertToString[A](value:A)  {
    def convertToString(implicit v: Show[A]): String = v.convertToString(value)
  }

  private val doubleValue = 33.34
  println(doubleValue.convertToString)
}
