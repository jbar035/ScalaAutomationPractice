package demoAutomation.pages

object TheInternetHomepage extends WebPage {

  override val url : String = "https://the-internet.herokuapp.com/"

  override def expectedPageTitle: Option[String] = Some("The Internet")
  override def expectedPageHeader: Option[String] = Some("Welcome to the-internet")



}