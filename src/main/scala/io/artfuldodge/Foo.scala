package io.artfuldodge

import java.util.concurrent.atomic.AtomicInteger

import com.twitter.finagle.Service
import com.twitter.finagle.httpx.{Request, Response}
import com.twitter.util.Future
import io.finch.Endpoint
import io.finch.response.Ok

class Foo(val i: Int) extends Service[Request, Response] {
  def apply(req: Request): Future[Response] = {
    println("request recieved!")
    Future.value(Ok("foo"))
  }
}

object Foo {
  val count = new AtomicInteger(0)
  def apply(): Foo = {
    new Foo(count.getAndIncrement)
  }
}
