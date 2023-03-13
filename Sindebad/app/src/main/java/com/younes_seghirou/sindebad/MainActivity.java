package com.younes_seghirou.sindebad ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.younes_seghirou.sindebad.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textViewTitle);
        typeface = Typeface.createFromAsset(getAssets(), "font.ttf");

        String [] item = getResources().getStringArray(R.array.index);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.row_item, R.id.textViewItem, item);
        listView.setAdapter(arrayAdapter);
        textView.setTypeface(typeface);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, WebHtml.class);
                intent.putExtra("page", position);
                startActivity(intent);
            }
        });
    }

    public void onClose(View view) {
        finish();
    }

    public void onMail(View view) {
        String text = "Hello, Your application is very helpful";
        Intent sendEmail = new Intent(Intent.ACTION_SEND);
        sendEmail.setData(Uri.parse("mailto:"));
        sendEmail.setType("message/rfc882");
        sendEmail.putExtra(Intent.EXTRA_EMAIL, "seghirou.younes@gmail.com");
        sendEmail.putExtra(Intent.EXTRA_SUBJECT, "تطبيق حكايات السندباد");
        sendEmail.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(sendEmail);

    }

     /*
    public void onMore(View view) {
        Intent  intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id"));
        startActivity(intent);
    }

    public void onShare(View view) {

        String textShare = "تطبيق حكايات السندباد البحري";
        String shareLink = "https://play.google.com/store/apps/details?id=com.younes_seghirou.sindebad";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, textShare + "\n"+ shareLink);
        startActivity(intent);

    }
     */
}