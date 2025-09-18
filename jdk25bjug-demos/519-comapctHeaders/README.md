##  519: [Compact Object Headers](https://openjdk.org/jeps/519) (25)

 * `/usr/lib/jvm/java-21-openjdk/bin/java -Xmx100m Main.java`
 * `/usr/lib/jvm/java-25-openjdk/bin/java -XX:+UseCompactObjectHeaders   -Xmx100m Main.java`
 * and `/usr/lib/jvm/java-25-openjdk/bin/java  -Xmx100m Main.java` same number of objects, why?
 * the `+UseCompactObjectHeaders` is in heap or native jvm memory?-)
 * `ps -p  pid  -o %mem,cmd`  x  `python ps_mem/ps_mem.py -p pid` however prints the same again
 * add int/remove int
 * it have efect also to total number of Objects




