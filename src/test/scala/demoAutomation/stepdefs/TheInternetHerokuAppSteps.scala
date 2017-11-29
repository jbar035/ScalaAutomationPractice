package demoAutomation.stepdefs

import demoAutomation.pages._

class TheInternetHerokuAppSteps extends Steps {

  Given("""^I navigate to the homepage$"""){ () =>
    TheInternetHomepage.goToPage()
  }

  Then("""^the homepage should be loaded$"""){ () =>
    TheInternetHomepage.shouldBeLoaded()
  }

  When("""^I click on the "(.*)" link$"""){ (arg1: String) =>
    TheInternetHomepage.clickOnLink(arg1)
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

  Then("""^the Javascript alert page should be loaded$""") { () =>
    JavascriptAlertPage.altShouldBeLoaded()

  }

  And("""^I click the second button on the page$""") { () =>
    JavascriptAlertPage.clickSecondButton()
  }

  When("""^I accept the confirmation alert$""") { () =>
    JavascriptAlertPage.acceptAlert()
  }

  Then("""^the result should be "([^"]*)"$"""){ (arg0:String) =>
    JavascriptAlertPage.checkResult(arg0)
  }

  When("""^I select dropdown Option 1$"""){ () =>
    DropdownPage.select()

  }

  Then("""^the selected value should be displayed$"""){ () =>
    DropdownPage.checkDropdownValue()
  }

  When("""^I fail an assertion on the page header$"""){ () =>
    Screenshots.failATest()
  }

  Then("""^the Dynamically Loaded Page Elements page should be loaded$"""){ () =>
    DynamicLoadingPage.altShouldBeLoaded()
  }

  When("""^I click on "([^"]*)"$"""){ (arg0:String) =>
    DynamicLoadingPage.clickOnLink(arg0)
  }

  When("""^I click the start button$"""){ () =>
    DynamicLoadingPage.clickStartButton()
  }

  Then("""^I wait until the message is displayed$"""){ () =>
    DynamicLoadingPage.waitForMessage()
    DynamicLoadingPage.checkUnhiddenElement()
  }



}
