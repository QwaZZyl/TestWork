package com.karavatskiy.serhii.testaxon.ui.userlist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.karavatskiy.serhii.testaxon.R;
import com.karavatskiy.serhii.testaxon.data.pojo.RandomUserInfo;
import com.karavatskiy.serhii.testaxon.data.pojo.UserInfo;
import com.karavatskiy.serhii.testaxon.ui.base.BaseFragmentDI;
import javax.inject.Inject;

/**
 * Created by Serhii on 24.01.2019.
 */
public class UserListFragment extends BaseFragmentDI implements OnGetUsersListListener {

    public static final String TAG = "UserListFragment";

    @BindView(R.id.rvUserList)
    RecyclerView rvUserList;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Inject
    UserListFragmentPresenter userListFragmentPresenter;

    private UserListAdapter userListAdapter;
    private OnItemSelectedListener onItemSelectedListener;
    public static UserListFragment newInstance() {
        Bundle args = new Bundle();
        UserListFragment fragment = new UserListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initData() {
        userListAdapter = new UserListAdapter(getContext(),
                userInfo -> onItemSelectedListener.getSelectedItem(userInfo));
        rvUserList.setAdapter(userListAdapter);
        rvUserList.setLayoutManager(new LinearLayoutManager(activity));

        userListFragmentPresenter.requestUsersList(20);

        progressBar.setVisibility(View.VISIBLE);
    }
    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener){
        this.onItemSelectedListener = onItemSelectedListener;
    }
    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_user_list;
    }

    @Override
    public void onGetUsersListSuccess(final RandomUserInfo randomUserInfo) {
        userListAdapter.setRandomUserInfo(randomUserInfo.getResults());
        Log.d(TAG, "onGetUsersListSuccess");
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onGetUsersListError(final Throwable throwable) {
        Log.d(TAG, "onGetUsersListError: " + throwable);
        progressBar.setVisibility(View.GONE);

    }

    public interface OnItemSelectedListener {

        void getSelectedItem(UserInfo userInfo);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();

        userListFragmentPresenter.disposeAll();
    }
}
