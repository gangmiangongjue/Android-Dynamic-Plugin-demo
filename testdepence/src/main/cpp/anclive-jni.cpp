#include <jni.h>
#include <android/log.h>

//
// Created by shaoxiaofei on 2021/12/17.
//
#define TAG "SXF"
#define LOG(...) __android_log_print(ANDROID_LOG_DEBUG,TAG,__VA_ARGS__)

extern "C"
JNIEXPORT void JNICALL
Java_com_example_testdepence_Add_init(JNIEnv
* env,
jobject thiz
,jbyteArray array) {
    LOG("call init from native");
// TODO: implement init()
}