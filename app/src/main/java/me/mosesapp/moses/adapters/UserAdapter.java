package me.mosesapp.moses.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.mosesapp.moses.R;
import me.mosesapp.moses.model.User;

/**
 * Created by thiago on 1/15/16.
 */
public class UserAdapter extends ArrayAdapter<User> implements Filterable {
    public UserAdapter(Context context, int resource, int textViewResourceId, List<User> friends) {
        super(context, resource, textViewResourceId, friends);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FriendViewHolder friendViewHolder;

        if (convertView == null) {
            convertView = super.getView(position, convertView, parent);
            friendViewHolder = new FriendViewHolder(convertView);
            convertView.setTag(friendViewHolder);
        } else {
            friendViewHolder = (FriendViewHolder) convertView.getTag();
        }
        //TODO: Set image here

        return convertView;
    }

    public static class FriendViewHolder {
        public TextView mFriendNameView;
        public ImageView mFriendAvatarView;

        public FriendViewHolder(View view) {
            mFriendNameView = (TextView) view.findViewById(R.id.autocomplete_friend_name);
            mFriendAvatarView = (ImageView) view.findViewById(R.id.autocomplete_friend_avatar);
            view.setTag(this);
        }
    }
}
