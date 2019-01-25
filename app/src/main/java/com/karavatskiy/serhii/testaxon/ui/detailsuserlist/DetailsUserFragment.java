package com.karavatskiy.serhii.testaxon.ui.detailsuserlist;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.karavatskiy.serhii.testaxon.R;
import com.karavatskiy.serhii.testaxon.data.pojo.UserInfo;
import com.karavatskiy.serhii.testaxon.ui.base.BaseFragment;

/**
 * Created by Serhii on 24.01.2019.
 */
public class DetailsUserFragment extends BaseFragment {


    @BindView(R.id.tvFirstLastName)
    TextView tvFirstLastName;

    @BindView(R.id.tvAge)
    TextView tvAge;

    @BindView(R.id.ivUserIcon)
    ImageView ivUserIcon;

    private UserInfo userInfo;

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public static DetailsUserFragment newInstance() {
        Bundle args = new Bundle();

        DetailsUserFragment fragment = new DetailsUserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_details_user;
    }
}
