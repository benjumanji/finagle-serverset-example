package io.artfuldodge

import com.twitter.util.Await
import com.twitter.finagle.Httpx
import com.twitter.finagle.httpx.RequestBuilder

object Server extends App {
  val foo = Foo()
  Await.ready(Httpx.serveAndAnnounce(":*", "zk!localhost:2181!/zktest!0", foo))
}

object Client extends App {
  val client = Httpx.newService("zk2!localhost:2181!/zktest")
  val req = RequestBuilder().url("http://foo").buildGet
  (1 to 100).map(_ => Await.ready(client(req).map(x => println(x))))
}
