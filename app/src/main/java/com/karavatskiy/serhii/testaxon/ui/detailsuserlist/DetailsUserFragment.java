package com.karavatskiy.serhii.testaxon.ui.detailsuserlist;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.karavatskiy.serhii.testaxon.R;
import com.karavatskiy.serhii.testaxon.data.pojo.UserInfo;
import com.karavatskiy.serhii.testaxon.ui.base.BaseFragment;

/**
 * Created by Serhii on 24.01.2019.
 */
public class DetailsUserFragment extends BaseFragment {

    @BindView(R.id.ivUserIcon)
    ImageView ivUserIcon;
    @BindView(R.id.tvFirstLastName)
    TextView tvFirstLastName;
    @BindView(R.id.tvAge)
    TextView tvAge;
    @BindView(R.id.tvCellPhoneNumber)
    TextView tvCellPhoneNumber;
    @BindView(R.id.tvLocation)
    TextView tvLocation;
    @BindView(R.id.tvGender)
    TextView tvGender;
    @BindView(R.id.tvDataOfBirth)
    TextView tvDataOfBirth;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.btnPhoneCall)
    Button btnPhoneCall;

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
        Glide.with(this)
                .asBitmap()
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .load(userInfo.getPicture().getLarge())
                .into(ivUserIcon);

        tvFirstLastName.setText(new StringBuilder().append(userInfo.getName()
                .getFirst())
                .append(" ")
                .append(userInfo.getName().getLast()));
        tvLocation.setText(new StringBuilder().append(userInfo
                .getLocation()
                .getCity())
                .append(", ")
                .append(userInfo.getLocation().getState()));

        tvAge.setText(activity.getString(R.string.age, userInfo.getDob().getAge()));
        tvCellPhoneNumber.setText(userInfo.getPhone());
        tvGender.setText(userInfo.getGender());
        tvDataOfBirth.setText(userInfo.getDob().getDate().split("T", 2)[0]);
        tvEmail.setText(userInfo.getEmail());

        btnPhoneCall.setOnClickListener(v -> makePhoneCall());
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_details_user;
    }

    public void makePhoneCall() {
        PackageManager packageManager = activity.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + userInfo.getPhone()));
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent);
        }
    }
}
