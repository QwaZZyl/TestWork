package com.karavatskiy.serhii.testaxon.ui.userlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.karavatskiy.serhii.testaxon.R;
import com.karavatskiy.serhii.testaxon.data.pojo.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Serhii on 25.01.2019.
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListViewHolder> {

    private List<UserInfo> userList;

    private Context context;

    private OnItemClickListener onItemClickListener;

    UserListAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.onItemClickListener = onItemClickListener;
        userList = Collections.emptyList();
    }

    public void setRandomUserInfo(List<UserInfo> userList) {
        this.userList = new ArrayList<>();
        this.userList.addAll(userList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        userList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new UserListViewHolder(inflater.inflate(R.layout.user_list_item_row,
                viewGroup,
                false),
                context, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserListViewHolder userListViewHolder, final int position) {
        userListViewHolder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }

    public interface OnItemClickListener {

        void onItemClick(UserInfo userInfo);
    }
}
