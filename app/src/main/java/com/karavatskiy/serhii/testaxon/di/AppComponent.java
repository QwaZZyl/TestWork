package com.karavatskiy.serhii.testaxon.di;

import android.app.Application;
import com.karavatskiy.serhii.testaxon.App;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

/**
 * Created by Serhii on 24.01.2019.
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        AppModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Override
    void inject(App instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}