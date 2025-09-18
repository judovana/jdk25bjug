# 456: [Unnamed Variables & Patterns](https://openjdk.org/jeps/456) (22)

`/usr/lib/jvm/java-21-openjdk/bin/javac UnnamedVars.java`  fails

`/usr/lib/jvm/java-25-openjdk/bin/javac UnnamedVars.java`  passes

`/usr/lib/jvm/java-25-openjdk/bin/java  -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:8000 UnnamedVars` Connect ide and note how `_` is changing

`/usr/lib/jvm/java-25-openjdk/bin/javac NamedVars.java` and compare NamedVars.class with Unnamed.class

