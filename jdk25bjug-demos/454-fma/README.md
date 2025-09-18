## 454: [Foreign Function & Memory API](https://openjdk.org/jeps/454) (22)

 * `JAVA_HOME=/usr/lib/jvm/java-21-openjdk/`
 * `/usr/lib/jvm/java-21-openjdk/bin/javac -h . Main.java`
 * `gcc -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux Main.c -o Main.o`
 * `gcc -shared  -fPIC -o libnative.so Main.o -lc`
 * `/usr/lib/jvm/java-25-openjdk/bin/java -Djava.library.path=. Main.java`
 * `/usr/lib/jvm/java-25-openjdk/bin/java  MA.java`
 * `/usr/lib/jvm/java-25-openjdk/bin/java  FF.java`


