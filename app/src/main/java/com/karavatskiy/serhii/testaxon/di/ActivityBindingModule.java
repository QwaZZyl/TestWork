package com.karavatskiy.serhii.testaxon.di;

import com.karavatskiy.serhii.testaxon.ui.ControlActivity;
import com.karavatskiy.serhii.testaxon.ui.ControlActivityModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Serhii on 24.01.2019.
 */

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = ControlActivityModule.class)
    abstract ControlActivity contributeControlActivityModule();
}
