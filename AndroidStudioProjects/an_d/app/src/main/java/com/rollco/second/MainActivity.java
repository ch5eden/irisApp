package com.rollco.second;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //web page 버튼
    public void mOnPopupClick(View v){
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, PopupWebpage.class);
        intent.putExtra("data", "web page");
        startActivityForResult(intent, 1);
    }

    //snooping 버튼
    public void sOnClick(View v){
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent3 = new Intent(this, SnoopingAct.class);
        startActivity(intent3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        txtResult = findViewById(R.id.txtResult);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //데이터 받기
                String result = data.getStringExtra("result");
                txtResult.setText(result);
            }
        }
    }


    //  출처: http://ghj1001020.tistory.com/9 [혁준 블로그]
}

