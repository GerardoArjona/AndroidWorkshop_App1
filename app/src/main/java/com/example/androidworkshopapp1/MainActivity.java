package com.example.androidworkshopapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
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
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener{

    EditText etName;
    EditText etLastnames;
    EditText etAccountNumber;
    Button dateButton;
    String birthdate;
    String major;

    String[] majors = {
            "Ingeniería Civil",
            "Ingeniería Geomática",
            "Ingeniería Geofísica",
            "Ingeniería Geológica",
            "Ingeniería de Minas y Metalurgia",
            "Ingeniería Petrolera",
            "Ingeniería Eléctrica Electrónica",
            "Ingeniería en Computación",
            "Ingeniería en Telecomunicaciones",
            "Ingeniería Industrial",
            "Ingeniería Mecánica",
            "Ingeniería Mecatrónica",
            "Ingeniería en Sistemas Biomédicos"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        major = majors[position];
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
    }

    public void sendButtonCLick(View view) {
        Intent resultsIntent = new Intent(getBaseContext(), ResultsActivity.class);

        String name = etName.getText().toString();
        String lastnames = etLastnames.getText().toString();
        String accountNumber = etAccountNumber.getText().toString();

        // resultsIntent.putExtra("TEST_INTENT", "testing intents");
        resultsIntent.putExtra("NAME", name);
        resultsIntent.putExtra("LASTNAMES", lastnames);
        resultsIntent.putExtra("ACCOUNT_NUMBER", accountNumber);
        resultsIntent.putExtra("BIRTHDATE", birthdate);
        resultsIntent.putExtra("MAJOR", major);
        startActivity(resultsIntent);
    }
}
