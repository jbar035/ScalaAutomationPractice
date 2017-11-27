package demoAutomation.stepdefs

import demoAutomation.pages.auth.AuthWizardPage
import demoAutomation.data.ClientTestData._

class AuthWizardSteps extends Steps {

  Given("""^I am on the GG Sign-in page$"""){ () =>
    AuthWizardPage.goToPage()
    AuthWizardPage.waitForPageToLoad()
    AuthWizardPage.shouldBeLoaded()
  }

  When("""^I login to Agent for Individuals Landing page as a valid client$"""){ () =>
    AuthWizardPage.loginAsClient(ClientWithData)
  }

  Then("""^wait for (\d+) secs$"""){ (millis:Int) =>
    Thread.sleep(millis * 1000)
  }

}
