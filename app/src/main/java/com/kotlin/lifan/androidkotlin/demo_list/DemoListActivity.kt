package com.kotlin.lifan.androidkotlin.demo_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View

import com.kotlin.lifan.androidkotlin.base.BaseActivity
import com.kotlin.lifan.androidkotlin.base.ItemHome
import com.kotlin.lifan.androidkotlin.R
import com.kotlin.lifan.androidkotlin.data_base.DBActivity
import com.kotlin.lifan.androidkotlin.dispatchevent.EventActivity
import com.kotlin.lifan.androidkotlin.killapptest.KillActivity
import com.kotlin.lifan.androidkotlin.my_view.SeekBarAc
import com.kotlin.lifan.androidkotlin.threadview.ThreadPrintActivity
import com.kotlin.lifan.androidkotlin.threadview.ThreadViewActivity
import com.kotlin.lifan.androidkotlin.webinterface.WebActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author by LiFan
 * @date 2018/10/29
 */

class DemoListActivity : BaseActivity() {
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, DemoListActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        content.addView(ItemHome(this, "JS-Native交互", View.OnClickListener { WebActivity.start(this) }))
        content.addView(ItemHome(this, "SeekBar", View.OnClickListener { SeekBarAc.start(this) }))
        content.addView(ItemHome(this, "数据库日志", View.OnClickListener { DBActivity.start(this) }))
        content.addView(ItemHome(this, "空调模式", View.OnClickListener { ModeChoiceAc.start(this) }))
        content.addView(ItemHome(this, "App持久化存储", View.OnClickListener { KillActivity.start(this) }))
        content.addView(ItemHome(this, "子线程刷新View", View.OnClickListener { ThreadViewActivity.start(this) }))
        content.addView(ItemHome(this, "点击事件传递", View.OnClickListener { EventActivity.start(this) }))
        content.addView(ItemHome(this, "APP线程打印", View.OnClickListener { ThreadPrintActivity.start(this) }))
    }
}
