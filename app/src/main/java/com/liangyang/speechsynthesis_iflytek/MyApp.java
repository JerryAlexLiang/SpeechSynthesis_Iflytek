package com.liangyang.speechsynthesis_iflytek;

import android.app.Application;

import com.iflytek.cloud.SpeechUtility;

/**
 * 创建日期：2017/2/16 on 11:34
 * 作者:杨亮 liangyang
 * 描述:初始化讯飞语音,可以在Application类中执行，
 *      把“appid=”后面替换上你在讯飞上创建的应用对应的Appid
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化讯飞语音,可以在Application类中执行，把“appid=”后面替换上你在讯飞上创建的应用对应的Appid
        SpeechUtility.createUtility(getApplicationContext(), "appid = 58a51ac5");
        AudioUtils.getInstance().init(getApplicationContext());
    }
}
