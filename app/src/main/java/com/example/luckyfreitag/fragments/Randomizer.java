package com.example.luckyfreitag.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.luckyfreitag.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Randomizer extends Fragment {


    TextView numberShowed;

    public Randomizer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_randomizer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button play = (Button) getView().findViewById(R.id.buttonPlayFragmentRandomizer);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberShowed = (TextView) getView().findViewById(R.id.textViewRandomNumberFragmentRandomizer);
                numberShowed.setText(shuffleNumber());
            }
        });
    }

    public String shuffleNumber() {
        int randomNumber = (int) (Math.random() * 10);
        return String.valueOf(randomNumber);
    }

}
