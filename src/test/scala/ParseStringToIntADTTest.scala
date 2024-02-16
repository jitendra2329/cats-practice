import org.scalatest.funsuite.AnyFunSuiteLike
class ParseStringToIntADTTest extends AnyFunSuiteLike {

  test("it should return a number after successfully converting to Int ['23']") {
    val expectedResult = Right(23)
    val actualResult = ParseStringToIntADT.parseToInt("23")
    assert(expectedResult == actualResult )
  }

  test("it should return an error NotANumberError ['A3']") {
    val expectedResult = Left(NotANumberError)
    val actualResult = ParseStringToIntADT.parseToInt("A3")
    assert(expectedResult == actualResult)
  }

  test("it should return an error NumberLessThanTenError ['9']") {
    val expectedResult = Left(NumberLessThanTenError)
    val actualResult = ParseStringToIntADT.parseToInt("9")
    assert(expectedResult == actualResult)
  }
}
