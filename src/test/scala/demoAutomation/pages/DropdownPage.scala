package demoAutomation.pages

object DropdownPage extends WebPage {
  override val url : String = "https://the-internet.herokuapp.com/dropdown"

  override def expectedPageTitle: Option[String] = Some("The Internet")
  override def expectedPageHeader: Option[String] = Some("Dropdown List")

  def selectDropdownOption(option: String): Unit = {
    singleSel("dropdown").value = option
  }

  def select(): Unit ={
    singleSel(id("dropdown")).value = "1"
  }

  def checkDropdownValue(): Unit ={
    singleSel(id("dropdown")).value should be ("1")

  }
}
