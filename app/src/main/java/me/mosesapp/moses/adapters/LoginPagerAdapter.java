package me.mosesapp.moses.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import me.mosesapp.moses.R;


public class LoginPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImages = new int[]{
            R.drawable.login_screen_01,
            R.drawable.login_screen_02,
            R.drawable.login_screen_03
    };

    public LoginPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mImages[position]);
        collection.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
