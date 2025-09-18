## 493: [Linking Run-Time Images without JMODs](https://openjdk.org/jeps/493) (24)

 * `rpm -qa | grep java-25` - no jmods
 * `/usr/lib/jvm/java-25-openjdk/bin/jlink -h | grep "enabled"` - built with this support!
 * `javac -d out  pkg/*`
 * `java --module-path out --module jlinkModule/pkg.Main`
 * `/usr/lib/jvm/java-21-openjdk/bin/jlink --launcher start=jlinkModule/pkg.Main --module-path out  --add-modules jlinkModule  --output customjre`  dies
 * `/usr/lib/jvm/java-25-openjdk/bin/jlink --launcher start=jlinkModule/pkg.Main --module-path out  --add-modules jlinkModule  --output customjre` works
 * limitations
 * modify java... modify...main page
 * packaging




