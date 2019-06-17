package com.jrevata.teclaborapp.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.jrevata.teclaborapp.R;
import com.jrevata.teclaborapp.models.Test;
import com.jrevata.teclaborapp.repositories.TestRepository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        loadDataRadar();

    }

    private void loadDataRadar(){


        Test test = null;

        test = TestRepository.getTest(getIntent().getExtras().getString("nombre"));

        String JSONGeneral = test.toJSON();
        ArrayList entries = new ArrayList<>();
        try {

            JSONObject obj= new JSONObject(JSONGeneral);
            JSONArray jsonArray = new JSONArray();
            //simply put obj into jsonArray
            jsonArray.put(obj);

            for(int i=0; i < jsonArray.length(); i++) {

                JSONObject jsonobject = jsonArray.getJSONObject(i);


                String creatividad = String.valueOf(jsonobject.getInt("creatividad")).trim();
                String persuasion  = String.valueOf(jsonobject.getInt("persuasion")).trim();
                String colaboracion = String.valueOf(jsonobject.getInt("colaboracion")).trim();
                String adaptabilidad = String.valueOf(jsonobject.getInt("adaptabilidad")).trim();
                String productividad = String.valueOf(jsonobject.getInt("productividad")).trim();


                entries.add(new Entry(Float.valueOf(creatividad), 0));
                entries.add(new Entry(Float.valueOf(persuasion), 1));
                entries.add(new Entry(Float.valueOf(colaboracion), 2));
                entries.add(new Entry(Float.valueOf(adaptabilidad), 3));
                entries.add(new Entry(Float.valueOf(productividad), 4));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RadarChart chart = (RadarChart) findViewById(R.id.chart23);
        RadarDataSet dataset_comp1 = new RadarDataSet(entries, "P001");

        dataset_comp1.setColor(Color.BLUE);
        dataset_comp1.setDrawFilled(true);
        dataset_comp1.setValueTextColor(Color.TRANSPARENT);

        ArrayList dataSets = new ArrayList();
       dataSets.add(dataset_comp1);

        ArrayList labels = new ArrayList();
        labels.add(getString(R.string.creativity));
        labels.add(getString(R.string.persuasion));
        labels.add(getString(R.string.collaboration));
        labels.add(getString(R.string.adaptability));
        labels.add(getString(R.string.productivity));


        RadarData data = new RadarData(labels, dataSets);
        chart.setData(data);
        String description = "";
        chart.setDescription(description);



    }





}
