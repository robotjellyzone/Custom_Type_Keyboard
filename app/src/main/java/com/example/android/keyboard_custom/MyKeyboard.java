package com.example.android.keyboard_custom;

import android.app.Service;
import android.content.Intent;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Switch;

public class MyKeyboard extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView kv;
    private Keyboard keyboard;


    @android.annotation.SuppressLint("InflateParams")@Override
    public View onCreateInputView() {

        kv = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard,null);
        keyboard = new Keyboard(this,R.xml.qwerty);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {

        InputConnection ic = getCurrentInputConnection();
        playClick(primaryCode);
        char code = (char)primaryCode;
        code = Character.toUpperCase(code);
        ic.commitText(String.valueOf(code),1);

    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }


    private void playClick(int primaryCode) {

        AudioManager am = (AudioManager)getSystemService(AUDIO_SERVICE);
        am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);

        }
}

