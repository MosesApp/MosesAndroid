package me.mosesapp.moses.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.mosesapp.moses.R;
import me.mosesapp.moses.adapters.LoginPagerAdapter;

public class LoginActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private List<ImageView> pageViewIndicatorItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        LoginPagerAdapter loginPagerAdapter = new LoginPagerAdapter(this);
        viewPager.setAdapter(loginPagerAdapter);

        viewPager.addOnPageChangeListener(this);
        setPageViewIndicator(loginPagerAdapter.getCount());

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("email", "public_profile", "user_friends"));
    }

    private void setPageViewIndicator(int indicatorCount) {
        LinearLayout viewPagerIndicatorItems = (LinearLayout) findViewById(R.id.viewPagerIndicatorItems);
        pageViewIndicatorItems = new ArrayList<>();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(20, 0, 20, 0);

        for (int i = 0; i < indicatorCount; i++) {
            ImageView indicator = new ImageView(this);
            indicator.setImageResource(R.drawable.nonselecteditem_dot);

            pageViewIndicatorItems.add(indicator);
            viewPagerIndicatorItems.addView(indicator, params);
        }
        pageViewIndicatorItems.get(0).setImageResource(R.drawable.selecteditem_dot);
    }

    @Override
    public void onPageSelected(int position) {
        for (ImageView indicator : pageViewIndicatorItems) {
            indicator.setImageResource(R.drawable.nonselecteditem_dot);
        }
        pageViewIndicatorItems.get(position).setImageResource(R.drawable.selecteditem_dot);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
}
