package com.karavatskiy.serhii.testaxon.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;

/**
 * Created by Serhii on 24.01.2019.
 */
public class ControlActivity extends Activity implements HasSupportFragmentInjector {


    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
