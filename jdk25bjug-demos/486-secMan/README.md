# 486: [Permanently Disable the Security Manager](https://openjdk.org/jeps/486) (24)

 * `/usr/lib/jvm/java-21-openjdk/bin/javac  Main.java` ok
 * `/usr/lib/jvm/java-25-openjdk/bin/javac  Main.java` ok?
 * `/usr/lib/jvm/java-21-openjdk/bin/java  Main` ok
 * `/usr/lib/jvm/java-25-openjdk/bin/java  Main` ok?
 * `/usr/lib/jvm/java-21-openjdk/bin/java  Main useIt` ok?
 * `/usr/lib/jvm/java-25-openjdk/bin/java  Main useIt` ok?
   * `-Djava.security.manager=allow` x `-Djava.security.manager=default` `-Djava.security.manager=com.foo.CustomSM`
   * + `-Djava.security.manager=disallow`

