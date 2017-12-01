package com.scy.rock.energyview_master;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,Handler.Callback{

    private EnergyView energy;
    private  Handler handler = new Handler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        energy = ((EnergyView) findViewById(R.id.energy));
        energy.setMaxProgress(100);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                energy.setEmptyVisibility(View.GONE);
                break;
            case R.id.btn2:
                handler.sendEmptyMessage(0);
                break;
            case R.id.btn3:
                energy.clearProgress();
                energy.setEmptyVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                energy.setProgress(energy.getCurrentProgress()+3);
                if(energy.getCurrentProgress()<100) {
                    handler.sendEmptyMessageDelayed(0,300);
                }
                break;
        }
        return false;
    }
}
