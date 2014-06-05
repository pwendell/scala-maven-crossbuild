# Simple cross-building example in Maven

This gives a very simple example of cross-building a project in Maven for
Scala 2.10 and 2.11 using a Maven profile to change the dependency
versions.

One thing that is tricky but not covered here is how this pom file could be
published for both 2.10 and 2.11 to allow linking against it in either case.
This might require adding a wrapper script that modifies the pom files and then
publishes for separately 2.10 and 2.11. Tools like SBT can handle this situation
more gracefully because they dynamically generate POM's.

```
$ mvn clean scala:compile package shade:shade
...
$ /opt/scala/scala-2.10.3/bin/scala -cp assembly.jar main.scala.Foo
DenseVector(0.0, 0.0, 0.0, 0.0, 0.0)
```

```
$ mvn -Pscala-211 clean scala:compile package shade:shade
...
$ /opt/scala/scala-2.10.3/bin/scala -cp assembly.jar main.scala.Foo
DenseVector(0.0, 0.0, 0.0, 0.0, 0.0)
```
