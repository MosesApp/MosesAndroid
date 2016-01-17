package me.mosesapp.moses.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;

import me.mosesapp.moses.MosesApplication;
import me.mosesapp.moses.R;
import me.mosesapp.moses.adapters.UserAdapter;
import me.mosesapp.moses.adapters.GroupUserRecyclerAdapter;
import me.mosesapp.moses.dao.MosesDAO;

public class CreateGroupActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mGroupUserAdapter;
    private UserAdapter mFriendAdapter;
    private MosesDAO mMosesDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        //Action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //DAO
        mMosesDAO = ((MosesApplication) getApplication()).getMosesDAO();

        //GroupUser List
        mRecyclerView = (RecyclerView) findViewById(R.id.create_group_friend_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mGroupUserAdapter = new GroupUserRecyclerAdapter(mMosesDAO.getGroupUser(0L));
        mRecyclerView.setAdapter(mGroupUserAdapter);

        //Autocomplete adapter
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.create_group_add_member);
        mFriendAdapter = new UserAdapter(this, R.layout.friend_autocomplete_item, R.id.autocomplete_friend_name, mMosesDAO.getFriends());
        textView.setAdapter(mFriendAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.done, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_done:
                //TODO: submit group creation
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
