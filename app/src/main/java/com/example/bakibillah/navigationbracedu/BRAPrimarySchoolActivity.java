package com.example.bakibillah.navigationbracedu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class BRAPrimarySchoolActivity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braprimary_school);

        setUpUiAtaGlance();
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setUpUiAtaGlance() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_at_a_glance);

    }
}
