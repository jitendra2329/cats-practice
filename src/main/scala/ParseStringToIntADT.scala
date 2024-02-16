import scala.util.{Failure, Success, Try}

sealed trait ParserError
case object NotANumberError extends ParserError
case object NumberLessThanTenError extends ParserError
object ParseStringToIntADT extends App {

   def parseToInt(value: String): Either[ParserError, Int] = {
    Try(value.toInt) match {
      case Failure(_) => Left(NotANumberError)
      case Success(value) =>
        if(value < 10) Left(NumberLessThanTenError)
        else Right(value)
    }
  }

  println(parseToInt("12"))
  println(parseToInt("9"))
  println(parseToInt("10"))
  println(parseToInt("a10"))
}
