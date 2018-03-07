package com.example.bakibillah.navigationbracedu;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.borjabravo.readmoretextview.ReadMoreTextView;

public class WorkSecSchoolActivity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    ReadMoreTextView rtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_sec_school);

        setUpUiAtaGlance();
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Typeface customfont = Typeface.createFromAsset(getAssets(),"fonts/arial.ttf");
        rtv.setTypeface(customfont);

        //rtv.setText(Html.fromHtml(getString(R.string.bpps_details)));
    }

    private void setUpUiAtaGlance() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_at_a_glance);
        rtv = (ReadMoreTextView)findViewById(R.id.readMoreTextView);

    }
}
