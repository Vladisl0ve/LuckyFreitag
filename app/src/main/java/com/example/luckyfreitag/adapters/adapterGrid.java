//package com.example.luckyfreitag.adapters;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.GridView;
//import android.widget.ImageView;
//
//import com.example.luckyfreitag.activities.Number;
//import com.example.luckyfreitag.R;
//
//import java.util.ArrayList;
//
//public class adapterGrid extends BaseAdapter {
//    ArrayList<Number.Result> results = Number.getResults();
//    ArrayList<String> resultsString = Number.getResultsString();
//    private Context ctx;
//    public Integer[] id_img = {R.drawable.lose, R.drawable.win};
//
//    public adapterGrid(Context c) {
//        ctx = c;
//    }
//
//    public int getCount() {
//        return resultsString.size();
//    }
//
//    public Object getItem(int pos) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView mV;
//        if (convertView == null) {
//            mV = new ImageView(ctx);
//            mV.setLayoutParams(new GridView.LayoutParams(200, 200));
//            mV.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            mV.setPadding(8, 8, 8, 8);
//        } else
//            mV = (ImageView) convertView;
//        if (resultsString.get(position) == "Win") {
//            mV.setImageResource(id_img[1]);
//        } else {
//            mV.setImageResource(id_img[0]);
//        }
//        return mV;
//    }
//}