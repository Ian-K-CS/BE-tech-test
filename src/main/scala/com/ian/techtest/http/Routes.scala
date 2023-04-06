package com.ian.techtest.http

import cats.effect.IO
import org.http4s.HttpRoutes
import org.http4s.dsl.io._


object Routes {

  val helloWorldService = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name => Ok(s"Hello, $name", "X-auth-token" -> s"$name") // localhost:8080/hello/{name}  // TODO how can a val, 'Ok' take in params? - let alone figure out how you're suppose to know you can add headers into it??? Drilling down into it doesn't reveal anything
    case GET -> Root / "another-route" / pathParamLength => Ok(s"${pathParamLength.length}") // localhost:8080/hello/{pathParamLength}
    case GET -> Root / "1" / "2" / "3" => Ok("all good - this is the response body") // localhost:8080/1/2/3
    case GET -> Root / "no-content" => NoContent()
    case req @ POST -> Root / "post-request-1" => Ok(println(req)) // TODO Not sure this works if i supply any json? How do I get to the body? what is req in this pattern?
    case req @ POST -> Root / "post-request-2" => Ok(println(req))
  }.orNotFound

}
