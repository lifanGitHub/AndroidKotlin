package com.kotlin.lifan.androidkotlin.webinterface;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.kotlin.lifan.androidkotlin.R;
import com.kotlin.lifan.androidkotlin.base.BaseActivity;
import com.kotlin.lifan.androidkotlin.base.MainActivity;

import org.jetbrains.annotations.NotNull;

public class WebActivity extends BaseActivity {
    WebView webview;
    TextView tvTitle;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_web);

        webview = (WebView) findViewById(R.id.web_view);
        tvTitle = (TextView) findViewById(R.id.text_view);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);// 这样网页就可加载JavaScript了
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBuiltInZoomControls(true);// 显示放大缩小按钮
        settings.setSupportZoom(true);// 允许放大缩小
        settings.setSupportMultipleWindows(true);

        webview.addJavascriptInterface(new JSInterface(), "android"); // 向webview注册一个Java对象
//        webview.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                //注入一段JavaScript，该代码主要是调用Java对象的一个方法并将页面标题作为参数
//                view.loadUrl("javascript:window.getTitle.onGetTitle("
//                        + "document.getElementsByTagName('title')[0].innerHTML" + ");");
//                super.onPageFinished(view, url);
//            }
//        });

        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
//                tvTitle.setText(title);
            }
        });

        webview.loadUrl("http://10.200.7.94:8848/VUE/index.html");

    }

    public static void start(@NotNull Context context) {
        context.startActivity(new Intent(context,WebActivity.class));
    }


    // 避免代码耦合和内存泄漏 应该使用 static class
    class JSInterface {
        @JavascriptInterface
        public void loadText(String s) {
            tvTitle.setText(s);
        }
    }
}
