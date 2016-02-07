package com.tt.androidjokes;

import android.content.Intent;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivityBase extends AppCompatActivity implements JokeCallback {

    private ContentLoadingProgressBar mProgressView;

    @Override
    protected void onResume() {
        super.onResume();
        mProgressView = (ContentLoadingProgressBar) findViewById(android.R.id.progress);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        if (mProgressView != null) {
            mProgressView.show();
        }

        JokeFetcher.getJokeAsync(this);
    }

    @Override
    public void onJokeReady(final String joke) {

        if (mProgressView != null) {
            mProgressView.hide();
        }

        if (TextUtils.isEmpty(joke)) {
            onError(new Exception("callback returned empty text"));
        } else {
            openJokeActivity(joke);
        }
    }

    protected void openJokeActivity(final String joke) {

        if (mProgressView != null) {
            mProgressView.hide();
        }

        final Intent intent = new Intent();
        intent.setClass(this, ShowJokeActivity.class);
        intent.putExtra(ShowJokeActivity.JOKE, joke);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onError(Exception e) {
        Toast.makeText(this, R.string.empy_joke_error, Toast.LENGTH_LONG).show();
    }
}
