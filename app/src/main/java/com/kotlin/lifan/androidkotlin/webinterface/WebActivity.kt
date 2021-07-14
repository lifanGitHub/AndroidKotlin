package com.kotlin.lifan.androidkotlin.webinterface

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import com.kotlin.lifan.androidkotlin.R
import com.kotlin.lifan.androidkotlin.base.BaseActivity


public class WebActivity2 : BaseActivity() {

    class JSInterface{
        fun loadText(){
            Log.i("lf","ok")
        }

    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.ac_web)

        val webView = findViewById<View>(R.id.web_view) as WebView
        val tvTitle = findViewById<View>(R.id.text_view) as TextView

        val settings: WebSettings = webView.getSettings()
        settings.javaScriptEnabled = true // 这样网页就可加载JavaScript了

        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.builtInZoomControls = true // 显示放大缩小按钮

        settings.setSupportZoom(true) // 允许放大缩小

        settings.setSupportMultipleWindows(true)

        webView.addJavascriptInterface(JSInterface(), "myJS") // 向webview注册一个Java对象

        webView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                //注入一段JavaScript，该代码主要是调用Java对象的一个方法并将页面标题作为参数
                view.loadUrl(
                    "javascript:window.getTitle.onGetTitle("
                            + "document.getElementsByTagName('title')[0].innerHTML" + ");"
                )
                super.onPageFinished(view, url)
            }
        })

        webView.setWebChromeClient(object : WebChromeClient() {
            override fun onReceivedTitle(view: WebView, title: String) {
                tvTitle.setText(title)
            }
        })

        webView.loadUrl("https://www.baidu.com/")

    }

}