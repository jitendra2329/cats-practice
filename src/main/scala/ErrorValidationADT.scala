
object ErrorValidationADT extends  App {

  sealed trait ValidationError
  final case object InvalidUsername extends ValidationError
  final case object InvalidPassword extends ValidationError

  private def validateUserName(userName:String): Either[ValidationError, String] = {
    if(userName.contains("nash")) {
      if(userName == "jeetnash") Right("user name validated!") else Left(InvalidUsername)
    } else Left(InvalidUsername)
  }

  private def validatePassword(password: String): Either[ValidationError, String] = {
    if(password.length >= 5)  {
      if(password == "123456789") Right("password validated!") else Left(InvalidPassword)
    } else Left(InvalidPassword)
  }

  def validateCredentials(userName: String, password: String): Either[ValidationError, String] = {
    for {
      usernameValidation <- validateUserName(userName)
      passwordValidation <- validatePassword(password)
    } yield s"$usernameValidation and $passwordValidation"
  }


  val username = "jeetnash"
  val password = "123456789"

  println(validateCredentials(username, password))

}
