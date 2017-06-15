package com.example.ashwin.searchablespinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<String> mCountriesList;
    private String mCountry;

    CustomSearchableSpinner mCountriesSearchableSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCountriesList();
        initViews();
    }

    private void initCountriesList() {
        mCountriesList = new ArrayList<>();
        mCountriesList.add("Select Country");
        mCountriesList.add("India");
        mCountriesList.add("USA");
        mCountriesList.add("Japan");
        mCountriesList.add("Germany");
        mCountriesList.add("Singapore");
        mCountriesList.add("Indonesia");
        mCountriesList.add("Malaysia");
        mCountriesList.add("China");
        mCountriesList.add("France");
        mCountriesList.add("Italy");
        mCountriesList.add("Russia");
    }

    private void initViews() {
        initSearchableSpinner();
    }

    private void initSearchableSpinner() {
        mCountriesSearchableSpinner = (CustomSearchableSpinner) findViewById(R.id.countries_searchable_spinner);
        ArrayAdapter<String> countriesSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mCountriesList);
        mCountriesSearchableSpinner.setAdapter(countriesSpinnerAdapter);
        mCountriesSearchableSpinner.setTitle("Countries");
        mCountriesSearchableSpinner.setPositiveButton("CLOSE");

        mCountriesSearchableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCountriesSearchableSpinner.isCountriesSpinnerOpen = false;
                mCountry = mCountriesList.get(position);
                if (mCountry.equalsIgnoreCase("select country")) {
                    mCountry = "";
                    Log.d(Constants.DEBUG_LOGGING, TAG + " : Nothing selected");
                } else {
                    Log.d(Constants.DEBUG_LOGGING, TAG + " : country selected : " + mCountry);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mCountriesSearchableSpinner.isCountriesSpinnerOpen = false;
                mCountry = "";
                Log.d(Constants.DEBUG_LOGGING, TAG + " : Nothing selected");
            }
        });
    }
}
