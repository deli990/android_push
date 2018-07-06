package com.deli.commonpush.util;

import android.app.Application;
import android.util.Log;

import com.huawei.android.hms.agent.HMSAgent;
import com.huawei.android.hms.agent.common.handler.ConnectHandler;
import com.huawei.android.hms.agent.push.handler.EnableReceiveNormalMsgHandler;
import com.huawei.android.hms.agent.push.handler.EnableReceiveNotifyMsgHandler;
import com.huawei.android.hms.agent.push.handler.GetTokenHandler;
import com.meizu.cloud.pushsdk.PushManager;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;

public class PushUtil {


    public static void initPush(Application application) {

        if (MzSystemUtils.isHuaWei()) {
            Log.i("deli", "初始化华为推送");
            initHuaWeiPush(application);
        } else if (MzSystemUtils.isBrandMeizu(application)) {

            Log.i("deli", "初始化魅族推送");
            initFlyme(application);
        } else {
            Log.i("deli", "初始化小米推送");
            initMiuiPush(application);

        }

    }

    //请不要忘记替换push module中的包名和华为的appId
    private static void initHuaWeiPush(Application application) {

        HMSAgent.init(application);
        HMSAgent.connect(application, new ConnectHandler() {
            @Override
            public void onConnect(int rst) {
            }
        });

        HMSAgent.Push.getToken(new GetTokenHandler() {
            @Override
            public void onResult(int rst) {
                Log.i("deli", "推送token ：" + rst);
            }
        });
        HMSAgent.Push.enableReceiveNormalMsg(true, new EnableReceiveNormalMsgHandler() {
            @Override
            public void onResult(int rst) {
            }
        });
        HMSAgent.Push.enableReceiveNotifyMsg(true, new EnableReceiveNotifyMsgHandler() {
            @Override
            public void onResult(int rst) {

            }
        });
    }

    //魅族推送

    private static final String FLYME_APP_ID = "使用魅族自己的appId";
    private static final String FLYME_APP_KEY = "使用魅族自己的appKey";


    private static void initFlyme(Application application) {
        PushManager.register(application, FLYME_APP_ID, FLYME_APP_KEY);
    }


    private static final String MIUI_APP_ID = "使用小米自己的appId";
    private static final String MIUI_APP_KEY = "使用小米自己的appId";
    public static final String TAG = "miuipush";

    private static void initMiuiPush(Application application) {
        MiPushClient.registerPush(application, MIUI_APP_ID, MIUI_APP_KEY);

        LoggerInterface newLogger = new LoggerInterface() {
            @Override
            public void setTag(String tag) {
                // ignore
            }

            @Override
            public void log(String content, Throwable t) {
                Log.d(TAG, content, t);
            }

            @Override
            public void log(String content) {
                Log.d(TAG, content);
            }
        };
        Logger.setLogger(application, newLogger);
    }
}
