package com.kotlin.lifan.androidkotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Author: LiFan
 * Date: 2020/7/13
 * Description:
 * 挂起函数
 */

fun main() = runBlocking {
    launch { doWorld2() }
    launch { doWorld() }
    println("Hello,")
}

//等效
//fun main() {
//    GlobalScope.launch {
//        launch { doWorld2() }
//        launch { doWorld() }
//        println("Hello,")
//    }
//
//
//    while (true){}
//}


// 这是你的第一个挂起函数
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}

suspend fun doWorld2() {
    delay(1100L)
    print("!!")
}