//package com.example.luckyfreitag.adapters;
//
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.luckyfreitag.activities.Number;
//import com.example.luckyfreitag.R;
//
//import java.util.ArrayList;
//
//
//public class myAdapterCustomizedList extends BaseAdapter {
//    ArrayList<Number.Result> results = Number.getResults();
//    ArrayList<String> resultsString = Number.getResultsString();
//
//    //String[] ltxt1 = {"Position nr 1", "Position nr 2", "Position nr 3", "Position nr 4", "Position nr 5",
//    //       "Position nr 6", "Position nr 7", "Position nr 8", "Position nr 9", "Position nr 10"};
//    // String[] ltxt2 = {"Text 1", "Text 2", "Text 3", "Text 4", "Text 5", "Text 6", "Text 7", "Text 8", "Text 9", "Text 10"};
//
//
//    private class LVitem {
//        TextView tv1;
//        TextView tv2;
//        ImageView img;
//    }
//
//    private LayoutInflater inflater = null;
//    boolean[] zazn_pozycje;
//    LVitem myLVitem;
//    Context ctx;
//
//    myAdapterCustomizedList(Context cotx) {
//        super();
//        ctx = cotx;
//        zazn_pozycje = new boolean[resultsString.size()];
//        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//
//    public int getCount() {
//        return resultsString.size();
//    }
//
//    public Object getItem(int position) {
//        return position;
//    }
//
//    public long getItemId(int position) {
//        return position;
//    }
//
//
//    public View getView(final int position, View listItemView, ViewGroup parent) {
//        if (listItemView == null) {
//            listItemView = inflater.inflate(R.layout.list_row, null);
//            myLVitem = new LVitem();
//            myLVitem.tv1 = (TextView) listItemView.findViewById(R.id.row_tv1);
//            myLVitem.tv2 = (TextView) listItemView.findViewById(R.id.row_tv2);
//            myLVitem.img = (ImageView) listItemView.findViewById(R.id.row_image);
//            if (results.get(resultsString.size() - 1 - position).rand != results.get(resultsString.size() - 1 - position).user)
//                myLVitem.img.setImageResource(R.drawable.lose);
//            listItemView.setTag(myLVitem);
//        } else
//            myLVitem = (LVitem) listItemView.getTag();
//
//        myLVitem.tv1.setText(resultsString.get(position));
//        myLVitem.tv2.setText("Your number: " + results.get(resultsString.size() - 1 - position).user + "\n vs" +
//                "\n Random number: " + results.get(resultsString.size() - 1 - position).rand);
//
//        return listItemView;
//    }
//}