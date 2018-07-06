package com.deli.commonpush.receiver;

import android.content.Context;
import android.util.Log;

import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

public class MIUIMessageReceiver extends PushMessageReceiver {

    @Override
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onReceiveRegisterResult(context, miPushCommandMessage);
        //在这里接收token
        Log.i("deli", "小米推送的id:" + MiPushClient.getRegId(context));

    }
}
