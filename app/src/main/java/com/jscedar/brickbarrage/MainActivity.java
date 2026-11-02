package com.jscedar.brickbarrage;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        web = new WebView(this);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        web.setWebViewClient(new WebViewClient());
        web.setBackgroundColor(0xFF0B0D18);
        web.setFocusable(true);
        web.setFocusableInTouchMode(true);
        web.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(web);

        web.loadUrl("file:///android_asset/index.html");
        web.requestFocus();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        int code = e.getKeyCode();
        // The remote's centre button arrives as DPAD_CENTER; the game listens for Enter.
        if (code == KeyEvent.KEYCODE_DPAD_CENTER) {
            return web.dispatchKeyEvent(new KeyEvent(e.getDownTime(), e.getEventTime(),
                    e.getAction(), KeyEvent.KEYCODE_ENTER, e.getRepeatCount()));
        }
        if (code == KeyEvent.KEYCODE_BACK) {
            if (e.getAction() == KeyEvent.ACTION_UP) finish();
            return true;
        }
        return super.dispatchKeyEvent(e);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (web != null) { web.onResume(); web.requestFocus(); }
    }

    @Override
    protected void onPause() {
        if (web != null) web.onPause();
        super.onPause();
    }
}
