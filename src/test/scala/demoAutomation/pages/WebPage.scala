package demoAutomation.pages

import demoAutomation.pages.DynamicLoadingPage.{messageElement, waitFor}
import demoAutomation.pages.JavascriptAlertPage.cssSelector
import demoAutomation.pages.TheInternetHomepage.linkText
import demoAutomation.stepdefs.Steps
import demoAutomation.utils.Configuration
import org.openqa.selenium.{WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.openqa.selenium.support.ui.ExpectedConditions._
import org.scalatest.selenium.WebBrowser
import org.scalatest.time.{Seconds, Span}
import org.scalatest.{Assertions, Matchers}

import scala.concurrent.duration.Duration


trait WebPage extends org.scalatest.selenium.Page with WebBrowser with Assertions with Matchers with Steps {

  val relativeUrl = ""
  val port = 8080

  lazy val envUrl: String = Configuration.settings.url

  implicit val duration: Duration = Span(2, Seconds)

  def waitFor[T](condition: ExpectedCondition[T])(implicit wait: WebDriverWait): T = wait.until(condition)

  def getUrl(port: Int) = if (envUrl.startsWith("http://local")) s"$envUrl:$port" else envUrl

  def goToPage(): Unit = go to url

  def getCurrentUrl()(implicit driver: WebDriver): String = driver.getCurrentUrl

  def getPageContent()(implicit driver: WebDriver): String = driver.getPageSource

  protected def pageHeader: Query = cssSelector("h1")

  //
  protected def altPageHeader: Query = cssSelector("h3")

  def pageHeaderText() = {
    pageHeader.element.text
  }

  //
  def altPageHeaderText() = {
    altPageHeader.element.text
  }

  def waitForPageToLoad: WebElement = {
    waitFor(visibilityOfElementLocated(pageHeader.by))
  }

  //TODO: determine if I want to keep the below at page trait level. Could be better to define on a page by page basis as not always the same criteria

  def expectedPageTitle: Option[String]

  def expectedPageHeader: Option[String]

  protected def pageHeaderShouldBeCorrect(): Unit = {
    expectedPageHeader.foreach(pageHeaderText shouldBe _)
  }

  //
  protected def altPageHeaderShouldBeCorrect(): Unit = {
    expectedPageHeader.foreach(altPageHeaderText shouldBe _)
  }

  protected def multiPageHeaderShouldBeCorrect(expectedPageTitle: String*): Unit = {
    expectedPageTitle.foreach((pageHeaderText shouldBe _))
  }

  protected def pageTitleShouldBeCorrect(): Unit = {
    expectedPageTitle.foreach(pageTitle shouldBe _)
  }

  def shouldBeLoaded(): Unit = {
    pageTitleShouldBeCorrect()
    pageHeaderShouldBeCorrect()
  }

  def altShouldBeLoaded(): Unit = {
    pageTitleShouldBeCorrect()
    altPageHeaderShouldBeCorrect()
  }

  def enterTextIntoTextField(value: String, selector: String): Unit = {
    textField(selector).value_=(value)
  }

  def checkResult(result: String, selector: String): Unit = {
    cssSelector(selector).element.text should be(result)
  }

  def secondaryPageTitle(title: String): Unit = {
    title shouldBe "File Uploaded!"
  }

  def clickOnLink(linkToClick: String): Unit = {
    clickOn(linkText(linkToClick))
  }

  def clickOnButtonWithId(idToClick: String): Unit = {
    clickOn(id(idToClick))
  }

  def clickOnButtonWithXpath(xpathToClick: String): Unit = {
    clickOn(xpath(xpathToClick))
  }

  def waitForElement(element: Query): WebElement = {
    waitFor(visibilityOfElementLocated(element.by))
  }

  def checkResultImproved(result: String, element: Query): Unit = {
    element.findElement.get.text shouldBe result
  }

  //////////////////////////
  //////Useful methods//////
  //////////////////////////

  //  def waitForElement(element: Query): WebElement = {
  //    waitFor(visibilityOfElementLocated(element.by))
  //  }
  //  def clickOnButtonWithId(idToClick: String): Unit = {
  //    clickOn(id(idToClick))
  //    Thread.sleep(500)
  //  }
  //  def clickOnButtonWithXpath(xpathToClick: String): Unit = {
  //    clickOn(xpath(xpathToClick))
  //  }
  //  def clickOnLink(linkToClick: String): Unit = {
  //    clickOn(linkText(linkToClick))
  //  }
  //  def enterTextIntoTextField(value: String, selector: String): Unit = {
  //    textField(selector).value_= (value)
  //  }
  //  def waitForPageToLoad: WebElement = {
  //    waitFor(visibilityOfElementLocated(pageHeader.by))
  //  }
  //  def waitFor[T](condition: ExpectedCondition[T])(implicit wait: WebDriverWait): T = wait.until(condition)
  //  protected def pageHeader: Query = cssSelector("h1")
  //  def goToPage(): Unit = go to url
  //
  //  def getCurrentUrl()(implicit driver: WebDriver): String = driver.getCurrentUrl

}
