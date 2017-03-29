package com.example.patel.mvptrivia;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    ListView gListView;
    private String[] Values = {
            "Countries",
            "States",
            "Trivia Question",
            "",
            "",
            "",
            "",
            "",
            "",
            ""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list);

        gListView = (ListView) findViewById(R.id.geographyListView);

        ListAdapter gCityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Values);
        gListView.setAdapter(gCityAdapter);

        gListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             final TextView mTextView = (TextView) view;
                switch (i){
                    case 0:
                        Intent newActivity0 = new Intent(view.getContext(), CountryActivity.class);
                        startActivity(newActivity0);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(view.getContext(), StateActivity.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(view.getContext(), CityActivity.class);
                        startActivity(newActivity2);
                        break;
                    default:
                }
            }
        });
    }
}
