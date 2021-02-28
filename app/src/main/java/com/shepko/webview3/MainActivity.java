package com.shepko.webview3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    // тут нужно задать url сайта
//    private final String url = "https://rozetka.com.ua/ua/";
    private final String url = "https://www.mvideo.ru/";
//    private final String url = "https://liniilubvi.ru/";

    private WebView mWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.webView);

        // включаем поддержку JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());

        // включаем само приложение в браузере
        if (savedInstanceState == null) {
            mWebView.loadUrl(url);
        } else {
            mWebView.restoreState(savedInstanceState);
        }
    }

    // тут обрабатываем попорот экрана
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}