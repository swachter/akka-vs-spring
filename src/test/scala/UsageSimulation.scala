package simulation2

import io.gatling.core.Predef._
import io.gatling.core.session.Session
import io.gatling.core.validation.Success
import io.gatling.http.Predef._
import scala.concurrent.duration._

class UsageSimulation extends Simulation {

  val rampUpTimeSecs = 20
  val testTimeSecs = 10
  val noOfUsers = 10000
  val minWaitMs = 10 milliseconds
  val maxWaitMs = 1000 milliseconds

  val httpConf = http
    .baseURL("http://localhost:8080")
    .disableFollowRedirect

  val headers = Map("Keep-Alive" -> "115")

  val scn = scenario("check")
    .during(testTimeSecs) {
    exec(
      http("get")
        .get("/")
        .headers(headers)
        )
      .pause(minWaitMs, maxWaitMs)
  }

  setUp(scn.inject(
    rampUsers(noOfUsers) over (rampUpTimeSecs seconds)
  ).protocols(httpConf))

}
