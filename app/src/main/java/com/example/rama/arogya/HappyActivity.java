package com.example.rama.arogya;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class HappyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy);
        setTitle("Happy");
        ImageView img_rage = (ImageView)findViewById(R.id.imageView_disappontment);
        img_rage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(DepressedActivity.this, "We are sorry to know that you are Sad", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HappyActivity.this,HappyQuestionnaireActivity.class);
                startActivity(i);
            }
        });

        ImageView img_frustration = (ImageView)findViewById(R.id.imageView_frustration);
        img_frustration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(DepressedActivity.this, "We are sorry to know that you are Sad", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HappyActivity.this,HappyQuestionnaireActivity.class);
                startActivity(i);
            }
        });

        ImageView img_envy = (ImageView)findViewById(R.id.imageView_envy);
        img_envy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(DepressedActivity.this, "We are sorry to know that you are Sad", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HappyActivity.this,HappyQuestionnaireActivity.class);
                startActivity(i);
            }
        });
    }


}
