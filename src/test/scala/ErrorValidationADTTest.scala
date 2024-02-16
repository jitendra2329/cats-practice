import ErrorValidationADT._
import org.scalatest.funsuite.AnyFunSuiteLike
class ErrorValidationADTTest extends AnyFunSuiteLike {

  test("it should return username and password validated as username and password both are correct") {
    assert(ErrorValidationADT.validateCredentials("jeetnash", "123456789").equals(Right("user name validated! and password validated!")))
  }

  test("it should return invalid username as username is incorrect [does not contains 'nash']") {
    assert(ErrorValidationADT.validateCredentials("jeet", "123456789").equals(Left(InvalidUsername)))
  }

  test("it should return invalid username as username is incorrect") {
    assert(ErrorValidationADT.validateCredentials("jeetunash", "123456789").equals(Left(InvalidUsername)))
  }

  test("it should return invalid password as the length of the password is less than 5") {
    println(ErrorValidationADT.validateCredentials("jeetnash", "1234"))
    assert(ErrorValidationADT.validateCredentials("jeetnash", "1234").equals(Left(InvalidPassword)))
  }

  test("it should return invalid password as password in incorrect") {
    assert(ErrorValidationADT.validateCredentials("jeetnash", "1234432233").equals(Left(InvalidPassword)))
  }
}
