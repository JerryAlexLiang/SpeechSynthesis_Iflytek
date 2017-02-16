package com.liangyang.speechsynthesis_iflytek;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * 科大讯飞-在线语音合成技术集成Demo
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mContent;
    private ImageButton mSpeechBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        mContent = (EditText) findViewById(R.id.edit_content);
        mSpeechBtn = (ImageButton) findViewById(R.id.icon_btn);
        //播放语音
        mSpeechBtn.setOnClickListener(this);

    }

    /**
     * 播放语音
     * @param view
     */
    @Override
    public void onClick(View view) {
        String content = mContent.getText().toString().trim();
        if (!TextUtils.isEmpty(content)) {
            AudioUtils.getInstance().speekText(content);
        }
    }
}
