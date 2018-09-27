package com.zxyoyo.apk.testfacelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zxyoyo.apk.facelibrary.FaceTool;

public class MainActivity extends AppCompatActivity {


    String appid = "4kJeDdya4nBo6jZVp3GXkXaeEDBeRa3CPzd1u7Nzs5fv";
    String ft_key = "48kjwtUjPiExKWEjSBWLbqKfDdErk8bb6VVkMHn4EEvt";
    String fd_key = "48kjwtUjPiExKWEjSBWLbqKnP2W644qbfTmGfTXm4LTo";
    String fr_key = "48kjwtUjPiExKWEjSBWLbqLH2dYms5JkmszFtXC7esNw";
    String age_key = "48kjwtUjPiExKWEjSBWLbqLXMS56eETBjkhWXeeZcxLy";
    String gender_key = "48kjwtUjPiExKWEjSBWLbqLeWqLHKytwrA6YAg47HVmt";
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
