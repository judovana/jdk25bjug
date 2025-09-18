##  472: [Prepare to Restrict the Use of JNI](https://openjdk.org/jeps/472) (24)

 * `JAVA_HOME=/usr/lib/jvm/java-21-openjdk/`
 * `/usr/lib/jvm/java-21-openjdk/bin/javac -h . Main.java && gcc -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux Main.c -o Main.o && gcc -shared  -fPIC -o libnative.so Main.o -lc`
 * `/usr/lib/jvm/java-21-openjdk/bin/java  -Djava.library.path=. Main.java`
 * `/usr/lib/jvm/java-25-openjdk/bin/java  -Djava.library.path=. Main.java`
   * will work but will print warnings
 * ` /usr/lib/jvm/java-25-openjdk/bin/java --enable-native-access=ALL-UNNAMED -cp . -Djava.library.path=. Main` 
   *  will silence them and will be mandatory later
 * [JEP draft: Integrity by Default](https://openjdk.org/jeps/8305968)
   * `/usr/lib/jvm/java-25-openjdk/bin/java  MA.java` - ok
   * `/usr/lib/jvm/java-25-openjdk/bin/java  FF.java` -  warnings
   * `/usr/lib/jvm/java-21-openjdk/bin/java  --enable-preview --source 21 FF.java`  warnings..


