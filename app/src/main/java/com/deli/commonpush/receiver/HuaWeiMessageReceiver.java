package com.deli.commonpush.receiver;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.huawei.hms.support.api.push.PushReceiver;

public class HuaWeiMessageReceiver extends PushReceiver {

    @Override
    public void onToken(Context context, String token) {
        super.onToken(context, token);
        Log.i("deli", "  HuaWeiMessageReceiver 收到token:" + token);
        //收到华为的token后需要保存下token

    }

    @Override
    public void onToken(Context context, String token, Bundle extras) {
        super.onToken(context, token, extras);
        Log.i("deli", "  HuaWeiMessageReceiver token:" + token);
        Log.i("deli", "  HuaWeiMessageReceiver extras:" + extras);
    }

}
