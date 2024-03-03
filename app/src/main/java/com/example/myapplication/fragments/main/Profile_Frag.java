package com.example.myapplication.fragments.main;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import com.example.myapplication.R;

import java.util.Locale;

public class Profile_Frag extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_layout, container, false);
        // find spinner
        AppCompatSpinner languageSpinner = view.findViewById(R.id.languageSpinner);

        // Set up spinner with options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(), R.array.language_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        //Set the selected language


        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
                if(position > 0 ){
                    String selectedLanguage = parent.getItemAtPosition(position).toString();
                    setLocale(selectedLanguage);
                    updateUIForLanguageChange();
                }





            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void setLocale(String selectedLanguage) {
        // Create a Locale object with the selected language code
        Locale locale = new Locale(selectedLanguage);

        // Set the default locale of the application
        Locale.setDefault(locale);

        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);

        resources.updateConfiguration(config,resources.getDisplayMetrics());

    }

    private void updateUIForLanguageChange() {
        // Update UI components here
        // For example, update text views, buttons, etc. with new translations
        // You can use the selectedLanguage parameter to fetch the appropriate translations
        // and update the UI accordingly.
        // Update text for TextViews
        TextView titleTextView = getView().findViewById(R.id.titleTextView);
        titleTextView.setText(getString(R.string.settings));

        TextView themeTextView = getView().findViewById(R.id.themeTextView);
        themeTextView.setText(getString(R.string.select_theme));

        // Update text for CheckBox
        CheckBox notificationCheckbox = getView().findViewById(R.id.notification_checkbox);
        notificationCheckbox.setText(getString(R.string.enable_notifications));

        // Update text for Button
        Button saveButton = getView().findViewById(R.id.save_button);
        saveButton.setText(getString(R.string.save_settings));
    }
}
