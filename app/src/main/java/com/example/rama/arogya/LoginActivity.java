package com.example.rama.arogya;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

    }

    public void submit(View v)
    {
        EditText l1 = (EditText)findViewById(R.id.editText);
        String login = l1.getText().toString();
        EditText l2 = (EditText)findViewById(R.id.editText2);
        String pwd = l2.getText().toString();

        if(login.equals("workwave")&&(pwd.equals("hack")))
        {
            Intent i = new Intent(this,EmotionsActivity.class);
            startActivity(i);

        }
        else
        {
            TextView myAwesomeTextView = (TextView)findViewById(R.id.textView3);
            myAwesomeTextView.setText("USER NAME/PASSWORD INCORRECT");
        }
    }

    public void register(View v) {
        //Intent launchActivity1= new Intent(this,this.class);
        //startActivity(launchActivity1);

    }


}
