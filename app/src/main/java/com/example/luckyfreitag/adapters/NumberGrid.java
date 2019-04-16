//package com.example.luckyfreitag.adapters;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.GridView;
//import android.widget.Toast;
//
//import com.example.luckyfreitag.R;
//import com.example.luckyfreitag.activities.Number;
//import com.example.luckyfreitag.adapters.adapterGrid;
//
//import java.util.ArrayList;
//
//public class NumberGrid extends AppCompatActivity {
//    public static ArrayList<Number.Result> results = Number.getResults();
//    public static ArrayList<String> resultsString = Number.getResultsString();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_number_grid);
//
//        GridView gridView = (GridView) findViewById(R.id.gridListView);
//        gridView.setAdapter(new adapterGrid(this));
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast toast = Toast.makeText(getApplicationContext(), "Your number: " + results.get(resultsString.size() - 1 - position).user
//                        + "\n vs "
//                        + "\n Random number: " + results.get(resultsString.size() - 1 - position).rand, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
//
//    }
//}
