# 458: [Launch Multi-File Source-Code Programs](https://openjdk.org/jeps/458) (22)

 * `/usr/lib/jvm/java-21-openjdk/bin/java -cp . Main.java ` x ` /usr/lib/jvm/java-25-openjdk/bin/java -cp . Main.java `
 * `cd ../486-secMan` and `/usr/lib/jvm/java-25-openjdk/bin/java Main.java arg` x `/usr/lib/jvm/java-25-openjdk/bin/java  Main arg`
 * and see compiler warnings
 * how the .class?
 * are they read in priority? For .java? for .class?
  * If you forget again, ind dep javac  Dep.java, modify Dep.class. Javac  Main.java and run Main.java x Main



