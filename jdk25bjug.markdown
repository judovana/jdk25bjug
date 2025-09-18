#             Quo vadis java?
### Or news in newest LTS JDK25, as released 16/9/2025
###      With short walk from previous LTS
###        over 22, 23, 24 up to now.

By Jiri Vanek, Jiri Andrlik and Karm from IBM's OpenJDK team.
Wednesday, 17th September 2025, JUG meetup in https://impacthub.cz/brno/

From JDK8 to JDK11, java made a gigantic leap. over 17 to 21 its direction get clear - to remove legacy bad things (jar hell...), to keep peace with modern development styles and languages, keep boosting performance, scale but still still keep extensive stability, and backward compatibility.
We will summarize what happened since that time, and what new features will arrive.

JDK25 was early adapted already since June, as many accepted features were simply already finished (mostly thanx to preview/experimental approaches) and merged early to stabilize.
Based on this, we will try to come with as much demos as possible, so save your time.

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Migration path in Developers minds

  * Who is using STS?
    * daily?
    * as playground?
    * is actually trying the new features?
      * which?
    * is actually using the new features?
      * which?
  * Who is jumping from LTS to another LTS?
    * and just checking the new features passively

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Long path since JDK21 (9/23):

## JDK22 3/24
423: [Region Pinning for G1](https://openjdk.org/jeps/423)
447: [Statements before super(...) (Preview)](https://openjdk.org/jeps/447)
454: [Foreign Function & Memory API](https://openjdk.org/jeps/454)
456: [Unnamed Variables & Patterns](https://openjdk.org/jeps/456)
457: [Class-File API (Preview)](https://openjdk.org/jeps/457)
458: [Launch Multi-File Source-Code Programs](https://openjdk.org/jeps/458)
459: [String Templates (Second Preview)](https://openjdk.org/jeps/459)
460: [Vector API (Seventh Incubator)](https://openjdk.org/jeps/460)
461: [Stream Gatherers (Preview)](https://openjdk.org/jeps/461)
462: [Structured Concurrency (Second Preview)](https://openjdk.org/jeps/462)
463: [Implicitly Declared Classes and Instance Main Methods (Second Preview)](https://openjdk.org/jeps/463)
464: [Scoped Values (Second Preview)](https://openjdk.org/jeps/464)

## JDK23  9/24
455: [Primitive Types in Patterns, instanceof, and switch (Preview)](https://openjdk.org/jeps/455)
466: [Class-File API (Second Preview)](https://openjdk.org/jeps/466)
467: [Markdown Documentation Comments](https://openjdk.org/jeps/467)
469: [Vector API (Eighth Incubator)](https://openjdk.org/jeps/469)
473: [Stream Gatherers (Second Preview)](https://openjdk.org/jeps/473)
471: [Deprecate the Memory-Access Methods in sun.misc.Unsafe for Removal](https://openjdk.org/jeps/471)
474: [ZGC: Generational Mode by Default](https://openjdk.org/jeps/474)
476: [Module Import Declarations (Preview)](https://openjdk.org/jeps/476)
477: [Implicitly Declared Classes and Instance Main Methods (Third Preview)](https://openjdk.org/jeps/477)
480: [Structured Concurrency (Third Preview)](https://openjdk.org/jeps/480)
481: [Scoped Values (Third Preview)](https://openjdk.org/jeps/481)
482: [Flexible Constructor Bodies (Second Preview)](https://openjdk.org/jeps/482)

## JDK24  3/25 (quite a lot of features, guess why)
404: [Generational Shenandoah (Experimental)](https://openjdk.org/jeps/404)
450: [Compact Object Headers (Experimental)](https://openjdk.org/jeps/450)
472: [Prepare to Restrict the Use of JNI](https://openjdk.org/jeps/472)
475: [Late Barrier Expansion for G1](https://openjdk.org/jeps/475)
478: [Key Derivation Function API (Preview)](https://openjdk.org/jeps/478)
479: [Remove the Windows 32-bit x86 Port](https://openjdk.org/jeps/479)
483: [Ahead-of-Time Class Loading & Linking](https://openjdk.org/jeps/483)
484: [Class-File API](https://openjdk.org/jeps/484)
485: [Stream Gatherers](https://openjdk.org/jeps/485)
486: [Permanently Disable the Security Manager](https://openjdk.org/jeps/486)
487: [Scoped Values (Fourth Preview)](https://openjdk.org/jeps/487)
488: [Primitive Types in Patterns, instanceof, and switch (Second Preview)](https://openjdk.org/jeps/488)
489: [Vector API (Ninth Incubator)](https://openjdk.org/jeps/489)
490: [ZGC: Remove the Non-Generational Mode](https://openjdk.org/jeps/490)
491: [Synchronize Virtual Threads without Pinning](https://openjdk.org/jeps/491)
492: [Flexible Constructor Bodies (Third Preview)](https://openjdk.org/jeps/492)
493: [Linking Run-Time Images without JMODs](https://openjdk.org/jeps/493)
494: [Module Import Declarations (Second Preview)](https://openjdk.org/jeps/494)
495: [Simple Source Files and Instance Main Methods (Fourth Preview)](https://openjdk.org/jeps/495)
496: [Quantum-Resistant Module-Lattice-Based Key Encapsulation Mechanism](https://openjdk.org/jeps/496)
7497: [Quantum-Resistant Module-Lattice-Based Digital Signature Algorithm](https://openjdk.org/jeps/497)
498: [Warn upon Use of Memory-Access Methods in sun.misc.Unsafe](https://openjdk.org/jeps/498)
499: [Structured Concurrency (Fourth Preview)](https://openjdk.org/jeps/499)
501: [Deprecate the 32-bit x86 Port for Removal](https://openjdk.org/jeps/501)

## JDK25 9/25
470: [PEM Encodings of Cryptographic Objects (Preview)](https://openjdk.org/jeps/470)
502: [Stable Values (Preview)](https://openjdk.org/jeps/502)
503: [Remove the 32-bit x86 Port](https://openjdk.org/jeps/503)
505: [Structured Concurrency (Fifth Preview)](https://openjdk.org/jeps/505)
506: [Scoped Values](https://openjdk.org/jeps/506)
507: [Primitive Types in Patterns, instanceof, and switch (Third Preview)](https://openjdk.org/jeps/507)
508: [Vector API (Tenth Incubator)](https://openjdk.org/jeps/508)
509: [JFR CPU-Time Profiling (Experimental)](https://openjdk.org/jeps/509)
510: [Key Derivation Function API](https://openjdk.org/jeps/510)
511: [Module Import Declarations](https://openjdk.org/jeps/511)
512: [Compact Source Files and Instance Main Methods](https://openjdk.org/jeps/512)
513: [Flexible Constructor Bodies](https://openjdk.org/jeps/513)
514: [Ahead-of-Time Command-Line Ergonomics](https://openjdk.org/jeps/514)
515: [Ahead-of-Time Method Profiling](https://openjdk.org/jeps/515)
518: [JFR Cooperative Sampling](https://openjdk.org/jeps/518)
519: [Compact Object Headers](https://openjdk.org/jeps/519)
520: [JFR Method Timing & Tracing](https://openjdk.org/jeps/520)
521: [Generational Shenandoah](https://openjdk.org/jeps/521)

## JDK26 9/26
504: [Remove the Applet API](https://openjdk.org/jeps/504)
 * netX, ITW, Deepak, me and many interns

66 JEPs, is "just" 34 features at the end, from those but from those 14 indeed landed in  jdk25
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Hotspot and self contained changes 1/3

423: [Region Pinning for G1](https://openjdk.org/jeps/423) (22)
 * reduce latency, and keep G1 live during JNI calls
474: [ZGC: Generational Mode by Default](https://openjdk.org/jeps/474) (23)
  * 490: [ZGC: Remove the Non-Generational Mode](https://openjdk.org/jeps/490) (24)
404: [Generational Shenandoah (Experimental)](https://openjdk.org/jeps/404) (24)
  * 521: [Generational Shenandoah](https://openjdk.org/jeps/521) (25)
475: [Late Barrier Expansion for G1](https://openjdk.org/jeps/475) (24)
  * G1 decrease C2 load
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Hotspot and self contained changes 2/3

479: [Remove the Windows 32-bit x86 Port](https://openjdk.org/jeps/479) (24)
501: [Deprecate the 32-bit x86 Port for Removal](https://openjdk.org/jeps/501) (24)
  * 503: [Remove the 32-bit x86 Port](https://openjdk.org/jeps/503) (25)
  * Intel only, just for case...
486: [Permanently Disable the Security Manager](https://openjdk.org/jeps/486) (24)
  * actually since jdk17
  * SM code still there
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Hotspot and self contained changes 3/3

491: [Synchronize Virtual Threads without Pinning](https://openjdk.org/jeps/491) (24)
  * change the JVM's implementation of the synchronized keyword so that virtual threads can acquire, hold, and release monitors, independently of their carriers.
450: [Compact Object Headers (Experimental)](https://openjdk.org/jeps/450) (24)
  * 519: [Compact Object Headers](https://openjdk.org/jeps/519) (25)
  * 96-128b -> 64b. OpenJ9 inspiration however non-default
  * finished, however: `-XX:+UseCompactObjectHeaders `

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# build and jfr

493: [Linking Run-Time Images without JMODs](https://openjdk.org/jeps/493) (24)
483: [Ahead-of-Time Class Loading & Linking](https://openjdk.org/jeps/483) (24)
  * another ahead of time compilation/caching, for jdk and trained applications
    * 514: [Ahead-of-Time Command-Line Ergonomics](https://openjdk.org/jeps/514) (25)
    * 515: [Ahead-of-Time Method Profiling](https://openjdk.org/jeps/515) (25)
518: [JFR Cooperative Sampling](https://openjdk.org/jeps/518)
520: [JFR Method Timing & Tracing](https://openjdk.org/jeps/520)
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# unfinished changes
509: [JFR CPU-Time Profiling (Experimental)](https://openjdk.org/jeps/509) (25)

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Crypto

478: [Key Derivation Function API (Preview)](https://openjdk.org/jeps/478) (24)
  * 510: [Key Derivation Function API](https://openjdk.org/jeps/510) (25)
  * KDFs make use of cryptographic inputs, such as initial key material, a salt value, and a pseudorandom function, to create new cryptographically strong key material
496: [Quantum-Resistant Module-Lattice-Based Key Encapsulation Mechanism](https://openjdk.org/jeps/496) (25)
  * `KeyPairGenerator.getInstance("ML-KEM")` for the crypto api collection 
497: [Quantum-Resistant Module-Lattice-Based Digital Signature Algorithm](https://openjdk.org/jeps/497) (25)
  * `KeyPairGenerator.getInstance("ML-DSA");` for the crypto api collection
470: [PEM Encodings of Cryptographic Objects (Preview)](https://openjdk.org/jeps/470) (25)
  * Define a concise API that converts between Privacy-Enhanced Mail text and objects representing keys, certificates... 
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# "Small" language improvements 1/2

456: [Unnamed Variables & Patterns](https://openjdk.org/jeps/456) (22)
  * for (Order _ : orders)    // Unnamed variable
458: [Launch Multi-File Source-Code Programs](https://openjdk.org/jeps/458) (22)
  * still requires cp as it is. Just imagine ant without xml...
461: [Stream Gatherers (Preview)](https://openjdk.org/jeps/461) (22)
  * 473: [Stream Gatherers (Second Preview)](https://openjdk.org/jeps/473) (23)
    * 485: [Stream Gatherers](https://openjdk.org/jeps/485) (24)
    * an extension point so that anyone could define intermediate stream operations
467: [Markdown Documentation Comments](https://openjdk.org/jeps/467) (23)
  * flavor?
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# "Small" language improvements 2/2

471: [Deprecate the Memory-Access Methods in sun.misc.Unsafe for Removal](https://openjdk.org/jeps/471) (23)
  * 498: [Warn upon Use of Memory-Access Methods in sun.misc.Unsafe](https://openjdk.org/jeps/498) (24)
454: [Foreign Function & Memory API](https://openjdk.org/jeps/454) (22)
  * Introduce an API by which Java programs can interoperate with code and data outside of the Java runtime. By efficiently invoking  code outside the JVM and by safely accessing its memory (without the brittleness and danger of JNI)
  * 472: [Prepare to Restrict the Use of JNI](https://openjdk.org/jeps/472) 24
    * Prepare the Java ecosystem for a future release that disallows interoperation with native code by default, whether via JNI or the FFM API. As of that release, application developers will have to explicitly enable the use of JNI and the FFM API at startup.
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# "Small" language improvements - unfinished changes

502: [Stable Values (Preview)](https://openjdk.org/jeps/502) (25)
 * dynamic and lazy `final` with full optimization 
 * private final StableValue<Logger> logger = StableValue.of();
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Long cooked changes (finished) 1/2

447: [Statements before super(...) (Preview)](https://openjdk.org/jeps/447) (22)
  *  482: [Flexible Constructor Bodies (Second Preview)](https://openjdk.org/jeps/482) (23)
    * 492: [Flexible Constructor Bodies (Third Preview)](https://openjdk.org/jeps/492) (24)
      * 513: [Flexible Constructor Bodies](https://openjdk.org/jeps/513) (25)
      * my code lives; super()!; and keep going
* 476: [Module Import Declarations (Preview)](https://openjdk.org/jeps/476) (23)
  * 494: [Module Import Declarations (Second Preview)](https://openjdk.org/jeps/494) (24)
      * 511: [Module Import Declarations](https://openjdk.org/jeps/511) (25)
     * `import module myModulesExportedPkgs`
463: [Implicitly Declared Classes and Instance Main Methods (Second Preview)](https://openjdk.org/jeps/463) (22)
  * 477: [Implicitly Declared Classes and Instance Main Methods (Third Preview)](https://openjdk.org/jeps/477) (23)
    * 495: [Simple Source Files and Instance Main Methods (Fourth Preview)](https://openjdk.org/jeps/495) (24)
      * 512: [Compact Source Files and Instance Main Methods](https://openjdk.org/jeps/512) (25)
      * `void main() {     System.out.println("Hello, World!"); }` and extending jshell
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Long cooked changes (finished) 2/2

457: [Class-File API (Preview)](https://openjdk.org/jeps/457) (22)
 * 466: [Class-File API (Second Preview)](https://openjdk.org/jeps/466) (23)
   * 484: [Class-File API](https://openjdk.org/jeps/484) (24)
   * asm, bcel... incorporated
464: [Scoped Values (Second Preview)](https://openjdk.org/jeps/464) (22)
  * 481: [Scoped Values (Third Preview)](https://openjdk.org/jeps/481) (23)
    * 487: [Scoped Values (Fourth Preview)](https://openjdk.org/jeps/487) (24)
      * 506: [Scoped Values](https://openjdk.org/jeps/506) (25)
      * A scoped value is a container object that allows a data value to be safely and efficiently shared by a method with its direct and indirect callees within the same thread, and with child threads
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Long cooked changes (unfinished)

460: [Vector API (Seventh Incubator)](https://openjdk.org/jeps/460) (22)
  * 469: [Vector API (Eighth Incubator)](https://openjdk.org/jeps/469) (23)
    * 489: [Vector API (Ninth Incubator)](https://openjdk.org/jeps/489) (24)
      * 508: [Vector API (Tenth Incubator)](https://openjdk.org/jeps/508) (25)
      * SIMD (Single Instruction, Multiple Data) 
      * IntVector.fromArray...
462: [Structured Concurrency (Second Preview)](https://openjdk.org/jeps/462) (22)
  * 480: [Structured Concurrency (Third Preview)](https://openjdk.org/jeps/480) (23)
    * 499: [Structured Concurrency (Fourth Preview)](https://openjdk.org/jeps/499) (24)
      * 505: [Structured Concurrency (Fifth Preview)](https://openjdk.org/jeps/505) (25)
      * Introducing an API for structured concurrency to treat groups of related tasks running in different threads as single units
455: [Primitive Types in Patterns, instanceof, and switch (Preview)](https://openjdk.org/jeps/455) (23)
  * 488: [Primitive Types in Patterns, instanceof, and switch (Second Preview)](https://openjdk.org/jeps/488) (24)
    * 507: [Primitive Types in Patterns, instanceof, and switch (Third Preview)](https://openjdk.org/jeps/507) (25)
    * ssia
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Dropped...

459: [String Templates (Second Preview)](https://openjdk.org/jeps/459) (22)
  * 465 [String Templates (Third Preview)](https://openjdk.org/jeps/465) (dropped in 23) 
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Demos!
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# "Invisible" changes (without demos)
## 475: [Late Barrier Expansion for G1](https://openjdk.org/jeps/475) (24)

  * Simplify the implementation of the G1 garbage collector's barriers,
    which record information about application memory accesses, by shifting
    their expansion from early in the C2 JIT's compilation pipeline to later.
  * expanding G1 barriers early, as is currently done, increases C2's overhead
     by around 10-20% depending on the application
  * nearly not measurable improvement, but huge stability leap
  * also huge code readability leap
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# "Invisible" changes (without demos)
##  490: [ZGC: Remove the Non-Generational Mode](https://openjdk.org/jeps/490) (24)

 * -XX:+UseZGC -XX:+-ZGenerational
 * will but simply do nothing
 * I gave up on benchmarking ZGC due its to Colored Pointers
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# "Invisible" changes (without demos)
## 404: [Generational Shenandoah (Experimental)](https://openjdk.org/jeps/404) (24)
### 521: [Generational Shenandoah](https://openjdk.org/jeps/521) (25)

 * -XX:+UseShenandoahGC (-XX:+UnlockExperimentalVMOptions) -XX:ShenandoahGCMode=generational 
 * nearly impossible to benchmark, as you need complex loads
 * What is the "generational" keyword anyway?
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# Demos!

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 423: [Region Pinning for G1](https://openjdk.org/jeps/423) (22)

 * reduce latency, and keep G1 live during JNI calls
 * show blocked allocations

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
##  472: [Prepare to Restrict the Use of JNI](https://openjdk.org/jeps/472) (24)

 * moreover just warnings right now

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# 486: [Permanently Disable the Security Manager](https://openjdk.org/jeps/486) (24)
  * since jdk17
  * show change in behavior of -Djava.security.manager=allow/-Djava.security.manager=default in jdk21 x 25 launching
  * show that you can still create class extending SM, use it but not st as manager
  * git checkout jdk-17-ga && grep -ir -e  checkPermission -e checkWrite 2>/dev/null | wc -l
    * 1256
  * git checkout jdk-21+6 && grep -ir -e  checkPermission -e checkWrite 2>/dev/null | wc -l
    * 1279
  * git checkout jdk-24+6 && grep -ir -e  checkPermission -e checkWrite 2>/dev/null | wc -l
    * 1278
  * git checkout jdk-25+6 && grep -ir -e  checkPermission -e checkWrite 2>/dev/null | wc -l
    * 100
 
--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# 486: [Permanently Disable the Security Manager](https://openjdk.org/jeps/486) (24)

   * main difference is now in`-Djava.security.manager=allow` x `-Djava.security.manager=default` `-Djava.security.manager=com.foo.CustomSM`

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 491: [Synchronize Virtual Threads without Pinning](https://openjdk.org/jeps/491) (24)

  * change the JVM's implementation of the synchronized keyword so that virtual threads can acquire, hold, and release monitors, independently of their carriers.

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 519: [Compact Object Headers](https://openjdk.org/jeps/519) (25)

  * Reduce the size of object headers in the HotSpot JVM from between 96 and 128 bits down to 64 bits on 64-bit architectures. 
  *  run billion of mini objects, with and without
  * `-XX:+UseCompactObjectHeaders `
  * see the (non?)heap memory

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 456: [Unnamed Variables & Patterns](https://openjdk.org/jeps/456) (22)

  *  show compiled, show debugger, compare with named an unnamed (jrd)

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 458: [Launch Multi-File Source-Code Programs](https://openjdk.org/jeps/458) (22)

  * interpreted? Compiled? Ordering?

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
##  512: [Compact Source Files and Instance Main Methods](https://openjdk.org/jeps/512) (25)

  * `void main() {     System.out.println("Hello, World!"); }` 
  * see the four valid declarations. See what take preferences and show in jrd (jasm the class version)

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 467: [Markdown Documentation Comments](https://openjdk.org/jeps/467) (23)

  * show various crippled doc notations

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 511: [Module Import Declarations](https://openjdk.org/jeps/511) (25)

  * `import module myModulesExportedPkgs`

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 513: [Flexible Constructor Bodies](https://openjdk.org/jeps/513) (25)

  *  `{my code lives; super()!};` 

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 493: [Linking Run-Time Images without JMODs](https://openjdk.org/jeps/493) (24)

  * nice quick demo to jlink hello world. 
  * unmodified jdk, no crosscompile...

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
##  498: [Warn upon Use of Memory-Access Methods in sun.misc.Unsafe](https://openjdk.org/jeps/498) (24)

  * demonstrate oom
  * show javac/java difference in handling
  * possible to show it still works

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 454: [Foreign Function & Memory API](https://openjdk.org/jeps/454) (22)

  * proper calls to shared objects functions and to native memory

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 484: [Class-File API](https://openjdk.org/jeps/484) (24)

  * asm, bcel... incorporated
   * do not swap with jasm!

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 485: [Stream Gatherers](https://openjdk.org/jeps/485) (24)

  * an extension point so that anyone could define intermediate stream operations
  * Track previously seen elements to influence the transformation of later elements
    * Stream::gather(Gatherer) 
  * providing similar capabilities to intermediate Stream operations as the collect() provides to terminal operations
    * interface Collector<T,A,R>
    * interface Gatherer<T,A,R>

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 506: [Scoped Values](https://openjdk.org/jeps/506) (25)

 * ThreadLocal on steroids
 * Framework -> CLient -> Framework
 * Map in ThreadLocal?-)


--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# remaining previews?

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 509: [JFR CPU-Time Profiling (Experimental)](https://openjdk.org/jeps/509)
  * profiling = powerful way of optimising programs
  * new way of monitoring CPU usage
  * helps identifying CPU hot-spots
  * previous approach was wallclock sampling
    * the information provided not accurate, focusing on execution time rather than CPU

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 520: [JFR Method Timing & Tracing](https://openjdk.org/jeps/520)
  * especially useful if we want to trace methods (execution, timing, etc..) without changes to code
  * can be used on server runned apps (via jmx) during runtime (via jcmd) - no demos for that :(

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 510: [Key Derivation Function API](https://openjdk.org/jeps/510) (25)
  * new API for Key Derivation Function
  * derive additional keys from the input key material
  * one of the building steps toward Hybrid Public Key Encryption (HPKE)
  * more use of symmetric cryptography

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 496: [Quantum-Resistant Module-Lattice-Based Key Encapsulation Mechanism](https://openjdk.org/jeps/496) (25)
  * ML_KEM KeyPairGenerator instance
  * should provide quantum safe lattice based symmetric key transactions
  * combination with JEP 510 demo

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 497: [Quantum-Resistant Module-Lattice-Based Digital Signature Algorithm](https://openjdk.org/jeps/497) (25)
  * Lattice-based signature algorithm..

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 470: [PEM Encodings of Cryptographic Objects (Preview)](https://openjdk.org/jeps/470) (25)
  * unified interface for Privacy-Enhanced Mail format key storage
  * uses PKCS encryption for key storage by default, but the PKCS is not a part of the JEP itself

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
## 483: [Ahead-of-Time Class Loading & Linking](https://openjdk.org/jeps/483) (24)
## 514: [Ahead-of-Time Command-Line Ergonomics](https://openjdk.org/jeps/514) (25)
## 515: [Ahead-of-Time Method Profiling](https://openjdk.org/jeps/515) (25)

  * show startup time?
  * show training of method profiling

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# remaining previews 1/4
## 507: [Primitive Types in Patterns, instanceof, and switch (Third Preview)](https://openjdk.org/jeps/507) (25)

  * Enhance pattern matching by allowing primitive types in all pattern contexts
   * extend `instanceof` and switch to work with all primitive types. 

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# remaining previews 2/4
## 502: [Stable Values (Preview)](https://openjdk.org/jeps/502)

 *  enabling the same performance optimizations that are enabled by declaring a field final
  * The application's startup time improves
 * show code with construct: * private final StableValue<Logger> logger = StableValue.of();
 * have it improved anything?
   * on scale of gigantic codebases and unified writing yes

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# remaining previews 3/4
## 508: [Vector API (Tenth Incubator)](https://openjdk.org/jeps/508) (25)

  *  SIMD via IntVector.fromArray and friends
   * .Vector<E> -> ByteVector, DoubleVector, FloatVector, IntVector, LongVector, ShortVector

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# remaining previews 4/4
##  505: [Structured Concurrency (Fifth Preview)](https://openjdk.org/jeps/505) (25)

  * nice and well controllable sets of threads
  * Scoped values out of the box
  * shared control out of the box

--PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE----PAGE---
# conclusion

  * backward compatibility
  * improvement of current behavior
  * performance gains
    * "if you run your application you wrote today, in 20 years, it will run faster"
    * it wills till run
	* it will work better:)
  * removal of broken/legacy parts
  * incubation time makes features well known and documented before GA



