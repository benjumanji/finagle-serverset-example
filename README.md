Finagle ServerSet Example
=========================

This is a quick example of how to use finagles "new" server set stuff with a zookeeper resolver. By new I am referring to setting things up without referencing the `ClientBuilder` or `ServerBuilder` apis. This project is built with sbt and needs a working zookeeper cluster on `localhost:2181`. If you want to get fancier, by all means edit the addresses. I have included the two main protocols of interest: Http and Thrift.

## Http

To run, open a few terminals and from the root of the project run `sbt run-main io.artfuldodge.Server`. This will set up a number of services registered under `/zktest`. Have a look! In a fresh terminal run `sbt run-main io.artfuldodge.Client`. This will round robin send a request over http to each one of your services. Congratulations! You did it!

### The server

The server announcement is of the form "schema!host!path!shard" I gleaned this by looking at the ZkAnnouner class in `finagle-serverset`. Shard can alwys be set to zero, apparently this isnt important. ':\*' Binds to an empheral port.

### The client

Pretty much identical, just no shard id. We use zk2, because it's newer. It's apprently better too. You can list a comma sperated set of hosts followed by the port if you have a zk cluster (which you should).

## ThriftMux

This is all very simple, using the same resolvers as for http, but it took me a little digging to realise that `ListeningServer` allowed you to announce. This project uses scrooge to generage the interfaces, so have a look at the generated source and the original thrift file.
