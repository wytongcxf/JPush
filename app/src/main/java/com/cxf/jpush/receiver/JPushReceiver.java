package com.cxf.jpush.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.cxf.jpush.activity.TestActivity;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by cxf on 2017/2/6.
 */
public class JPushReceiver extends BroadcastReceiver {

    private static final String TAG="JPushReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        switch (intent.getAction()){
            //接收通知
            case "cn.jpush.android.intent.NOTIFICATION_OPENED":
                Intent i = new Intent(context, TestActivity.class);
                i.putExtras(bundle);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP );
                context.startActivity(i);
                break;
            //接收普通消息
            case "cn.jpush.android.intent.MESSAGE_RECEIVED":
                String message=bundle.getString(JPushInterface.EXTRA_MESSAGE);
                Log.e(TAG, "onReceive: -------message---->"+message );
                break;
        }
    }
}
