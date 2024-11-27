package com.jah.gestion_provincias3;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WikiWebView extends AppCompatActivity {

    WebView wvView;
    int posicion;
    Intent data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_web_view);
        wvView = findViewById(R.id.wvWiki);

        data = getIntent();
        posicion = data.getIntExtra("posicion", 0);
        String url = "https://es.wikipedia.org/wiki/" + GestionProvincia.getArrProvincias().get(posicion).getNombreProv() ;
        wvView.setWebViewClient(new WebViewClient());
        wvView.loadUrl(url);
    }
}