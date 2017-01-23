package com.asiainfo.asynctask.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


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

             //通过decodeStream方法解析输入流

             bitmap = BitmapFactory.decodeStream(bis);

             is.close();

             bis.close();

         } catch (IOException e) {
            e.printStackTrace();
        }
        //将bitmap作为返回值返回
        return bitmap;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
