package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    String mJokeString = null;
    Exception mError = null;
    CountDownLatch signal = null;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testTestGetJokeTask() throws Exception {
        JokeAsyncTask task = new JokeAsyncTask();
        task.execute(new JokeCallback() {
            @Override
            public void onJokeReady(final String joke) {
                mJokeString = joke;
                mError = null;
                signal.countDown();
            }

            @Override
            public void onError(Exception e) {
                mError = e;
                signal.countDown();
            }
        });
        signal.await();

        assertNull(mError);
        assertFalse(TextUtils.isEmpty(mJokeString));
    }
}