package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tt.androidjokes.JokeCallback;
import com.tt.androidjokes.JokeFetcher;
import com.tt.androidjokes.ShowJokeActivity;


public class MainActivity extends AppCompatActivity implements JokeCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void tellJoke(View view) {
        JokeFetcher.getJokeAsync(this);
    }

    @Override
    public void onJokeReady(final String joke) {
        if (TextUtils.isEmpty(joke)) {
            onError();
        } else {
            final Intent intent = new Intent();
            intent.setClass(this, ShowJokeActivity.class);
            intent.putExtra(ShowJokeActivity.JOKE, joke);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onError() {
        Toast.makeText(this, R.string.empy_joke_error, Toast.LENGTH_LONG).show();
    }
}
