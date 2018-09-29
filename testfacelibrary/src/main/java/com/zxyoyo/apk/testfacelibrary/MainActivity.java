package com.zxyoyo.apk.testfacelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zxyoyo.apk.facelibrary.FaceTool;

public class MainActivity extends AppCompatActivity {


    String appid = "";
    String ft_key = "";
    String fd_key = "";
    String fr_key = "";
    String age_key = "";
    String gender_key = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FaceTool.getInstance().initIdAndKeys(this,appid,ft_key,fd_key,fr_key,age_key,gender_key);

    }


    public void tv1(View view){
        FaceTool.getInstance().register(this,"hhh");
    }


    public void tv2(View view){
        FaceTool.getInstance().recorgnize(this,FaceTool.REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == FaceTool.REQ_CODE){
            String name = data.getStringExtra(FaceTool.REQ_NAME);
            boolean success = data.getBooleanExtra(FaceTool.REQ_SUCCESS, false);
        }
    }
}
