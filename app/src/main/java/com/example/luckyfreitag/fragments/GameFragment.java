package com.example.luckyfreitag.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luckyfreitag.R;
import com.example.luckyfreitag.activities.Number;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    static int flag = 0;
    static int counterOfNumbers = 0;
    int sumVictory;
    int sumLose;
    SharedPreferences sp;
    public static ArrayList<Result> results = new ArrayList<>();
    public static ArrayList<String> resultsString = new ArrayList<>();
    ListView listViewSimple;
    public static ArrayAdapter<String> adapterSimple;
    public static TextView sumWins;

    public class Result {
        public int counter;
        public String winOrLose;
        public int user;
        public int rand;

        public Result(int count, String result, int userNumber, int randNumber) {
            counter = count;
            winOrLose = result;
            user = userNumber;
            rand = randNumber;
        }
    }

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button play = (Button) getView().findViewById(R.id.playButtonFragmentGame);
        sp = this.getActivity().getSharedPreferences("mySettingsNumber", Context.MODE_PRIVATE);
        sumVictory = sp.getInt("wins", 0);
        sumLose = sp.getInt("losses", 0);

        sumWins = (TextView) getView().findViewById(R.id.sumWins);

        //simple list view
        listViewSimple = (ListView) getView().findViewById(R.id.simpleListView);
        adapterSimple = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, resultsString);
        listViewSimple.setAdapter(adapterSimple);

        listViewSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getContext(), "Your number: " + results.get(resultsString.size() - 1 - position).user
                        + "\n vs "
                        + "\n Random number: " + results.get(resultsString.size() - 1 - position).rand, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(getActivity());
                if (randGame()) {
                    resultsString.add(0, results.get(flag).counter + ". " + results.get(flag).winOrLose);
                    flag++;
                    adapterSimple.notifyDataSetChanged();
                }

            }
        });
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null) {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (activity.getCurrentFocus() != null && inputManager != null) {
                inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
                inputManager.showSoftInputFromInputMethod(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }


    public boolean randGame() {
        SharedPreferences.Editor spe = Number.sp.edit();
        EditText number = (EditText) getView().findViewById(R.id.userNumberFragmentGame);
        String lol = number.getText().toString();
        TextView wins = Number.sumWins;
        // Toast warnNum = Toast.makeText(getApplicationContext(), lol, Toast.LENGTH_SHORT);
        // warnNum.show();
        int userNumber;
        if (lol == "")
            return false;
        try {
            userNumber = Integer.parseInt(lol);
        } catch (NumberFormatException e) {
            return false;
        }


        if (userNumber >= 10 || userNumber <= 0) {
            Toast warnNum = Toast.makeText(getContext(), "Less than 10 and more than 0", Toast.LENGTH_SHORT);
            warnNum.show();
            return false;
        }
        int randomNumber = (int) (Math.random() * 10);
        String randNumberString = String.valueOf(randomNumber);
        counterOfNumbers++;

        if (userNumber == randomNumber) {
            Result res = new Result(counterOfNumbers, "Win", userNumber, randomNumber);
            results.add(res);
            sumVictory++;
            wins.setText("Wins: " + sumVictory + "\nLosses: " + sumLose);

        } else {
            Result res = new Result(counterOfNumbers, "Lose", userNumber, randomNumber);
            results.add(res);
            sumLose++;
            wins.setText("Wins: " + sumVictory + "\nLosses: " + sumLose);
        }

        spe.putInt("wins", sumVictory);
        spe.apply();
        spe.putInt("losses", sumLose);
        spe.apply();
        return true;
    }


    public static int getFlag() {
        return flag;
    }

    public static ArrayList<Result> getResults() {
        return results;
    }

    public static ArrayList<String> getResultsString() {
        return resultsString;
    }


}
