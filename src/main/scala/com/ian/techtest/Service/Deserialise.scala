package com.ian.techtest.Service

import com.ian.techtest.Model._
import io.circe.Json
import io.circe.generic.auto._
import io.circe.syntax.EncoderOps


object Deserialise {

  def convert(userData: UserRequestData): Json = {
    Successful(userData.name + " " + "successfully encoded", userData.creditScore, userData.salary).asJson
  }

}
