package com.commax.broadcastsendertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.commax.test.broadcast.ACTION");
        //보안 이슈로 android 3.1. 이후에는 Application stopped 상태에서는 기본적으로 브로드캐스트를
        //받지 못함. 기본적으로 앱을 한 번 실행해야 함.
        //Application stopped 상태에서도 브로드캐스트를 받으려면 아래 플래그를 추가해야 함.
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }
}
