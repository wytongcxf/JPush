package com.cxf.jpush.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cxf.jpush.R;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by cxf on 2017/2/6.
 */
public class TestActivity extends AppCompatActivity {

    private TextView mTitle;
    private TextView mContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }
    private void initView() {
        mTitle= (TextView) findViewById(R.id.title);
        mContent= (TextView) findViewById(R.id.content);
        Intent intent=getIntent();
        if (null != intent) {
            Bundle bundle = getIntent().getExtras();
            String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
            String content = bundle.getString(JPushInterface.EXTRA_ALERT);
            mTitle.setText(title);
            mContent.setText(content);
        }
    }
}
