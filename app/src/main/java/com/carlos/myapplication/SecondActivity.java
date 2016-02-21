package com.carlos.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by carlos on 15/12/8.
 */
public class SecondActivity extends Activity implements View.OnClickListener {
    private Button button_one, button_two;
    private MianModel mianModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        button_one = (Button) findViewById(R.id.button_one);
        button_two = (Button) findViewById(R.id.button_two);
        button_one.setOnClickListener(this);
        button_two.setOnClickListener(this);
        mianModel = (MianModel) StaticTool.hashMap.get(SecondActivity.class.getName());
        StaticTool.hashMap.remove(SecondActivity.class.getName());
        ((TextView)findViewById(R.id.text)).setText(mianModel.string);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_one:
                mianModel.string = "任务已经完成";
                break;
            case R.id.button_two:
                mianModel.string = "任务失败";
                break;
        }
        this.finish();
    }
}
