package com.liangyang.speechsynthesis_iflytek;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

/**
 * 创建日期：2017/2/16 on 14:37
 * 作者:杨亮 liangyang
 * 描述:语音播放工具类，调用speakText（要播放的语音文本）方法即可播放语音，
 * 如还需要配置一些其他属性，可自行添加
 */
public class AudioUtils {

    private static AudioUtils audioUtils;

    private SpeechSynthesizer mSpeechSynthesizer;

    private Context context;

    // 0 小燕 青年女声 中英文（普通话） xiaoyan
    // 1 默认 小宇 青年男声 中英文（普通话） xiaoyu
    // 2 凯瑟琳 青年女声 英文 catherine
    // 3 亨利 青年男声 英文 henry
    // 4 玛丽 青年女声 英文 vimary
    // 5 小研 青年女声 中英文（普通话） vixy
    // 6 小琪 青年女声 中英文（普通话） vixq xiaoqi
    // 7 小峰 青年男声 中英文（普通话） vixf
    // 8 小梅 青年女声 中英文（粤语） vixm xiaomei
    // 9 小莉 青年女声 中英文（台湾普通话） vixl xiaolin
    // 10 小蓉 青年女声 汉语（四川话） vixr xiaorong
    // 11 小芸 青年女声 汉语（东北话） vixyun xiaoqian
    // 12 小坤 青年男声 汉语（河南话） vixk xiaokun
    // 13 小强 青年男声 汉语（湖南话） vixqa xiaoqiang
    // 14 小莹 青年女声 汉语（陕西话） vixying
    // 15 小新 童年男声 汉语（普通话） vixx xiaoxin
    // 16 楠楠 童年女声 汉语（普通话） vinn nannan
    // 17 老孙 老年男声 汉语（普通话）
    private String[] voiceName = {"xiaoyan", "xiaoyu", "catherine", "henry",
            "vimary", "vixy", "xiaoqi", "vixf", "xiaomei", "xiaolin",
            "xiaorong", "xiaoqian", "xiaokun", "xiaoqiang", "vixying",
            "xiaoxin", "nannan", "vils"};

    public AudioUtils() {

    }

    /**
     * 单例
     *
     * @return
     */
    public static AudioUtils getInstance() {
        if (audioUtils == null) {
            synchronized (AudioUtils.class) {
                if (audioUtils == null) {
                    audioUtils = new AudioUtils();
                }
            }
        }
        return audioUtils;
    }

    private InitListener mInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            Log.d("mySynthesiezer:", "InitListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                // showTip("初始化失败,错误码：" + code);
                Toast.makeText(context, "初始化失败,错误码：" + code, Toast.LENGTH_SHORT).show();
            } else {
                // 初始化成功，之后可以调用startSpeaking方法
                // 注：有的开发者在onCreate方法中创建完合成对象之后马上就调用startSpeaking进行合成，
                // 正确的做法是将onCreate中的startSpeaking调用移至这里
            }
        }
    };

    /**
     * 初始化语音配置
     */
    public void init(Context context) {
        //处理语音合成关键类
        mSpeechSynthesizer = SpeechSynthesizer.createSynthesizer(context, mInitListener);
        //设置发言人
//        mSpeechSynthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoxin");
        mSpeechSynthesizer.setParameter(SpeechConstant.VOICE_NAME, voiceName[6]);
        //设置音调
        mSpeechSynthesizer.setParameter(SpeechConstant.PITCH, "50");
        //设置音量
        mSpeechSynthesizer.setParameter(SpeechConstant.VOLUME, "50");
    }

    /**
     * 根据传入的文本转换音频并播放
     */
    public void speekText(String content) {

        int code = mSpeechSynthesizer.startSpeaking(content, new SynthesizerListener() {

            @Override
            public void onSpeakBegin() {

            }

            @Override
            public void onBufferProgress(int i, int i1, int i2, String s) {

            }

            @Override
            public void onSpeakPaused() {

            }

            @Override
            public void onSpeakResumed() {

            }

            @Override
            public void onSpeakProgress(int i, int i1, int i2) {

            }

            @Override
            public void onCompleted(SpeechError speechError) {

            }

            @Override
            public void onEvent(int i, int i1, int i2, Bundle bundle) {

            }
        });

    }

    /**
     * 停止播放语音
     */
    public void stopText() {
        mSpeechSynthesizer.stopSpeaking();
        mSpeechSynthesizer.destroy();// 退出时释放连接
    }

}
