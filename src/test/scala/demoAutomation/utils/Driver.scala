package demoAutomation.utils

import cats.syntax.either._
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.{BrowserType, DesiredCapabilities}

object Driver {

  private val systemProperties = System.getProperties

  def newWebDriver(): Either[String, WebDriver] = {
    val selectedDriver: Either[String, WebDriver] = Option(systemProperties.getProperty("browser", "chrome")).map(_.toLowerCase) match {
      case Some("firefox") ⇒ Right(createFirefoxDriver())
      case Some("chrome") ⇒ Right(createChromeDriver(false))
      case Some("headless") ⇒ Right(createChromeDriver(true))
      case Some(other) ⇒ Left(s"Unrecognised browser: $other")
      case None ⇒ Left("No browser set")
    }

    selectedDriver.map { driver ⇒
      sys.addShutdownHook(driver.quit())
    }
    selectedDriver
  }


  private val isJsEnabled: Boolean = true

  private def createFirefoxDriver(): WebDriver = {

    val capabilities = DesiredCapabilities.firefox()
    capabilities.setJavascriptEnabled(isJsEnabled)
    capabilities.setBrowserName(BrowserType.FIREFOX)

    new FirefoxDriver(capabilities)
  }

  private def createChromeDriver(headless: Boolean): WebDriver = {

    val capabilities = DesiredCapabilities.chrome()
    val options = new ChromeOptions()

    options.addArguments("test-type")
    options.addArguments("--disable-gpu")
    if (headless) options.addArguments("--headless")

    capabilities.setJavascriptEnabled(isJsEnabled)
    capabilities.setCapability(ChromeOptions.CAPABILITY, options)

    new ChromeDriver(capabilities)
  }

}