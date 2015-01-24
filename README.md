Finagle ServerSet Example
=========================

This is a quick example of how to use finagles "new" server set stuff with a zookeeper resolver. This project is built with sbt and needs a working zookeeper cluster on `localhost:2181`. If you want to get fancier, by all means edit the addresses in Main.scala. To run, open a few terminals and from the root of the project run `sbt run-main io.artfuldodge.Server :808x` where `x` is some digit. This will set up a number of services registered under `/zktest`. Have a look! In a fresh terminal run `sbt run-main io.artfuldodge.Client`. This will round robin send a request over http to each one of your services. Congratulations! You did it!
