package com.kotlin.lifan.androidkotlin.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.*

/**
 * @author: LiFan
 * @date: 2021/11/18
 */

fun main() {
    GlobalScope.launch {
        println("GlobalScope.launch in " + Thread.currentThread().name)
        println(s1()+ s2())
    }

    Thread.sleep(1000*60)

}

suspend fun s1(): String {
    withContext(Dispatchers.IO){
//        Thread.sleep(5000)
        delay(5000)
        println(Thread.currentThread().name)
    }
    return "s1 "
}

suspend fun s2(): String {
    withContext(Dispatchers.IO){
//        Thread.sleep(5000)
        delay(5000)
        println(Thread.currentThread().name)
    }
    return "s2 "
}