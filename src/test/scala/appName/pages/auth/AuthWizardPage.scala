package appName.pages.auth

import appName.data.TestClient
import org.openqa.selenium.{WebDriver, WebElement}
import org.openqa.selenium.support.ui.ExpectedConditions._
import appName.pages.WebPage

object AuthWizardPage extends WebPage {

  override val expectedPageTitle = Some("Authority Wizard")
  override val expectedPageHeader = Some("Authority Wizard")

  override val port = 9949

  override val url : String = getUrl(port) + "/auth-login-stub/gg-sign-in"

  override def waitForPageToLoad(): WebElement = {
    waitFor(visibilityOfElementLocated(pageHeader.by))
    waitFor(visibilityOfElementLocated(redirectionUrl.by))
    waitFor(visibilityOfElementLocated(ninoTf.by))
  }

  protected def redirectionUrl: Query = name("redirectionUrl")
  protected def ninoTf: Query = name("nino")
  protected def continue: Query = cssSelector("input.button")

  protected def setRedirect(url: String): Unit = redirectionUrl.webElement.sendKeys(url)

  protected def setNino(nino: String): Unit = ninoTf.webElement.sendKeys(nino)

  /**
    * The below should contain the url and local port of the service you wish to redirect following authentication
    */

  val redirectPort = 9429
  val redirectUrl = getUrl(redirectPort) + "/afi/client/authorise-agent"

  def loginAsClient(user: TestClient): Unit = {
    setRedirect(redirectUrl)
    setNino(user.nino)
    click on continue
  }


}
