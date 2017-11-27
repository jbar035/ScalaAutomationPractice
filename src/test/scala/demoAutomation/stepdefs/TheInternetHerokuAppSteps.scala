package demoAutomation.stepdefs

import demoAutomation.pages.TheInternetHomepage
import demoAutomation.pages.ABTestingPage
import demoAutomation.pages.BasicAuthPage
import demoAutomation.pages.CheckboxesPage

class TheInternetHerokuAppSteps extends Steps {

  Given("""^I navigate to the homepage$"""){ () =>
    TheInternetHomepage.goToPage()
  }

  Then("""^the homepage should be loaded$"""){ () =>
    TheInternetHomepage.shouldBeLoaded()
  }

  When("""^I click on the "(.*)" link$"""){ (arg1: String) =>
    TheInternetHomepage.clickOnTopic(arg1)
  }

  Then("""^the A/B page should be loaded$"""){ () =>
    ABTestingPage.altShouldBeLoaded()
  }

  When("""^I enter the login credentials$"""){ () =>
    BasicAuthPage.goToPage()
  }

  Then("""^the Basic Auth page should be loaded$"""){ () =>
    BasicAuthPage.altShouldBeLoaded()
  }

  Then("""^the last checkbox is checked$"""){ () =>
    CheckboxesPage.checkCheckboxes()
  }


}
