package com.karavatskiy.serhii.testaxon;

import android.app.Activity;
import android.app.Application;
import com.karavatskiy.serhii.testaxon.di.DaggerAppComponent;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

/**
 * Created by Serhii on 24.01.2019.
 */
public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}