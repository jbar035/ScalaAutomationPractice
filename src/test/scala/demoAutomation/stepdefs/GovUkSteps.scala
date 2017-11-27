package demoAutomation.stepdefs

import demoAutomation.pages.GovUkPage


class GovUkSteps extends Steps {

  When("""^I navigate to the gov.uk homepage$""") { () =>
    GovUkPage.goToPage()
  }
  Then("""^the gov.uk page should be loaded$""") { () =>
    GovUkPage.shouldBeLoaded()
  }

}
