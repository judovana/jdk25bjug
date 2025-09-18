## 491: [Synchronize Virtual Threads without Pinning](https://openjdk.org/jeps/491) (24)

 * `/usr/lib/jvm/java-21-openjdk/bin/java  Server.java `
 * `/usr/lib/jvm/java-21-openjdk/bin/java  Main.java ` x ` /usr/lib/jvm/java-25-openjdk/bin/java  Main.java`
 * see the death of virtual threads in jdk21
 * compare with 25 and with 21 with removed `synchronize`
 * see the threads in `top -H -p  $(jps | grep Main | sed "s/ .*//")`




