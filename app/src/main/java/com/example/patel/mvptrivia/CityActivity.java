package com.example.patel.mvptrivia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CityActivity extends AppCompatActivity {
    int i;
    TextView txt;
    int tryLimit;
    Button go;
    public static final int REQUEST_CODE = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null){
            i= savedInstanceState.getInt("CurrentNumber");
        }
        setContentView(R.layout.activity_city);
        i = 0;
        txt = (TextView) findViewById(R.id.ciTV);
        tryLimit = 3;

    }




    public void processRG(View view)
    {
        TextView tv1 = (TextView) findViewById(R.id.triesTV);
        go = (Button) findViewById(R.id.b1);
        if(i < tryLimit && !txt.getText().equals("Correct")) {
            i++;
            tv1.append(Integer.toString(i));

            RadioGroup radioG = (RadioGroup) findViewById(R.id.rg);
            int index = radioG.indexOfChild(findViewById(radioG.getCheckedRadioButtonId()));
            int selectedId = radioG.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(selectedId);

            Intent newActivity0 = new Intent(this, firstActivity.class);
            newActivity0.putExtra("name", radioButton.getText().toString());
            startActivityForResult(newActivity0,  REQUEST_CODE);
        }
        else
        {
            go.setEnabled(false);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                String str = data.getStringExtra("ci");
                txt.setText(str);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("CurrentNumber",i);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_settings1:
                Toast.makeText(this,"Background Color changed to Cyan",Toast.LENGTH_SHORT).show();
                getWindow().getDecorView().setBackgroundColor(Color.CYAN);
                return true;
            case R.id.action_settings2:
                Toast.makeText(this,"Background Color changed to Green",Toast.LENGTH_SHORT).show();
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                return true;
            case R.id.action_settings3:
                Toast.makeText(this,"Background Color changed to Red",Toast.LENGTH_SHORT).show();
                getWindow().getDecorView().setBackgroundColor(Color.RED);
                return true;
            case R.id.action_settingsA:
                Toast.makeText(this,"Retry Limit Changed to 2",Toast.LENGTH_SHORT).show();
                tryLimit = 2;
                return true;
            case R.id.action_settingsB:
                Toast.makeText(this,"Retry Limit Changed to 3",Toast.LENGTH_SHORT).show();
                tryLimit = 3;
                return true;
            case R.id.action_settingsC:
                Toast.makeText(this,"Retry Limit Changed to 4",Toast.LENGTH_SHORT).show();
                tryLimit = 4;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void goBack(View view){
        Intent newActivity0 = new Intent(view.getContext(), ListActivity.class);
        startActivity(newActivity0);
    }
}
