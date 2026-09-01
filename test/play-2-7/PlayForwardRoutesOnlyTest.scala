package rulesplayroutes.test

import org.specs2.mutable.Specification
import play.api.Configuration
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.test.{FakeRequest, WithApplication}
import rulesplayroutes.test.common.TestReverseRoutesOnly
import play.api.test.Helpers._

class PlayForwardRoutesOnlyTest extends Specification {
  val application = new GuiceApplicationBuilder().configure(Configuration("play.allowGlobalApplication" -> true)).build()

  "Play Routes Compiler when run through Bazel" should {
    "Compiles forward routes correctly" in new WithApplication(application) {
      status(route(app, FakeRequest(GET, TestReverseRoutesOnly.generate(10))).get) mustEqual OK
    }
  }
}
