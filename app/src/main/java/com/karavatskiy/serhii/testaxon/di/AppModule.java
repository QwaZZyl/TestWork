package com.karavatskiy.serhii.testaxon.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Serhii on 24.01.2019.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }
}
