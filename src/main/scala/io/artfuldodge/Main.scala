package io.artfuldodge

import com.twitter.util.Await
import com.twitter.finagle.Httpx
import com.twitter.finagle.httpx.RequestBuilder

object Server extends App {

  val port = args(0)

  val foo0 = Foo()
  val foo0s = Httpx.serveAndAnnounce(port, "zk!localhost:2181!/zktest!0", foo0)

  Await.ready(foo0s)
}

object Client extends App {
  val client = Httpx.newService("zk2!localhost:2181!/zktest")
  val req = RequestBuilder().url("http://foo.com").buildGet
  (1 to 100).map(_ => Await.ready(client(req).map(x => println(x))))
}
