package com.ian.techtest.Model

import io.circe.Json
import io.circe.generic.auto._
import io.circe.syntax.EncoderOps


case class RequestToServer(name: String, creditScore: Int, salary: Int)


object RequestToServer {

  def convert(userData: RequestToServer): Json = {
    RequestToServer(userData.name + " " + "successfully encoded", userData.creditScore, userData.salary).asJson
  }

}

