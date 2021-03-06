package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.gil.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by GIL on 16/11/2015 for FinalProject.
 */
public class JokeAsyncTask extends AsyncTask<JokeCallback, Void, String> {

    private static final String TAG = JokeAsyncTask.class.getSimpleName();
    private static JokeApi mApiService = null;
    private JokeCallback mListener;

    @Override
    protected String doInBackground(JokeCallback... params) {
        if (mApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://aitype-cloud-server.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            mApiService = builder.build();
        }

        mListener = params[0];

        try {
            return mApiService.getJoke().execute().getData();
        } catch (IOException e) {
            mListener.onError(e);
            Log.e(TAG, "error getting joke from server", e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        mListener.onJokeReady(joke);
    }
}
