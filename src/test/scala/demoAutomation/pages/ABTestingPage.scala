package demoAutomation.pages



object ABTestingPage extends WebPage {

  override val url : String = "https://the-internet.herokuapp.com/abtest"

  override def expectedPageTitle: Option[String] = Some("The Internet")
  override def expectedPageHeader: Option[String] = Some("A/B Test Variation 1")
//  def altExpectedPageHeader: String = ("A/B Test [Control]")

  val linkName : String = "A/B Testing"


//  def clickonlink(): Unit = {
//    click on linkText(linkName)
////    clickOnTopic(linkTopic)
//  }

//  def titleShouldBe(): Unit = {
//    multiPageHeaderShouldBeCorrect(expectedPageHeader,altExpectedPageHeader)
//  }
}
