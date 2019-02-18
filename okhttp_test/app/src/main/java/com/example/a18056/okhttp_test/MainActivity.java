package com.example.a18056.okhttp_test;

import android.content.Context;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://wwww.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = okHttpClient.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    ToastUtils util = new ToastUtils();
                    util.show(getApplicationContext(),response.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public class ToastUtils {
        Toast toast = null;
        public  void show(Context context, String text) {
            try {
                if(toast!=null){
                    toast.setText(text);
                }else{
                    toast= Toast.makeText(context, text, Toast.LENGTH_SHORT);
                }
                toast.show();
            } catch (Exception e) {
                //解决在子线程中调用Toast的异常情况处理
                Looper.prepare();
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }
    }
}
