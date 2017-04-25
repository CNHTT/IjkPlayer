package com.cd.ijkplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.bumptech.glide.Glide;
import com.cd.chenplayview.media.IjkPlayerView;

/**
 * 项目名称：IjKPlayer.
 * 创建人： CT.
 * 创建时间: 2017/4/25.
 * GitHub:https://github.com/CNHTT
 */
public class IjkFullscreenActivity extends AppCompatActivity {

    private static final String VIDEO_URL = "http://183.60.197.34/15/u/m/q/u/umquwojjphgfjcwqefrbovhvxshmjx/he.yinyuetai.com/A2A7014E2376E424A1C54F2130B00400.flv?sc\\u003d40d8a19933632637\\u0026br\\u003d2765\\u0026vid\\u003d2315441\\u0026aid\\u003d26759\\u0026area\\u003dML\\u0026vst\\u003d0";
    private static final String IMAGE_URL = "http://vimg3.ws.126.net/image/snapshot/2016/11/C/T/VC628QHCT.jpg";
    IjkPlayerView mPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlayerView = new IjkPlayerView(this);
        setContentView(mPlayerView);
        Glide.with(this).load(IMAGE_URL).fitCenter().into(mPlayerView.mPlayerThumb);
        mPlayerView.init()
                .alwaysFullScreen()
                .enableOrientation()
                .setVideoPath(VIDEO_URL)
//                .enableDanmaku()
//                .setDanmakuSource(getResources().openRawResource(R.raw.bili))
                .setTitle("这是个跑马灯TextView，标题要足够长才会跑。-(゜ -゜)つロ 乾杯~")
                .start();

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
}

