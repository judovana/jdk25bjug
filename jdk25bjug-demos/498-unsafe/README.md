##  498: [Warn upon Use of Memory-Access Methods in sun.misc.Unsafe](https://openjdk.org/jeps/498) (24)

 * `/usr/lib/jvm/java-21-openjdk/bin/javac  Main.java ` x ` /usr/lib/jvm/java-25-openjdk/bin/javac  Main.java `
 * `/usr/lib/jvm/java-21-openjdk/bin/java  Main ` x ` /usr/lib/jvm/java-25-openjdk/bin/java  Main`
 * check of-heap still works (crash the normal with small xmx)
   *  /usr/lib/jvm/java-21-openjdk/bin/java -Xmx10m Main   +-100000000 
 * possible to show memory ps_mem differences



