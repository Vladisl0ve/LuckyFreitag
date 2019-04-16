package com.example.luckyfreitag.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.luckyfreitag.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void openInfo(View v) {
        final Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }

    public void openCoin(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Coming soon", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void openNumber(View v) {
        final Intent intent = new Intent(this, Number.class);
        startActivity(intent);
    }

    public void closeApp(View v) {
        finish();
        System.exit(0);
    }
}
