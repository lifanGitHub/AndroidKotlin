package com.kotlin.lifan.androidkotlin.login

import android.os.Bundle
import com.kotlin.lifan.androidkotlin.R
import com.kotlin.lifan.androidkotlin.base.BaseActivity
import com.kotlin.lifan.androidkotlin.base.MainActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_login2.*
import java.util.concurrent.TimeUnit

class LoginActivity : BaseActivity() {
    private val allTime = 300f //1000毫秒内完成
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        val x = Observable
                .interval(1000 * 1, TimeUnit.MICROSECONDS)// 1000帧/秒
                .takeUntil {
                    it > allTime
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val i = it / allTime
                    processView.setProcess(i)
                    if (it.toFloat() == allTime){
                        MainActivity.start(this)
                    }
                }) { }
    }

}
