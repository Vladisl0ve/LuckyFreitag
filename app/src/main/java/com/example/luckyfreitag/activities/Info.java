package com.example.luckyfreitag.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.luckyfreitag.R;

public class Info extends AppCompatActivity {

    /*

    public static final String APP_PREFERENCES = "mysettings";
    final String KEY_SWITCH_INDEX = "SAVED_SWITCH_INDEX";
    final String KEY_TOGGLE_INDEX = "SAVED_TOGGLE_INDEX";
    final String KEY_CHECK_INDEX = "SAVED_CHECK_INDEX";
    final String KEY_SEEKBAR_INDEX = "SAVED_SEEKBAR_INDEX";
    Switch aSwitch;
    ToggleButton toggleButton;
    CheckBox checkBox;
    SeekBar seekBar;
        */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        /*
        aSwitch = (Switch) findViewById(R.id.switch1);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        */
        Button back = (Button) findViewById(R.id.backButtonInfo);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /*
    private void SavePreferences(String key, int value) {
        SharedPreferences sharedPreferences = getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    private void LoadPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        int savedSwitchIndex = sharedPreferences.getInt(KEY_SWITCH_INDEX, 0);
        int savedToggleIndex = sharedPreferences.getInt(KEY_TOGGLE_INDEX, 0);
        int savedCheckIndex = sharedPreferences.getInt(KEY_CHECK_INDEX, 0);
        int savedSeekBarIndex = sharedPreferences.getInt(KEY_SEEKBAR_INDEX, 0);
        aSwitch.setChecked(true);
        toggleButton.setChecked(true);
        checkBox.setChecked(true);
        seekBar.setProgress(savedSeekBarIndex);
    }
*/
    public void switchClick(View v) {

        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Switch was clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void callClick(View v) {
        Button call = (Button) findViewById(R.id.callToDevButton);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iii = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:576963449"));
                startActivity(iii);
            }
        });

    }

    public void toggleClick(View v) {
        ToggleButton tb = (ToggleButton) findViewById(R.id.toggleButton);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "ToggleButton was clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void checkClick(View v) {
        CheckBox cb = (CheckBox) findViewById(R.id.checkBox);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "CheckBox was clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

}
