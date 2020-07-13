package com.kotlin.lifan.androidkotlin.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Author: LiFan
 * Date: 2020/7/13
 * Description: https://www.kotlincn.net/docs/reference/coroutines/composing-suspending-functions.html
 * 在概念上，async 就类似于 launch。它启动了一个单独的协程，
 * 这是一个轻量级的线程并与其它所有的协程一起并发的工作。
 * 不同之处在于 launch 返回一个 Job 并且不附带任何结果值，
 * 而 async 返回一个 Deferred —— 一个轻量级的非阻塞 future，
 * 这代表了一个将会在稍后提供结果的 promise。你可以使用 .await()
 * 在一个延期的值上得到它的最终结果， 但是 Deferred 也是一个 Job，所以如果需要的话，你可以取消它。
 */

fun main() = runBlocking {
//    demo1
//    val time = measureTimeMillis {
//        val one = async { doSomethingUsefulOne() }
//        val two = async { doSomethingUsefulTwo() }
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("Completed in $time ms")

    //    demo2
    val time2 = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        //CoroutineStart.LAZY 在不执行计算的情况下 不占用资源
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time2 ms")

}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000)
    return 1
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000)
    return 1
}
