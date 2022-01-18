package com.kotlin.lifan.androidkotlin.threadview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import com.kotlin.lifan.androidkotlin.R
import com.kotlin.lifan.androidkotlin.base.BaseActivity

/**
 * @author: LiFan
 * @date: 2021/10/28
 */
class ThreadPrintActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_thread)

        val sb = StringBuilder()

        sb.append("Current threads: \n\n")

        Thread.getAllStackTraces().forEach {
            sb.append(it.key.name)
            sb.append("\n")
        }

        findViewById<TextView>(R.id.text_view).text = sb.toString()
    }

    companion object{
        @JvmStatic
        fun start(context:Context){
            context.startActivity(Intent(context,ThreadPrintActivity::class.java))
        }
    }
}