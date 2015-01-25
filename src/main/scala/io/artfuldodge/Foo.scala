package io.artfuldodge

import com.twitter.finagle.Service
import com.twitter.finagle.httpx.{Request, Response}
import com.twitter.util.Future
import io.finch.response.Ok

class Foo() extends Service[Request, Response] {
  def apply(req: Request): Future[Response] = {
    println("request recieved!")
    Future.value(Ok("foo"))
  }
}

object Foo {
  def apply(): Foo = {
    new Foo()
  }
}
