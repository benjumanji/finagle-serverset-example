package io.artfuldodge

import com.twitter.finagle.ThriftMux
import com.twitter.util.{Await, Future}

import io.artfuldodge.thrift.Calc

class CalcImpl extends Calc.FutureIface {
  def add(x: Long, y: Long): Future[Long] = {
    Future.value(x + y)
  }
}

object CalcServer extends App {
  val forum = "zk!localhost:2181!/mux/calc!0"
  val server = ThriftMux.serveIface(":*", new CalcImpl)
  server.announce(forum)
  Await.ready(server)
}

object CalcClient extends App {
  val client = ThriftMux.newIface[Calc.FutureIface]("zk2!localhost:2181!/mux/calc")
  Await.ready(client.add(3, 4).map(x => println(x)))
}
