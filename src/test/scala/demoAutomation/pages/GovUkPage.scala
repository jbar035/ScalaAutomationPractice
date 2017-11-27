package demoAutomation.pages

object GovUkPage extends WebPage {

  override val url : String = "http://www.gov.uk"

  override def expectedPageTitle: Option[String] = Some("Welcome to GOV.UK")
  override def expectedPageHeader: Option[String] = Some("Welcome to GOV.UK")


}
