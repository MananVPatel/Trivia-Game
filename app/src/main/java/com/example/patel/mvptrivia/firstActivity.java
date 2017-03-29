package com.example.patel.mvptrivia;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class firstActivity extends Activity {

    Intent previousAct;
    TextView txt;
    String coi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        txt = (TextView) findViewById(R.id.tv);
        String str = getIntent().getStringExtra("name");
        txt.setText(str);
        previousAct = new Intent();

        ImageView iv = (ImageView) findViewById(R.id.iv);
        TextView printTV = (TextView) findViewById(R.id.tvp);

        if(txt.getText().equals("Keystone State")){
            iv.setImageResource(R.mipmap.ks);
            printTV.setText("Correct!, The state of Pennsylvania is nicknamed Keystone State!");
        }
        else if(txt.getText().equals("Beehive State")){
            iv.setImageResource(R.mipmap.be);
            printTV.setText("Incorrect!, The state of Utah is nicknamed the Beehive State!");
        }
        else if(txt.getText().equals("Beaver State")){
            iv.setImageResource(R.mipmap.bea);
            printTV.setText("Incorrect!, The state of Oregon is nicknamed the Beaver State!");
        }
        else if(txt.getText().equals("Mountain State")){
            iv.setImageResource(R.mipmap.ms);
            printTV.setText("Incorrect!, The state of West Virginia is nicknamed the Mountain State!");
        }
        else if(txt.getText().equals("Granite State")){
            iv.setImageResource(R.mipmap.gs);
            printTV.setText("Incorrect!, The state of New Hampshire is nicknamed the Granite State!");
        }
        else if(txt.getText().equals("Buckeye State")){
            iv.setImageResource(R.mipmap.bs);
            printTV.setText("Incorrect!, The state of Ohio is nicknamed the Buckeye State!");
        }

    }

    public void goTo(View view){

        coi = "Incorrect";
        if(txt.getText().equals("Keystone State")) {
            coi = "Correct";
        }
        previousAct.putExtra("ci", coi);
        setResult(Activity.RESULT_OK,previousAct);
        finish();

    }
}
