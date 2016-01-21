package me.mosesapp.moses.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.mosesapp.moses.R;
import me.mosesapp.moses.model.GroupUser;

/**
 * Created by thiago on 1/13/16.
 */
public class GroupUserRecyclerAdapter extends RecyclerView.Adapter<GroupUserRecyclerAdapter.GroupUserViewHolder> {
    private List<GroupUser> mFriends;

    public GroupUserRecyclerAdapter(List<GroupUser> friends) {
        mFriends = friends;
    }

    @Override
    public GroupUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_friend_item, parent, false);

        GroupUserViewHolder vh = new GroupUserViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(GroupUserViewHolder holder, int position) {
        holder.mFriendNameView.setText(mFriends.get(position).getUser().getName());

        if (mFriends.get(position).isAdmin()) {
            holder.mAdminView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mFriends.size();
    }

    public static class GroupUserViewHolder extends RecyclerView.ViewHolder {
        public TextView mFriendNameView;
        public TextView mAdminView;
        public ImageView mFriendAvatarView;

        public GroupUserViewHolder(View view) {
            super(view);
            mFriendNameView = (TextView) view.findViewById(R.id.autocomplete_friend_name);
            mAdminView = (TextView) view.findViewById(R.id.group_admin);
            mFriendAvatarView = (ImageView) view.findViewById(R.id.autocomplete_friend_avatar);
        }
    }

}
