package com.example.androidworkshopapp1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

//Date Picker
public class DatePickerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR) - 17;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog dialog = new DatePickerDialog(getActivity(), (MainActivity)getActivity(), year, month, day);
        Calendar today = Calendar.getInstance();
        today.set(Calendar.YEAR, today.get(Calendar.YEAR) - 17);
        dialog.getDatePicker().setMaxDate(today.getTimeInMillis());
        return dialog;
    }

}