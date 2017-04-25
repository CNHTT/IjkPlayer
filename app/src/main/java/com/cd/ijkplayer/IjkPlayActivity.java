package com.cd.ijkplayer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.cd.chenplayview.media.IjkPlayerView;
import com.cd.chenplayview.utils.SoftInputUtils;

public class IjkPlayActivity extends AppCompatActivity {

    private static final String VIDEO_URL = "http://220.170.49.114/3/a/j/d/r/ajdrtbzoyethqqvviudpywfcpukmbl/he.yinyuetai.com/81DD015B9016DEFE602A97283732E474.mp4?sc\\u003d89e3622f655575bb\\u0026br\\u003d3105\\u0026vid\\u003d2845045\\u0026aid\\u003d42550\\u0026area\\u003dHT\\u0026vst\\u003d0";
    private static final String VIDEO_HD_URL = "http://220.170.49.106/11/r/m/i/r/rmirlnsdrabmimodsmkjwkskzfzxis/hc.yinyuetai.com/F66E0140561CC23BD24D5B773275F976.flv?sc\\u003d03e6c7dd0a1066df\\u0026br\\u003d780\\u0026vid\\u003d731710\\u0026aid\\u003d7524\\u0026area\\u003dACG\\u0026vst\\u003d0";
    private static final String IMAGE_URL = "http://vimg2.ws.126.net/image/snapshot/2016/11/I/M/VC62HMUIM.jpg";

    Toolbar mToolbar;
    private IjkPlayerView mPlayerView;
    private View mEtLayout;
    private EditText mEditText;
    private Button mIvSend;
    private boolean mIsFocus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ijk_play);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mPlayerView = (IjkPlayerView) findViewById(R.id.player_view);
        mEtLayout = findViewById(R.id.ll_layout);
        mEditText = (EditText) findViewById(R.id.et_content);
        mIvSend = (Button) findViewById(R.id.btn_send);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Video Player");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(this).load(IMAGE_URL).fitCenter().into(mPlayerView.mPlayerThumb);
        mPlayerView.init()
                .setTitle("这是个跑马灯TextView，标题要足够长才会跑。-(゜ -゜)つロ 乾杯~")
                .setSkipTip(1000*60*1)
                .enableDanmaku()
                .setDanmakuSource(getResources().openRawResource(R.raw.bili))
                .setVideoSource(null, VIDEO_URL, VIDEO_HD_URL, null, null)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH);

        mIvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayerView.sendDanmaku(mEditText.getText().toString(), false);
                mEditText.setText("");
                _closeSoftInput();
            }
        });
        mEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean isFocus) {
                if (isFocus) {
                    mPlayerView.editVideo();
                }
                mIsFocus = isFocus;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayerView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlayerView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayerView.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mPlayerView.configurationChanged(newConfig);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mPlayerView.handleVolumeKey(keyCode)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (mPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (_isHideSoftInput(view, (int) ev.getX(), (int) ev.getY())) {
            _closeSoftInput();
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    private void _closeSoftInput() {
        mEditText.clearFocus();
        SoftInputUtils.closeSoftInput(this);
        mPlayerView.recoverFromEditVideo();
    }

    private boolean _isHideSoftInput(View view, int x, int y) {
        if (view == null || !(view instanceof EditText) || !mIsFocus) {
            return false;
        }
        return x < mEtLayout.getLeft() ||
                x > mEtLayout.getRight() ||
                y < mEtLayout.getTop();
    }
}
