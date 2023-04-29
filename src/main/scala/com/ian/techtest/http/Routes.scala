package com.ian.techtest.http

import cats.effect.IO
import com.ian.techtest.Model._
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import org.http4s.circe._
import org.http4s._
import org.http4s.implicits._
import io.circe.generic.auto._


object Routes {

  val helloWorldService = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name => Ok(s"Hello, $name", "X-auth-token" -> s"$name") // localhost:8080/hello/{name} // TODO can't see how you pass anything into Ok??? (Ok is an object). Cmd click reveals {/* compiled code */}
    case GET -> Root / "another-route" / pathParamLength => Ok(s"${pathParamLength.length}") // localhost:8080/hello/{pathParamLength}
    case GET -> Root / "1" / "2" / "3" => Ok("all good - this is the response body")
    case GET -> Root / "no-content" => NoContent()
    case req @ POST -> Root / "post-request" => Ok(req.body) // response is whatever the request body is!
    case req @ POST -> Root / "creditcards" =>
      implicit val decoder2: EntityDecoder[IO, RequestToServer] = jsonOf[IO, RequestToServer]
      for {
        userData <- req.as[RequestToServer]
        resp <- Ok(RequestToServer.convert(userData))
      } yield resp
  }.orNotFound

}
