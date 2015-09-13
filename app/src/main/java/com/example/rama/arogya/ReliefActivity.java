package com.example.rama.arogya;

import android.os.AsyncTask;
import android.util.Log;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class ReliefActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relief);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            String[] videoIds = {"wfdcc2M0hR8","BBQCHfQJLKs","ZmAFMNmSKus","0wC5U_jW2y4","EbVzXSkkd4M"};
            Random r = new Random();
            int i = r.nextInt(4);
            player.cueVideo(videoIds[i]); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider() {
        return youTubeView;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_relief, menu);
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

        return super.onOptionsItemSelected(item);
    }

    public void onNoClick(View v)
    {
        StringBuffer stringBuffer=new StringBuffer();
        try {
            FileInputStream finStream = openFileInput("Arogya");
            InputStreamReader sreader = new InputStreamReader(finStream);
            BufferedReader bufferedReader = new BufferedReader(sreader);

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
        final Mail m = new Mail("ravikumar123x@gmail.com", "workhack");
        String[] toArr = {"rdm2ku@gmail.com"};
        m.setTo(toArr);
        m.setFrom("ravikumar123x@gmail.com");
        m.setSubject("Your patient Needs attention");
        m.setBody(stringBuffer.toString());

        try

        {
            //m.addAttachment("/sdcard/filelocation");

            if (m.send()) {
                Toast.makeText(ReliefActivity.this, "Email was sent successfully to therapist", Toast.LENGTH_LONG).show();
            } else {
                //Toast.makeText(ReliefActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show();
            }
        }


        catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
        Intent i1 = new Intent(this,EmotionsActivity.class);
        //HappyQuestionnaireActivity.happy=false;
        startActivity(i1);

        {
           // Toast.makeText(ReliefActivity.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
            //Log.e("MailApp", "Could not send email");
        }
    }

    public void onYesClick(View v)
    {
        Intent i = new Intent(this,EmotionsActivity.class);
        startActivity(i);
    }
}
