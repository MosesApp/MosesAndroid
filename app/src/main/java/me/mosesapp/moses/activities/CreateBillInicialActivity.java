package me.mosesapp.moses.activities;

import android.content.Intent;
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
import android.widget.Spinner;

import me.mosesapp.moses.MosesApplication;
import me.mosesapp.moses.R;
import me.mosesapp.moses.adapters.SpentOnBillRecyclerAdapter;
import me.mosesapp.moses.dao.MosesDAO;
import me.mosesapp.moses.model.Currency;

public class CreateBillInicialActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private MosesDAO mMosesDAO;
    private ArrayAdapter<Currency> mCurrencyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bill_inicial);

        //Action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //DAO
        mMosesDAO = ((MosesApplication) getApplication()).getMosesDAO();

        //Currency Spinner
        Spinner spinner = (Spinner) findViewById(R.id.currency_spinner);
        mCurrencyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mMosesDAO.getCurrencies());
        mCurrencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(mCurrencyAdapter);
        spinner.setOnItemSelectedListener(this);
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
                Intent intent = new Intent(getApplicationContext(), CreateBillFinalActivity.class);
                startActivity(intent);
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
