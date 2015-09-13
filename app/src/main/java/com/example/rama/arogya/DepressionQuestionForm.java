package com.example.rama.arogya;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;


public class DepressionQuestionForm extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depression_question_form);
        setTitle("Question form");
        Button createLog = (Button)findViewById(R.id.button_no);
        createLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String log = DateFormat.getDateTimeInstance().format(new Date())+"\n";
                EditText cause = (EditText)findViewById(R.id.editText_cause);
                log = log+ cause.getText().toString()+"\n";
                cause.setText("");
                EditText length = (EditText)findViewById(R.id.editText_length);
                log = log+length.getText().toString()+"\n";
                length.setText("");
                EditText feeling = (EditText)findViewById(R.id.editText_feelingOfWorth);
                log = log+feeling.getText().toString()+"\n";
                feeling.setText("");
                EditText decision = (EditText)findViewById(R.id.editText_physicalSigns);
                log = log+decision.getText().toString()+"\n";
                decision.setText("");
                EditText drugs = (EditText)findViewById(R.id.editText_drugs);
                log = log+ drugs.getText().toString()+"\n";
                drugs.setText("");
                EditText sleep = (EditText)findViewById(R.id.editText_sleep);
                log = log+ sleep.getText().toString()+"\n";
                sleep.setText("");
                EditText more = (EditText)findViewById(R.id.editText_more);
                log = log+more.getText().toString()+"\n"+"\n";
                more.setText("");


               //File fname = new File("Arogya");
                try {
                    FileOutputStream fstream = openFileOutput("Arogya",MODE_APPEND);
                    fstream.write(log.getBytes());
                    fstream.close();
                    Toast.makeText(getApplicationContext(),"Created Log",Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                /*
                try {
                    FileInputStream finStream = openFileInput("Arogya");
                    InputStreamReader sreader = new InputStreamReader(finStream);
                    BufferedReader bufferedReader = new BufferedReader(sreader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while((line=bufferedReader.readLine())!=null)
                    {
                       stringBuffer.append(line+"\n");
                    }

                 //   more.setText(stringBuffer);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */

                Intent i = new Intent(DepressionQuestionForm.this,ReliefActivity.class);
                startActivity(i);


            }
        });
    }

    public void onYessClick(View v)
    {
        Intent i = new Intent(this,RecordActivity.class);
        startActivity(i);
    }


}
