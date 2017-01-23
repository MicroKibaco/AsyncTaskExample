package com.asiainfo.asynctask.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.asiainfo.asynctask.R;

/**
 * 模拟异步加载进度条
 */

public class ProgressTestActivity extends Activity {

    private ProgressBar mTestProgressBar;

    private AsyncTaskUtils mMyAsyncTaskUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_progressbar);

        initView();
        initListenser();
        initDatas();
    }

    private void initView() {

        mTestProgressBar = (ProgressBar) findViewById(R.id.test_progressbar);

        mMyAsyncTaskUtils = new AsyncTaskUtils();

        mMyAsyncTaskUtils.execute();

    }


    private void initListenser() {
    }

    private void initDatas() {
    }



    public class AsyncTaskUtils extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {

            /**
             * 模拟进度的更新
             */

            for (int i = 0; i < 100; i++) {

                if (isCancelled()){

                    break;
                }

               publishProgress(i);

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return null;


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            /**
             * 获取进度的更新值
             */

            if (isCancelled()){

                return;
            }

            mTestProgressBar.setProgress(values[0]);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mMyAsyncTaskUtils!=null&&mMyAsyncTaskUtils.getStatus()==AsyncTask.Status.RUNNING){


            //cancle只是将对应得AsyTask标记为cancle状态,并不是真正的取消进程
            mMyAsyncTaskUtils.cancel(true);



        }

    }
}
