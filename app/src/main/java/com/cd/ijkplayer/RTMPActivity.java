package com.cd.ijkplayer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.cd.chenplayview.media.IjkPlayerView;

public class RTMPActivity extends AppCompatActivity {

    private IjkPlayerView mPlayerView;
    private Context context;
    private View rootView;
    private String VIDEO_URL = "rtmp://live.hkstv.hk.lxdns.com/live/hks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rtmp);
        mPlayerView = new IjkPlayerView(this);
        setContentView(mPlayerView);
        mPlayerView.init()
                .alwaysFullScreen()
                .enableOrientation()
                .setVideoPath(VIDEO_URL)
//                .enableDanmaku()
//                .setDanmakuSource(getResources().openRawResource(R.raw.bili))
                .setTitle("香港卫视")
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