## 423: [Region Pinning for G1](https://openjdk.org/jeps/423) (22)

 * `JAVA_HOME=/usr/lib/jvm/java-21-openjdk/`
 * `/usr/lib/jvm/java-21-openjdk/bin/javac -h . Main.java && gcc -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux Main.c -o Main.o && gcc -shared  -fPIC -o libnative.so Main.o -lc`
 * `/usr/lib/jvm/java-21-openjdk/bin/javac Main.java`
 * `clear ; /usr/lib/jvm/java-21-openjdk/bin/java -Xmx10m -cp . -Djava.library.path=. Main 1000000 4` will block the allocations
 * `clear ; /usr/lib/jvm/java-25-openjdk/bin/java -Xmx10m -cp . -Djava.library.path=. Main 1000000 4` will not
 * what about other gcs?
  * shenandoahs: 
    * `-XX:+UseShenandoahGC`
    * `-XX:+UseShenandoahGC -XX:+UnlockExperimentalVMOptions -XX:ShenandoahGCMode=generational`
      * looks ok since jdk21
  * zgc
   * `-XX:+UseZGC`
   * oem?
    * looks bad anyway since jdk21
 * try to run Main.java and rejoice new OOM



