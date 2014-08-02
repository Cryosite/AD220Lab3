package com.mti.cryosite.ad220lab3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class StartActivity extends Activity implements View.OnClickListener {
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        btnContinue = (Button) findViewById(R.id.btnStartContinue);
        btnContinue.setOnClickListener(this);
    }//onCreate(Bundle savedInstanceState)

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStartContinue) {
            Intent openMain = new Intent(StartActivity.this, MapsActivity.class);

            Bundle myBundle = new Bundle();
            openMain.putExtras(myBundle);

            StartActivity.this.startActivity(openMain);
        }//endif - (v.getId() == R.id.btnStartContinue)
    }//onClick(View v)
}//class
