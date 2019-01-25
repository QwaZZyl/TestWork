package com.karavatskiy.serhii.testaxon.ui.userlist;

import com.karavatskiy.serhii.testaxon.data.pojo.RandomUserInfo;

/**
 * Created by Serhii on 25.01.2019.
 */
public interface OnGetUsersListListener {

    void onGetUsersListSuccess(RandomUserInfo randomUserInfo);

    void onGetUsersListError(Throwable throwable);
}
