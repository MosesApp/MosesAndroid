package me.mosesapp.moses.adapters;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.mosesapp.moses.R;
import me.mosesapp.moses.model.Group;

/**
 * Created by thiago on 1/10/16.
 */
public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupRecyclerViewAdapter.GroupViewHolder> {
    private List<Group> mGroups;

    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        public TextView mGroupNameView;
        public TextView mBalanceValueView;
        public ImageView mGroupAvatarView;
        public ImageView mBalanceIndicatorCircleView;

        public GroupViewHolder (View view){
            super(view);
            mGroupNameView = (TextView) view.findViewById(R.id.home_group_card_name);
            mBalanceValueView = (TextView) view.findViewById(R.id.group_balance_value);
            mGroupAvatarView = (ImageView) view.findViewById(R.id.group_avatar);
            mBalanceIndicatorCircleView = (ImageView) view.findViewById(R.id.balance_indicator_circle);
        }
    }

    public GroupRecyclerViewAdapter (List<Group> groups) {
        mGroups = groups;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_group_card, parent, false);

        GroupViewHolder vh = new GroupViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        holder.mGroupNameView.setText(mGroups.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mGroups.size();
    }
}
