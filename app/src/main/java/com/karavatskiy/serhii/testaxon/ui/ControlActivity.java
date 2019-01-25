package com.karavatskiy.serhii.testaxon.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.karavatskiy.serhii.testaxon.R;
import com.karavatskiy.serhii.testaxon.data.pojo.UserInfo;
import com.karavatskiy.serhii.testaxon.ui.detailsuserlist.DetailsUserFragment;
import com.karavatskiy.serhii.testaxon.ui.userlist.UserListFragment;
import com.karavatskiy.serhii.testaxon.ui.userlist.UserListFragment.OnItemSelectedListener;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;

/**
 * Created by Serhii on 24.01.2019.
 */
public class ControlActivity extends AppCompatActivity implements HasSupportFragmentInjector, OnItemSelectedListener {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    private boolean doubleClicked;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidInjection.inject(this);
        starUserListFragment();
    }

    private void starUserListFragment() {
        UserListFragment userListFragment = UserListFragment.newInstance();
        userListFragment.setOnItemSelectedListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragmentContainer, userListFragment, UserListFragment.TAG)
                .addToBackStack(UserListFragment.TAG)
                .commit();
    }

    public void showDetailsFragment(UserInfo userInfo) {
        DetailsUserFragment detailsUserFragment = DetailsUserFragment.newInstance();
        detailsUserFragment.setUserInfo(userInfo);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragmentContainer, detailsUserFragment, UserListFragment.TAG)
                .addToBackStack(UserListFragment.TAG)
                .commit();
    }

    @Override
    public void getSelectedItem(final UserInfo userInfo) {
        showDetailsFragment(userInfo);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            if (doubleClicked) {
                super.finish();
            }
            doubleClicked = true;
            Toast.makeText(this, getString(R.string.message_double_click_exit), Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(() -> doubleClicked = false, 2000);
        }
    }
}
