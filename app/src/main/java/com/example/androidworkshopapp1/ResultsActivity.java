package com.example.androidworkshopapp1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class ResultsActivity extends AppCompatActivity {

    // String testIntet;
    TextView tvName;
    TextView tvLastnames;
    TextView tvAccountNumber;
    TextView tvBirthdate;
    TextView tvYearsOld;
    TextView tvMajor;
    ImageView ivMajorPicture;

    @RequiresApi(api = Build.VERSION_CODES.O)
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
        tvYearsOld = findViewById(R.id.tvYearsOld);

        Calendar datOfBirth = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        datOfBirth.set(getIntent().getIntExtra("BIRTHDATE_YEAR", 0), getIntent().getIntExtra("BIRTHDATE_MONTH", 0), getIntent().getIntExtra("BIRTHDATE_DAY", 0));

        int age = today.get(Calendar.YEAR) - datOfBirth.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < datOfBirth.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        // Log.i("Age", String.valueOf(age));

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        tvName.setText(getIntent().getStringExtra("NAME"));
        tvLastnames.setText(getIntent().getStringExtra("LASTNAMES"));
        tvAccountNumber.setText(getIntent().getStringExtra("ACCOUNT_NUMBER"));
        tvBirthdate.setText(getIntent().getStringExtra("BIRTHDATE"));
        tvMajor.setText(getIntent().getStringExtra("MAJOR"));
        tvYearsOld.setText(ageS + " " + getString(R.string.yearsOld));

        ivMajorPicture = (ImageView)findViewById((R.id.ivMajorPictureResults));
        if(getString(R.string.civil).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.civil);
        else if (getString(R.string.geomatics).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.geomatic);
        else if (getString(R.string.geophysics).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.geophysics);
        else if (getString(R.string.geology).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.geology);
        else if (getString(R.string.mines).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.mines);
        else if (getString(R.string.oil).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.oil);
        else if (getString(R.string.electric).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.electric);
        else if (getString(R.string.computer).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.computer);
        else if (getString(R.string.telecom).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.telecom);
        else if (getString(R.string.industrial).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.industrial);
        else if (getString(R.string.mechanics).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.mehcanics);
        else if (getString(R.string.mechatronics).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.mechatronics);
        else if (getString(R.string.biomedics).equals(getIntent().getStringExtra("MAJOR")))
            ivMajorPicture.setImageResource(R.drawable.biomedic);
        else
            ivMajorPicture.setImageResource(R.drawable.def);
    }
}