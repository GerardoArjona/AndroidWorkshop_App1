package com.example.androidworkshopapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener{

    EditText etName;
    EditText etLastnames;
    EditText etAccountNumber;
    Button dateButton;
    String birthdate;
    String major;
    int birthdate_month;
    int birthdate_year;
    int birthdate_day;

    List<String> majors  = new ArrayList<>();;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        majors.add(getString(R.string.civil));
        majors.add(getString(R.string.geomatics));
        majors.add(getString(R.string.geophysics));
        majors.add(getString(R.string.geology));
        majors.add(getString(R.string.mines));
        majors.add(getString(R.string.oil));
        majors.add(getString(R.string.electric));
        majors.add(getString(R.string.computer));
        majors.add(getString(R.string.telecom));
        majors.add(getString(R.string.industrial));
        majors.add(getString(R.string.mechanics));
        majors.add(getString(R.string.mechatronics));
        majors.add(getString(R.string.biomedics));

        etName = findViewById(R.id.editTextTextPersonName);
        etLastnames = findViewById(R.id.editTextTextPersonName2);
        etAccountNumber = findViewById(R.id.editTextTextPersonName3);

        //Majors Spinner
        Spinner majorsSpinners = (Spinner) findViewById(R.id.majorsSpinner);
        ArrayAdapter<String> majorsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, majors);
        majorsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        majorsSpinners.setAdapter(majorsAdapter);
        majorsSpinners.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        // Toast.makeText(getApplicationContext(), "Selected User: "+majors[position] ,Toast.LENGTH_SHORT).show();
        major = majors.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,day);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        // Log.i("Selected Date",  currentDateString);
        dateButton = findViewById(R.id.editTextDate);
        dateButton.setText(currentDateString);
        birthdate = currentDateString;
        birthdate_month = month;
        birthdate_year = year;
        birthdate_day = day;

    }

    public boolean sendButtonCLick(View view) {
        Intent resultsIntent = new Intent(getBaseContext(), ResultsActivity.class);

        if(etName.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), getString(R.string.nameError) ,Toast.LENGTH_SHORT).show();
            etName.setError(getString(R.string.nameErrorHelp));
            return false;
        }

        if(etLastnames.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), getString(R.string.lastnameError) ,Toast.LENGTH_SHORT).show();
            etLastnames.setError(getString(R.string.lastnameErrorHelp));
            return false;
        }

        Log.i("Regex", String.valueOf(etAccountNumber.getText().toString().matches("[1-9]{9}")));
        if(etAccountNumber.getText().toString().equals("") || etAccountNumber.getText().toString().matches("[1-9]{9}") == false || etAccountNumber.getText().toString().length() != 9){
            Toast.makeText(getApplicationContext(), getString(R.string.accountNumberError) ,Toast.LENGTH_SHORT).show();
            etAccountNumber.setError(getString(R.string.accountNumberErrorHelp));
            return false;
        }

        if(birthdate == null || birthdate.equals("")){
            Toast.makeText(getApplicationContext(), getString(R.string.dateError) ,Toast.LENGTH_SHORT).show();
            return false;
        }


        String name = etName.getText().toString();
        String lastnames = etLastnames.getText().toString();
        String accountNumber = etAccountNumber.getText().toString();

        // resultsIntent.putExtra("TEST_INTENT", "testing intents");
        resultsIntent.putExtra("NAME", name);
        resultsIntent.putExtra("LASTNAMES", lastnames);
        resultsIntent.putExtra("ACCOUNT_NUMBER", accountNumber);
        resultsIntent.putExtra("BIRTHDATE", birthdate);
        resultsIntent.putExtra("BIRTHDATE_DAY", birthdate_day);
        resultsIntent.putExtra("BIRTHDATE_MONTH", birthdate_month);
        resultsIntent.putExtra("BIRTHDATE_YEAR", birthdate_year);
        resultsIntent.putExtra("MAJOR", major);
        startActivity(resultsIntent);
        return true;
    }
}
