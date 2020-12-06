package com.example.androidworkshopapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    // String testIntet;
    TextView tvName;
    TextView tvLastnames;
    TextView tvAccountNumber;
    TextView tvBirthdate;
    TextView tvMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // testIntet = getIntent().getStringExtra("TEST_INTENT");
        // Log.i("Test intent",  testIntet);
        tvName = findViewById(R.id.tvNamesResults);
        tvLastnames = findViewById(R.id.tvLastnamesResults);
        tvAccountNumber = findViewById(R.id.tvAccountNumberResults);
        tvBirthdate= findViewById(R.id.tvBirthdateResults);
        tvMajor = findViewById(R.id.tvMajorResults);

        tvName.setText(getIntent().getStringExtra("NAME"));
        tvLastnames.setText(getIntent().getStringExtra("LASTNAMES"));
        tvAccountNumber.setText(getIntent().getStringExtra("ACCOUNT_NUMBER"));
        tvBirthdate.setText(getIntent().getStringExtra("BIRTHDATE"));
        tvMajor.setText(getIntent().getStringExtra("MAJOR"));
    }
}