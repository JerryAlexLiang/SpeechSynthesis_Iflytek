package com.liangyang.speechsynthesis_iflytek;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

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
        }
    };

    /**
     * 初始化语音配置
     */
    public void init(Context context) {
        //处理语音合成关键类
        mSpeechSynthesizer = SpeechSynthesizer.createSynthesizer(context, mInitListener);
        //设置发言人
        mSpeechSynthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoxin");
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


}
