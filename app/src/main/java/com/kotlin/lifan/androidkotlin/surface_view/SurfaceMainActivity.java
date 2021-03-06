package com.kotlin.lifan.androidkotlin.surface_view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kotlin.lifan.androidkotlin.base.BaseActivity;
import com.kotlin.lifan.androidkotlin.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SurfaceMainActivity extends BaseActivity {
    public static void start(Context context){
        context.startActivity(new Intent(context,SurfaceMainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_sv_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button0, R.id.button1, R.id.button2, R.id.button3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button0:
                startActivity(new Intent(this, MyViewActivity.class));
                break;
            case R.id.button1:
                startActivity(new Intent(this, BoardActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, VideoActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, GameActivity.class));
                break;
        }
    }
}
