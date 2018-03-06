package com.example.bakibillah.navigationbracedu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.barteksc.pdfviewer.PDFView;

public class FactSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact_sheet);
        //String s = "http://www.brac.net/education";

        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        pdfView.fromAsset("education.pdf").load();

        //WebView browser = (WebView)findViewById(R.id.webv);
        //browser.setWebChromeClient(new WebChromeClient());
        //browser.setWebViewClient(new WebViewClient());
        //browser.loadUrl("http://www.brac.net/education");

//        browser.getSettings().setJavaScriptEnabled(true);
//        browser.loadUrl("https://docs.google.com/viewer?url=https://www.brac.net/sites/default/files/factsheet/june15/education.pdf");
    }
}
