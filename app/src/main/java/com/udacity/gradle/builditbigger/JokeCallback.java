package com.udacity.gradle.builditbigger;

/**
 * Created by GIL on 16/11/2015 for FinalProject.
 */
public interface JokeCallback {
    void onJokeReady(String joke);

    void onError(final Exception e);
}
