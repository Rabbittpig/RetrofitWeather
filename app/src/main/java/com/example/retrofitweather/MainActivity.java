package com.example.retrofitweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitweather.HttpUtils;
import com.example.retrofitweather.R;

public class MainActivity extends AppCompatActivity {

    private TextView tvGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvGet = findViewById(R.id.tv_get);
        tvGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpUtils.doGetAsyn("http://api.jirengu.com/getWeather.php", new HttpUtils.CallBack() {
                    @Override
                    public void onRequestComplete(String result) {
                        setView(result);
                    }
                });
            }
        });
    }

    private void setView(final String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
                tvGet.setText(result);
            }
        });
    }
}