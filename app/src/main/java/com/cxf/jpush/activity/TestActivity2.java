package com.cxf.jpush.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.cxf.jpush.App;
import com.cxf.jpush.R;
import com.cxf.jpush.entity.JPushTagerEntity;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by cxf on 2017/2/7.
 */
public class TestActivity2 extends AppCompatActivity {

    private static final String TAG = "TestActivity2";
    private WebView mWebView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        initView();
    }

    private void initView() {
        mWebView = (WebView) findViewById(R.id.webView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setMax(100);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mProgressBar.setVisibility(View.VISIBLE);
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mProgressBar.setProgress(newProgress);
                if(newProgress>=100){
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        loadData();
    }

    private void loadData() {
        Bundle bundle = getIntent().getExtras();
        String tager = bundle.getString(JPushInterface.EXTRA_EXTRA);
        Log.e(TAG, "initView: ------tager------>" + tager);
        JPushTagerEntity entity = App.sGson.fromJson(tager, JPushTagerEntity.class);
        String url = entity.getTager();
        mWebView.loadUrl(url);
    }


}
