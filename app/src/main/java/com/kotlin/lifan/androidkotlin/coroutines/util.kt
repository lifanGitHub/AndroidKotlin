package com.kotlin.lifan.androidkotlin.coroutines

import kotlinx.coroutines.*

/**
 * Author: LiFan
 * Date: 2020/7/13
 * Description:
 * 取消协程的方法
 * withTimeout
 */

//fun main() = runBlocking {
//    try {
//        withTimeout(3000) {
//            var i = 0
//            while (true) {
//                println(i++)
//                delay(200)
//            }
//        }
//    } catch (e: Exception) {
//        println(e.toString())
//    } finally {
//    }
//}

fun main() = runBlocking {
    val job = launch {
        var i = 0
        while (true) {
            println(i++)
            delay(200)
        }
    }
    delay(2000)
    job.cancel()
    job.join()
}



