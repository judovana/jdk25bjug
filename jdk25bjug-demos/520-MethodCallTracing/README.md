# JEP 520
`/usr/lib/jvm/java-25-openjdk/bin/java -XX:StartFlightRecording:filename=jep520-demo.jfr,jdk.MethodTrace#filter=Jep520Demo::compute Jep520Demo`

  * show results of the tracing

`jfr print --events jdk.MethodTrace --stack-depth 20 jep520-demo.jfr`

  * note: make sure to escape dollar signs `$` in bash (personal experience).

`/usr/lib/jvm/java-25-openjdk/bin/java -XX:StartFlightRecording:filename=jep520-demo.jfr,jdk.MethodTrace#filter=Jep520Demo\$Worker::doWork Jep520Demo`

  * you can also use jfc configuration files (xml structure) to set a more complex configuration of tracing

`/usr/lib/jvm/java-25-openjdk/bin/java -XX:StartFlightRecording=filename=jep520-demo.jfr,settings=./demo.jfc   Jep520Demo`
