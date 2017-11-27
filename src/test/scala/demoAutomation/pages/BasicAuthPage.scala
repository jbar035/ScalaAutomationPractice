package demoAutomation.pages

object BasicAuthPage extends WebPage {

  override val url : String = "http://admin:admin@the-internet.herokuapp.com/basic_auth"

  override def expectedPageTitle: Option[String] = Some("The Internet")
  override def expectedPageHeader: Option[String] = Some("Basic Auth")

//  isn't actually used
//  def enterUsername(username: String): Unit = {
//    enterText(username, usernameTextField)
//  }
//
//  def enterPassword(password: String): Unit = {
//    enterText(password, passwordTextField)
//  }

//  isn't actually used
//  def clickOnSubmit(): Unit = {
//    submit()
//  }
}
