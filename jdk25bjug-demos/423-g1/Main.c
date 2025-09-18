#include <stdio.h>
#include <jni.h>

JNIEXPORT void JNICALL Java_Main_nativeHello
  (JNIEnv *env, jclass, jlong max, jbyteArray culprint) {
   printf("Hello, World!");
   jbyte *a1 = (*env)->GetPrimitiveArrayCritical(env, culprint, 0);
   for (long i = 0; i < max; i++) {
      printf("%d\n", i);
   }
   (*env)->ReleasePrimitiveArrayCritical(env, culprint, a1, 0);
}

