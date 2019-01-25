package com.karavatskiy.serhii.testaxon.ui.userlist;

import com.karavatskiy.serhii.testaxon.data.remote.retrofit.RandomUserApi;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Serhii on 25.01.2019.
 */
@Module
public class UserListFragmentModule {

    @Provides
    OnGetUsersListListener provideOnRequestUsersListListener(UserListFragment userListFragment) {
        return userListFragment;
    }

    @Provides
    UserListFragmentPresenter provideUserListFragmentPresenter(RandomUserApi randomUserApi,
            OnGetUsersListListener onGetUsersListListener) {
        return new UserListFragmentPresenter(randomUserApi, onGetUsersListListener);
    }
}
