package com.jrevata.teclaborapp.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.jrevata.teclaborapp.R;
import com.jrevata.teclaborapp.fragments.FragmentQuestion1;
import com.jrevata.teclaborapp.models.Test;

public class TestActivity extends AppCompatActivity {

    public static Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        test = new Test();
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Create FirstFragment
        Fragment fragment = new FragmentQuestion1();
        // Replace content
        fragmentManager.beginTransaction().replace(R.id.relativeLayout_content,
                fragment).addToBackStack("tag").commit();
    }





}
