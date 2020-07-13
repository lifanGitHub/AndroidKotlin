package com.kotlin.lifan.androidkotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Author: LiFan
 * Date: 2020/7/13
 * Description:
 * 协程的优势: 创建1000_000个线程是很困难的 但是协程可以
 */

fun main() = runBlocking {
    var i = 0
    repeat(1000_000){
        GlobalScope.launch {
            delay(1000)
            println("运行了${i++}次")
        }
    }

    while (true){}
}