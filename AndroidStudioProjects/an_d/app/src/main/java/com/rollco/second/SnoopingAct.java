package com.rollco.second;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class SnoopingAct extends MainActivity{
    VideoView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //스트리밍 주소!!!
        String uri = "rtsp://98.163.60.67/live/ch00_0";

        v = findViewById(R.id.video);
        v.setVideoURI(Uri.parse(uri));

        v.requestFocus();
        v.start();
    }

    public void sOnClose(View v){
        //액티비티 닫기
        finish();
    }
}
