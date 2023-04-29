package com.ian.techtest

import cats.effect._
import com.comcast.ip4s.IpLiteralSyntax
import com.ian.techtest.http.Routes.helloWorldService // import the routes object so I can extract out the routes to a different package
import org.http4s.ember.server.EmberServerBuilder

object Main extends IOApp {

  def run(args: List[String]): IO[ExitCode] = {
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"8080")
      .withHttpApp(helloWorldService)
      .build
      .use(_ => IO.never)
      .as(ExitCode.Success)
  }

}
