cmake_minimum_required(VERSION 3.4.1)
set(CMAKE_AUTOMOC ON)
set(CMAKE_VERBOSE_MAKEFILE on)
set(CMAKE_INCLUDE_CURRENT_DIR ON)



set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++14 -pthread -DMGULK_LOG_STDERR=1 -DMEGVII_ACOM_LOG -Wall -Wextra -Wnon-virtual-dtor -Wno-unused-command-line-argument")

add_library(
        anclivejni
        SHARED
        anclive-jni.cpp
)

find_library(
        android-log
        log
)
target_link_libraries(
        anclivejni ${android-log}
)