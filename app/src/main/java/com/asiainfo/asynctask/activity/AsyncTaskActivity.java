package com.asiainfo.asynctask.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.asiainfo.asynctask.R;

/**
 *剖析AsyncTask异步加载机制
 */
public class AsyncTaskActivity extends Activity implements View.OnClickListener {

    private Button mLoadImgBtn;
    private Button mTestProgressBarBtn;

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
        mTestProgressBarBtn = (Button) findViewById(R.id.test_progressBar);

    }

    private void initListener() {

        mLoadImgBtn.setOnClickListener(this);
        mTestProgressBarBtn.setOnClickListener(this);
    }


    private void initDatas() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.load_img:

                startActivity(new Intent(AsyncTaskActivity.this, ImageActivity.class));

                break;

            case R.id.test_progressBar:

                startActivity(new Intent(AsyncTaskActivity.this, ProgressTestActivity.class));

                break;

            default:
                break;

        }
    }
}
