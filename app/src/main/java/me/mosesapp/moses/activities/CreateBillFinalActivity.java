package me.mosesapp.moses.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import me.mosesapp.moses.MosesApplication;
import me.mosesapp.moses.R;
import me.mosesapp.moses.adapters.SpentOnBillRecyclerAdapter;
import me.mosesapp.moses.dao.MosesDAO;
import me.mosesapp.moses.model.Currency;

public class CreateBillFinalActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private MosesDAO mMosesDAO;
    private ArrayAdapter<Currency> mCurrencyAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SpentOnBillRecyclerAdapter mSpentOnBillAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bill_final);

        //Action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //DAO
        mMosesDAO = ((MosesApplication) getApplication()).getMosesDAO();

        //GroupUser List
        mRecyclerView = (RecyclerView) findViewById(R.id.spent_on_bill_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mSpentOnBillAdapter = new SpentOnBillRecyclerAdapter(mMosesDAO.getGroupUser(0L));
        mRecyclerView.setAdapter(mSpentOnBillAdapter);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
