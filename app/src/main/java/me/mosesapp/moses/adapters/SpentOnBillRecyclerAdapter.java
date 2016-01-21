package me.mosesapp.moses.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.mosesapp.moses.R;
import me.mosesapp.moses.model.GroupUser;

/**
 * Created by thiago on 1/20/16.
 */
public class SpentOnBillRecyclerAdapter extends RecyclerView.Adapter<SpentOnBillRecyclerAdapter.SpentOnBillViewHolder> {

    private List<GroupUser> mFriends;

    public SpentOnBillRecyclerAdapter(List<GroupUser> friends) {
        mFriends = friends;
    }

    @Override
    public SpentOnBillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.spent_on_bill_item, parent, false);

        SpentOnBillViewHolder vh = new SpentOnBillViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(SpentOnBillViewHolder holder, int position) {
        holder.mFriendNameView.setText(mFriends.get(position).getUser().getName());
    }

    @Override
    public int getItemCount() {
        return mFriends.size();
    }

    public static class SpentOnBillViewHolder extends RecyclerView.ViewHolder {
        public TextView mFriendNameView;
        public EditText mSpendOnBillView;
        public ImageView mFriendAvatar;

        public SpentOnBillViewHolder(View view) {
            super(view);
            mFriendNameView = (TextView) view.findViewById(R.id.spent_on_bill_friend_name);
            mSpendOnBillView = (EditText) view.findViewById(R.id.spent_on_bill);
            mFriendAvatar = (ImageView) view.findViewById(R.id.spent_on_bill_friend_avatar);
        }
    }
}
