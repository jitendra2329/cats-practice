

object ATDPractice extends App {

   sealed trait DivisionByError
   case class DivisionByZero(error: String ) extends DivisionByError
   case class DivisionByZeroResult(result: Double)

   def division(firstValue: Double, secondValue: Double): Either[DivisionByError, DivisionByZeroResult] = {
    if(secondValue == 0) {
      Left(DivisionByZero("divisor can not be zero"))
    } else
      Right(DivisionByZeroResult(firstValue/secondValue))
  }

  println(division(12,0))
}
