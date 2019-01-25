package com.karavatskiy.serhii.testaxon.ui.userlist;

import com.karavatskiy.serhii.testaxon.data.remote.retrofit.RandomUserApi;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Serhii on 24.01.2019.
 */
public class UserListFragmentPresenter {

    private RandomUserApi randomUserApi;

    private OnGetUsersListListener onGetUsersListListener;

    private CompositeDisposable compositeDisposable;

    UserListFragmentPresenter(RandomUserApi randomUserApi, OnGetUsersListListener onGetUsersListListener) {
        this.randomUserApi = randomUserApi;
        this.onGetUsersListListener = onGetUsersListListener;
        compositeDisposable = new CompositeDisposable();
    }


    void requestUsersList(int numberOfUsers) {
        Disposable disposable = randomUserApi.getUser(numberOfUsers).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(randomUserInfo -> onGetUsersListListener.onGetUsersListSuccess(randomUserInfo),
                        throwable -> onGetUsersListListener.onGetUsersListError(throwable));
        compositeDisposable.add(disposable);
    }

    void disposeAll() {
        compositeDisposable.clear();
    }
}
