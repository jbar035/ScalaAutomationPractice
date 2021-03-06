package demoAutomation.data

import demoAutomation.utils.Environment
import demoAutomation.utils.Configuration.environment

case class TestClient(nino: String)

object ClientTestData {

  lazy val ClientWithData: TestClient = environment  match {
    case Environment.Local => TestClient("AE123456C")
    case Environment.Qa => TestClient("AA001813D")
  }

}

