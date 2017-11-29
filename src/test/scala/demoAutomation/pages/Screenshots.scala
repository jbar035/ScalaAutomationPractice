package demoAutomation.pages

object Screenshots extends WebPage {

  override val url : String = "https://the-internet.herokuapp.com/"

  override def expectedPageTitle: Option[String] = Some("The Internet")
  override def expectedPageHeader: Option[String] = Some("This test should fail")

  def failATest(): Unit = {
    setCaptureDir("/home/user/Pictures/Screenshots")
    withScreenshot{
      assert(cssSelector("h3").element.text == "fail this test", "Page header is not correct")
    }
  }


}
