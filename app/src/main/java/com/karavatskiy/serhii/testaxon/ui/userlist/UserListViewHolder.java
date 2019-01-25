package com.karavatskiy.serhii.testaxon.ui.userlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.karavatskiy.serhii.testaxon.R;
import com.karavatskiy.serhii.testaxon.data.pojo.UserInfo;
import com.karavatskiy.serhii.testaxon.ui.userlist.UserListAdapter.OnItemClickListener;

/**
 * Created by Serhii on 25.01.2019.
 */
public class UserListViewHolder extends ViewHolder {

    @BindView(R.id.ivUserIcon)
    ImageView ivUserIcon;

    @BindView(R.id.tvFirstName)
    TextView tvFirstName;

    @BindView(R.id.tvLastName)
    TextView tvLastName;
    @BindView(R.id.tvCity)
    TextView tvAdditional;
    private Context context;

    private OnItemClickListener onItemClickListener;

    public UserListViewHolder(@NonNull final View itemView, final Context context,
            OnItemClickListener onItemClickListener) {
        super(itemView);
        this.context = context;
        this.onItemClickListener = onItemClickListener;
        ButterKnife.bind(this, itemView);
    }

    public void bind(UserInfo userInfo) {
        tvFirstName.setText(wrapToCapital(userInfo.getName().getFirst()));
        tvLastName.setText(wrapToCapital(userInfo.getName().getLast()));
        tvAdditional.setText(wrapToCapital(userInfo.getLocation().getCity()));
        ivUserIcon.setOnClickListener(v -> onItemClickListener.onItemClick(userInfo));
        Glide.with(context)
                .asBitmap()
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .load(userInfo.getPicture().getMedium())
                .into(ivUserIcon);
    }

    private String wrapToCapital(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }


}
