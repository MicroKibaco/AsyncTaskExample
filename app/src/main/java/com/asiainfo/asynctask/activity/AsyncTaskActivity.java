package com.asiainfo.asynctask.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.asiainfo.asynctask.R;

/**
 *
 */
public class AsyncTaskActivity extends Activity implements View.OnClickListener {

    private Button mLoadImgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        initView();
        initListener();
        initDatas();

    }

    private void initView() {

        mLoadImgBtn = (Button) findViewById(R.id.load_img);

    }

    private void initListener() {

        mLoadImgBtn.setOnClickListener(this);
    }


    private void initDatas() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.load_img:

                startActivity(new Intent(AsyncTaskActivity.this, ImageActivity.class));

                break;

            default:
                break;

        }
    }
}
