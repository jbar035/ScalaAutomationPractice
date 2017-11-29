package demoAutomation.pages



object DynamicLoadingPage extends WebPage {

  override  val url: String = "https://the-internet.herokuapp.com/dynamic_loading/"

  override def expectedPageTitle: Option[String]= Some("The Internet")
  override def expectedPageHeader: Option[String]= Some("Dynamically Loaded Page Elements")

  val unHiddenMessage: String = "Hello World!"
  val buttonXpath: String = "//*[@id='start']/button"
  protected def messageElement: Query = id("finish")

  def checkUnhiddenElement(): Unit = {
    checkResult(unHiddenMessage , "finish")
  }

  def clickStartButton(): Unit ={
    clickOnButtonWithXpath(buttonXpath)
  }

  def waitForMessage(): Unit = {
    waitForElement(messageElement)
  }

  def checkResult(): Unit = {
    checkResultImproved(unHiddenMessage, messageElement)
  }


}
