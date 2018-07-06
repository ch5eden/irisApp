package com.rollco.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class ShodanExploreActivity extends AppCompatActivity {
    private String htmlPageUrl = "https://www.shodan.io/explore";
    private TextView textviewHtmlDocument;
    private String htmlContentInStringFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shodan_explore);
        textviewHtmlDocument = (TextView)findViewById(R.id.tvShodanExplore);
        textviewHtmlDocument.setMovementMethod(new ScrollingMovementMethod());
        Button onButton2Clicked = (Button)findViewById(R.id.button2);
        onButton2Clicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                jsoupAsyncTask.execute();
            }
        });
    }

    public void onBackHomeButtonClicked(View v){
        Toast.makeText(getApplicationContext(), "홈으로 돌아갑니다.", Toast.LENGTH_LONG).show();
        finish();
    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect(htmlPageUrl).get();
                Elements links = doc.select("a[href]");

                for (Element link : links) {
                    htmlContentInStringFormat += (link.attr("abs:href")
                            + "("+link.text().trim() + ")\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            textviewHtmlDocument.setText(htmlContentInStringFormat);
        }
    }


}
