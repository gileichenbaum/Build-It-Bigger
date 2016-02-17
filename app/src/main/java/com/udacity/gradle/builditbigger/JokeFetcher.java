package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

/**
 * Created by GIL on 16/11/2015 for FinalProject.
 */
public class JokeFetcher {


    private static JokeAsyncTask sTask;

    public static void getJokeAsync(final JokeCallback callback) {
        if (sTask == null || sTask.getStatus() == AsyncTask.Status.FINISHED) {
            sTask = new JokeAsyncTask();
            sTask.execute(callback);
        }
    }
}
