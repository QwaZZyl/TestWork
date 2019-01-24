package com.karavatskiy.serhii.testaxon.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by Serhii on 24.01.2019.
 */
public abstract class BaseFragment<A extends Activity> extends Fragment {

    protected A activity;

    abstract protected void initData();

    abstract protected int getFragmentLayoutId();

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        activity = (A) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        initData();
    }
}
