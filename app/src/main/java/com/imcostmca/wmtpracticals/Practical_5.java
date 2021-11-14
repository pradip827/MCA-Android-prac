package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class Practical_5 extends AppCompatActivity {

    WebView webView;
    TextView txtNoInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical5);

        webView = findViewById(R.id.webView);
        txtNoInternet = findViewById(R.id.txtNoInternet);

        webView.setWebViewClient(new MyBrowser());

        Toast.makeText(this, "Connection", Toast.LENGTH_SHORT).show();
        txtNoInternet.setVisibility(View.GONE);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("https://www.amazon.in/");

        if (isConnected()) {

        } else {
            Toast.makeText(this, "No Connection", Toast.LENGTH_SHORT).show();
            webView.setVisibility(View.GONE);
            txtNoInternet.setVisibility(View.VISIBLE);
        }
    }

    private boolean isConnected() {
        boolean is_wifi = false, is_mobileData = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
        for (NetworkInfo info : networkInfo) {
            if (info.getTypeName().equalsIgnoreCase("WIFI")) {
                if (info.isConnected()) {
                    is_wifi = true;
                }
            }
            if (info.getTypeName().equalsIgnoreCase("MOBILE DATA")) {
                if (info.isConnected()) {
                    is_mobileData = true;
                }
            }
        }
        return is_wifi || is_mobileData;
    }

    private class MyBrowser extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}