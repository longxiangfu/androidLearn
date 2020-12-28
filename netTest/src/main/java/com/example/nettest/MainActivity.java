package com.example.nettest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 *  相应用户的操作的是主线程，或者叫UI线程
 *  网络相关的操作不能放到主线程中操作，网络比较耗时，造成ui卡顿，用户体验不好
 *  在主线程操作时报NetworkOnMainThreadException
 *  网络操作一般放到子线程中
 */
public class MainActivity extends AppCompatActivity {
    private static final String SPLIT = " ";
    OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //WebView演示
//        WebView webView = findViewById(R.id.wv);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl("https://www.baidu.com");

        /**
         * http get请求-返回json
         */
        findViewById(R.id.btn_http).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread netOP = new Thread(() -> {
                    try {
                        URL url = new URL("http://yeyunxiaopan.xyz/api/hotnews.json");
                        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                        httpURLConnection.setConnectTimeout(8000);
                        httpURLConnection.setReadTimeout(8000);
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        final StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null){
                            response.append(line);
                        }
                        Log.i("MainActivity", response.toString());

                        //解析返回结果,即解析json
                        JSONObject jsonObject = new JSONObject(response.toString());
                        JSONArray hotnewsList = jsonObject.getJSONArray("hotnews");
                        for (int i = 0, length = hotnewsList.length(); i < length; i++) {
                            JSONObject hotnews = hotnewsList.getJSONObject(i);
                            String news = hotnews.getString("news");
                            String img = hotnews.getString("img");
                            int hot = hotnews.getInt("hot");
                            int share = hotnews.getInt("share");
                            Log.i("结果", news + SPLIT + img + SPLIT + hot + SPLIT + share);
                        }

                        //将返回的结果展示在页面中。利用主线程操作，否则报错,因为用户可能也在操作页面也就是主线程，容易冲突
                        runOnUiThread(() -> {
                            TextView tv = findViewById(R.id.tv_http);
                            tv.setText(response.toString());
                        });

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                });
                netOP.start();

            }
        });


        /**
         * http get-返回图片
         */
        findViewById(R.id.btn_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread netOP = new Thread(() -> {
                    try {
                        URL url = new URL("http://yeyunxiaopan.xyz/api/img/img2.png");
                        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                        httpURLConnection.setConnectTimeout(8000);
                        httpURLConnection.setReadTimeout(8000);
                        InputStream inputStream = httpURLConnection.getInputStream();
                        final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                        //将返回的结果展示在页面中。利用主线程操作，否则报错,因为用户可能也在操作页面也就是主线程，容易冲突
                        runOnUiThread(() -> {
                            ImageView imageView = findViewById(R.id.iv_img);
                            imageView.setImageBitmap(bitmap);
                        });

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                netOP.start();

            }
        });


        /**
         * http post
         */
        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread netOP = new Thread(() -> {
                    try {
                        URL url = new URL("http://192.168.1.13:8081/eventNotify/order/testAndroid");
                        Order order = new Order();
                        order.setStatus(1);
                        Gson gson = new Gson();
                        String orderJson = gson.toJson(order);
                        RequestBody body = RequestBody.create(JSON, orderJson);
                        Request request = new Request.Builder()
                                .url(url)
                                .post(body)
                                .build();

                        client.newCall(request).execute();

//                        Response response = client.newCall(request).execute();
//                        String result = response.body().string();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                netOP.start();

            }
        });


    }
}