package com.example.luckyfreitag.activities;

//import com.example.luckyfreitag.adapters.NumberCustom;
//import com.example.luckyfreitag.adapters.NumberGrid;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.luckyfreitag.R;
import com.example.luckyfreitag.fragments.GameFragment;
import com.example.luckyfreitag.fragments.Randomizer;

import java.util.ArrayList;


public class Number extends AppCompatActivity implements android.support.v7.app.ActionBar.TabListener {

    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    GameFragment gameFragment;
    Randomizer randomizer;
    android.support.v4.app.FragmentTransaction transaction;
    android.support.v7.app.ActionBar actionBar;
    android.support.v7.app.ActionBar.Tab tabGame;
    android.support.v7.app.ActionBar.Tab tabRandom;

    private static final String TAG_GAME = "GameFragment";
    private static final String TAG_RANDOM = "RandomFragment";
    private static final String TAG_ACTIONBAR = "actionBar";
    private static final String TAG_TAB = "tabGame";
    private static final String TAG_TAB2 = "tabRandom";

    private static final int NUM_PAGES = 2;

    int flag;
    int sumVictory;
    int sumLose;
    public static SharedPreferences sp;
    //    public static ArrayList<GameFragment.Result> results = GameFragment.getResults();
//    public static ArrayList<String> resultsString = GameFragment.getResultsString();
//    ListView listViewSimple;
//    public static ArrayAdapter<String> adapterSimple;
    public static TextView sumWins;

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new GameFragment();
                case 1:
                    return new Randomizer();
                default:
                    return new GameFragment();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        //ViewPager settings
        mPager = (ViewPager) findViewById(R.id.frgmConteiner);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        //ActionBar changes
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //SHARED PREF
        sp = this.getSharedPreferences("mySettingsNumber", Context.MODE_PRIVATE);

        sumVictory = sp.getInt("wins", 0);
        sumLose = sp.getInt("losses", 0);

        sumWins = (TextView) findViewById(R.id.sumWins);

        if (savedInstanceState == null) {
            gameFragment = new GameFragment();
            randomizer = new Randomizer();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frgmConteiner, gameFragment, TAG_GAME);
            transaction.detach(gameFragment);
            transaction.add(R.id.frgmConteiner, randomizer, TAG_RANDOM);
            transaction.detach(randomizer);
            transaction.commit();


            actionBar = getSupportActionBar();
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            tabGame = actionBar.newTab();
            tabGame.setText("Game tab");
            tabGame.setTabListener(this);
            actionBar.addTab(tabGame);

            tabRandom = actionBar.newTab();
            tabRandom.setText("Random tab");
            tabRandom.setTabListener((android.support.v7.app.ActionBar.TabListener) this);
            actionBar.addTab(tabRandom);


        }


//
//        //simple list view
//        listViewSimple = (ListView) findViewById(R.id.simpleListView);
//        adapterSimple = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultsString);
//        listViewSimple.setAdapter(adapterSimple);
//
//        listViewSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast toast = Toast.makeText(getApplicationContext(), "Your number: " + results.get(resultsString.size() - 1 - position).user
//                        + "\n vs "
//                        + "\n Random number: " + results.get(resultsString.size() - 1 - position).rand, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (tab.getPosition()) {
            case 0:
                transaction.attach(gameFragment);
                break;
            case 1:
                transaction.attach(randomizer);
                break;
            default:
                System.out.println("onTabSelected default");
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        transaction = getSupportFragmentManager().beginTransaction();


        switch (tab.getPosition()) {
            case 0:
                transaction.detach(gameFragment);
                break;
            case 1:
                transaction.detach(randomizer);
                break;
            default:
                System.out.println("onTabUnselected default");
        }
        transaction.commit();
    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
//    public void openCustom(View v) {
//        final Intent intent = new Intent(this, NumberCustom.class);
//        startActivity(intent);
//    }
//
//    public void openGrid(View v) {
//        final Intent intent = new Intent(this, NumberGrid.class);
//        startActivity(intent);
//    }

    /*
    public boolean randGame() {
        SharedPreferences.Editor spe = sp.edit();
        EditText number = (EditText) findViewById(R.id.userNumber);
        String lol = number.getText().toString();
        TextView wins = (TextView) findViewById(R.id.sumWins);
        // Toast warnNum = Toast.makeText(getApplicationContext(), lol, Toast.LENGTH_SHORT);
        // warnNum.show();

        int userNumber = Integer.parseInt(lol);


        if (userNumber >= 10 || userNumber <= 0) {
            Toast warnNum = Toast.makeText(getApplicationContext(), "Less than 10 and more than 0", Toast.LENGTH_SHORT);
            warnNum.show();
            return false;
        }
        int randomNumber = (int) (Math.random() * 10);
        String randNumberString = String.valueOf(randomNumber);

        if (userNumber == randomNumber) {
            Result res = new Result("Win", userNumber, randomNumber);
            results.add(res);
            sumVictory++;
            wins.setText("Wins: " + sumVictory + "\nLose: " + sumLose);

        } else {
            Result res = new Result("Lose", userNumber, randomNumber);
            results.add(res);
            sumLose++;
            wins.setText("Wins: " + sumVictory + "\nLose: " + sumLose);
        }

        spe.putInt("wins", sumVictory);
        spe.apply();
        spe.putInt("losses", sumLose);
        spe.apply();
        return true;
    }
*/

