#include <stdio.h>
#include <jni.h>

JNIEXPORT void JNICALL Java_Main_nativeHello
  (JNIEnv *env, jclass) {
   printf("Hello, World!");
}

double add(double a, double b) {
    return a + b;
}
