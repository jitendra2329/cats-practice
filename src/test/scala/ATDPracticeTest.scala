import org.scalatest.funsuite.AnyFunSuiteLike

import ATDPractice._
class ATDPracticeTest extends AnyFunSuiteLike {

  test("It should give the result as divisor is non-zero"){
    assert(ATDPractice.division(12,4).equals(Right(DivisionByZeroResult(3.0))))
  }

  test("It should give the DivisionByZeroError as the divisor is zero") {
    assert(ATDPractice.division(12,0).equals(Left(DivisionByZero("divisor can not be zero"))))
  }

}
