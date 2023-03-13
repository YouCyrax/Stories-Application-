package com.younes_seghirou.sindebad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class WebHtml extends AppCompatActivity {
    WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_html);
        webView1 = findViewById(R.id.webView);
        Intent intent = getIntent();
        int page = intent.getExtras().getInt("page");
        page++;
        webView1.loadUrl("file:///android_asset/html/" + page + ".html");
    }
}