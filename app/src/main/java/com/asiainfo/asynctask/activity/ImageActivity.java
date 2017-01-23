package com.asiainfo.asynctask.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.asiainfo.asynctask.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by MicroKibaco on 1/23/17.
 */

public class ImageActivity extends Activity {

    private ImageView mLoadImg;

    private ProgressBar mLoadProgress;

    private static final String LOAD_IMG_URL = "http://n1.itc.cn/img8/wb/recom/2016/05/17/146346310061044369.JPEG";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        initView();

        initDatas();
    }

    private void initDatas() {

        //设置传进来的参数
        AsyncTaskUtils mTask = new AsyncTaskUtils();
        mTask.execute(LOAD_IMG_URL);

    }

    private void initView() {

        mLoadImg = (ImageView) findViewById(R.id.Image_img);

        mLoadProgress = (ProgressBar) findViewById(R.id.Image_progress);

        Toast.makeText(this,"异步加载网络图片",Toast.LENGTH_LONG).show();
    }


    /**
     * <p> onPreExecute-->doInBackground-->onPostExecute </p>
     */

    public class AsyncTaskUtils extends AsyncTask<String, Void, Bitmap> {


        @Override
        protected Bitmap doInBackground(String... params) {
            //获取传进来的参数

            String url = params[0];

            Bitmap bitmap = null;

            URLConnection urlconn;

            InputStream is;

            try {

                urlconn = new URL(url).openConnection();

                is = urlconn.getInputStream();

                BufferedInputStream bis = new BufferedInputStream(is);

                Thread.sleep(3000);

                //通过decodeStream方法解析输入流

                bitmap = BitmapFactory.decodeStream(bis);

                is.close();

                bis.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //将bitmap作为返回值返回
            return bitmap;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

            mLoadProgress.setVisibility(View.VISIBLE);
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {

            super.onPostExecute(bitmap);

            mLoadImg.setImageBitmap(bitmap);

            mLoadProgress.setVisibility(View.GONE);

        }

        @Override
        protected void onProgressUpdate(Void... values) {

            super.onProgressUpdate(values);
        }

    }


}
