package com.example.bakibillah.navigationbracedu;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    Intent intent;
    Button factsheet;
    SliderLayout sliderLayout;
    HashMap<String, String> Hash_file_maps;
    DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        setUpUIMain();
        setSupportActionBar(toolbar);
        factsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FactSheetActivity.class));

//                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
//                Uri uri = Uri.parse("https://www.brac.net/sites/default/files/factsheet/june15/education.pdf");
//                DownloadManager.Request request = new DownloadManager.Request(uri);
//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                Long reference = downloadManager.enqueue(request);
            }
        });
        toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,
                toolbar,R.string.open_drawer,R.string.close_drawer);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        Hash_file_maps = new HashMap<String ,String >();
        sliderLayout = (SliderLayout)findViewById(R.id.daimajia_slider_image);

        Hash_file_maps.put("Five ways we can futureproof education in Bangladesh","http://blog.brac.net/wp-content/uploads/2017/10/cover-photo1.jpg");
        Hash_file_maps.put("Children from one of the BRAC schools in Douladia Ghat","http://blog.brac.net/wp-content/uploads/2015/06/edited_MG_4498.jpg");
        Hash_file_maps.put("Pre-Primary and Primary Education","http://www.vercbd.org/images/shikhon-school.jpg");
        Hash_file_maps.put("Letting girls grow up to be who they want to be","http://blog.brac.net/wp-content/uploads/2014/10/10web.jpg");
        Hash_file_maps.put("A Nutritious Snack Makes School More Attractive","https://www.wfp.org/sites/default/files/imagecache/photo_collection_image/BGD_20130722_WFP_Kauser%20Haider_MG_1948.jpg");

        for (String name: Hash_file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView.description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra",name);
            sliderLayout.addSlider(textSliderView);
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.setCustomAnimation(new DescriptionAnimation());
            sliderLayout.setDuration(3000);
            sliderLayout.addOnPageChangeListener(this);
        }

    }

    private void setUpUIMain() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        factsheet = (Button)findViewById(R.id.fact_sheet);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_refresh) {
            Toast.makeText(MainActivity.this, "Refresh App", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.ataglance:
                intent = new Intent(MainActivity.this,AtGlanceActivity.class);
                startActivity(intent);
                break;

            case R.id.overview:
                intent = new Intent(MainActivity.this,OverViewActivity.class);
                startActivity(intent);
                break;

            case R.id.brac_pri_sc:
                intent = new Intent(MainActivity.this,BRAPrimarySchoolActivity.class);
                startActivity(intent);
                break;

            case R.id.brac_pre_pri_sc:
                intent = new Intent(MainActivity.this,BRAcPreprimaryActivity.class);
                startActivity(intent);
                break;

            case R.id.shishu_niketon:
                intent = new Intent(MainActivity.this,ShishuNiketonActivity.class);
                startActivity(intent);
                break;

            case R.id.edu_supp_pro:
                intent = new Intent(MainActivity.this,EducationSupportProActivity.class);
                startActivity(intent);
                break;

            case R.id.ear_child_dev:
                intent = new Intent(MainActivity.this,EarlyChildDev2Activity.class);
                startActivity(intent);
                break;

            case R.id.work_sec_school:
                intent = new Intent(MainActivity.this,WorkSecSchoolActivity.class);
                startActivity(intent);
                break;

            case R.id.ad_dev_pro:
                intent = new Intent(MainActivity.this,AdoleDevProActivity.class);
                startActivity(intent);
                break;

            case R.id.mul_comm_learn:
                intent = new Intent(MainActivity.this,MultipurposeComLearningActivity.class);
                startActivity(intent);
                break;

            case R.id.inclu_edu:
                intent = new Intent(MainActivity.this,InclusiveEducationActivity.class);
                startActivity(intent);
                break;

            case R.id.management_services:
                intent = new Intent(MainActivity.this,ManagementServicesActivity.class);
                startActivity(intent);
                break;

            case R.id.tbg:
                intent = new Intent(MainActivity.this,TBGActivity.class);
                startActivity(intent);
                break;

            case R.id.new_interventions:
                intent = new Intent(MainActivity.this,NewInterventionActivity.class);
                startActivity(intent);
                break;

            case R.id.organogram:
                intent = new Intent(MainActivity.this,OrganogramActivity.class);
                startActivity(intent);
                break;
            case R.id.beptimeline:
                intent = new Intent(MainActivity.this,BEPTimelineActivity.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onStop() {
        sliderLayout.startAutoCycle();
        super.onStop();
    }
}
