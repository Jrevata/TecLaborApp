package com.jrevata.teclaborapp.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jrevata.teclaborapp.R;
import com.jrevata.teclaborapp.activities.ResultActivity;
import com.jrevata.teclaborapp.models.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends BaseAdapter {

    private static final String TAG = TestAdapter.class.getSimpleName();
    private List<Test> tests;
    private Activity activity;
    private LayoutInflater mInflater;

    public TestAdapter(Activity activity){
        tests = new ArrayList<>();
        this.activity = activity;
    }

    public void setTestAdapter(List<Test> tests){
        this.tests = tests;
    }

    @Override
    public int getCount() {
        return tests.size();
    }

    @Override
    public Object getItem(int position) {
        return tests.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tests, parent, false);
        final Test test = this.tests.get(position);


        TextView date = convertView.findViewById(R.id.textView_datetime);
        TextView name = convertView.findViewById(R.id.textView_name_test);
        TextView nota = convertView.findViewById(R.id.textView_nota);
        LinearLayout backgr = convertView.findViewById(R.id.linearLayout_color_test);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String dateformat = dateFormat.format(test.getFecha());

        date.setText(dateformat);
        name.setText(test.getNombre());
        nota.setText(String.valueOf(test.getEmpleabilidad()));

        if(test.getEmpleabilidad() < 8)
            backgr.setBackgroundResource(R.color.Red);
        else if(test.getEmpleabilidad() >= 8 && test.getEmpleabilidad() < 13)
            backgr.setBackgroundResource(R.color.Bee_Yellow);
        else if(test.getEmpleabilidad() >= 13 && test.getEmpleabilidad() < 18)
            backgr.setBackgroundResource(R.color.Green_Apple);
        else
            backgr.setBackgroundResource(R.color.Green);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ResultActivity.class);
                intent.putExtra("nombre", test.getNombre());
                v.getContext().startActivity(intent);
            }
        });


        return convertView;
    }
}
