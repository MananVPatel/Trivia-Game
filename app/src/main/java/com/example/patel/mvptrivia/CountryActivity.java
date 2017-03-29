package com.example.patel.mvptrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        TextView textV = (TextView) findViewById(R.id.cTV);
        textV.setMovementMethod(new ScrollingMovementMethod());


    }
}
