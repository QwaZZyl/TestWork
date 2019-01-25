package com.karavatskiy.serhii.testaxon.di;

import com.karavatskiy.serhii.testaxon.ui.ControlActivity;
import com.karavatskiy.serhii.testaxon.ui.ControlActivityModule;
import com.karavatskiy.serhii.testaxon.ui.userlist.UserListFragment;
import com.karavatskiy.serhii.testaxon.ui.userlist.UserListFragmentModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Serhii on 24.01.2019.
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = ControlActivityModule.class)
    abstract ControlActivity contributeControlActivityModule();

    @ContributesAndroidInjector(modules = UserListFragmentModule.class)
    abstract UserListFragment contributeUserListFragment();
}
