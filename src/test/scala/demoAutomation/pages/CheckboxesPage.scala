package demoAutomation.pages

object CheckboxesPage extends WebPage {

  override val url : String = "https://the-internet.herokuapp.com/checkboxesh"

  override def expectedPageTitle: Option[String] = Some("The Internet")
  override def expectedPageHeader: Option[String] = Some("Checkboxes")

  def checkCheckboxes(): Unit = {
//    val checkboxFind = find(xpath("//*[@id=\"checkboxes\"]/input[2]"))
//    assert(checkbox.isSelected)
    checkbox("//*[@id=\"checkboxes\"]/input[2]").isSelected should be (true)
  }
}
