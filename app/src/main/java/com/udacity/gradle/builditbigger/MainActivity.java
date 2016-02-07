package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.tt.androidjokes.MainActivityBase;


public class MainActivity extends MainActivityBase {

    private final static String TAG = "Free_MainActivity";

    private InterstitialAd mInterstitialAd;
    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBannerAd();
        makeInterstitialAd();
    }

    private void initBannerAd() {

        final AdView adView = (AdView) findViewById(R.id.adView);

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Log.i(TAG, "onAdClosed");
            }

            @Override
            public void onAdFailedToLoad(final int errorCode) {
                super.onAdFailedToLoad(errorCode);
                Log.e(TAG, "onAdFailedToLoad, code=" + errorCode);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
                Log.i(TAG, "onAdLeftApplication");
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                Log.i(TAG, "onAdOpened");
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.i(TAG, "onAdLoaded");
            }
        });

        final AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template")
                .build();

        adView.loadAd(adRequest);
    }

    @Override
    public void onJokeReady(final String joke) {
        mJoke = joke;
        showJoke();
    }

    private void showJoke() {
        if (TextUtils.isEmpty(mJoke)) {
            super.onJokeReady(mJoke);
        } else {
            if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                openJokeActivity(mJoke);
                makeInterstitialAd();
            }
        }
    }

    private void makeInterstitialAd() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.i(TAG, "Onloaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.i(TAG, "onAdFailedToLoad " + errorCode);
            }

            @Override
            public void onAdClosed() {
                openJokeActivity(mJoke);
            }
        });

        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
    }
}
