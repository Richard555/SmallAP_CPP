#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_richardchen_smallap_1cpp_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */,
        jobject JNIBuf) {

    std::string hello = "Hello from C++";
    unsigned char *pBuf = (unsigned char*)env->GetDirectBufferAddress(JNIBuf);
    *pBuf='G';

    return env->NewStringUTF(hello.c_str());
}
