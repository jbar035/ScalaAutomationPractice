package demoAutomation.pages

object JavascriptAlertPage extends WebPage {

  override val url : String = "https://the-internet.herokuapp.com/javascript_alerts"

  override def expectedPageTitle: Option[String] = Some("The Internet")
  override def expectedPageHeader: Option[String] = Some("JavaScript Alerts")

  val resultSelector: String = "[id='result']"


  def clickSecondButton(): Unit ={
    click on(xpath("//*[@id=\"content\"]/div/ul/li[2]/button"))
  }

  def acceptAlert(): Unit = {
    switchTo(alertBox).accept()
  }

  def checkResult(result: String): Unit = {
    checkResult(result, resultSelector)
  }

//  def checkResult(result: String, selector: String): Unit = {
//    cssSelector(selector).element.text should be (result)
//  }



}
