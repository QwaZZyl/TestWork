package com.karavatskiy.serhii.testaxon.ui.base;

import android.content.Context;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Serhii on 24.01.2019.
 */
public abstract class BaseFragmentDI extends BaseFragment {

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }
}
