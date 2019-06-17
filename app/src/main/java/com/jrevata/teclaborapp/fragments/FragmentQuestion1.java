package com.jrevata.teclaborapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.jrevata.teclaborapp.R;
import com.jrevata.teclaborapp.activities.TestActivity;

public class FragmentQuestion1 extends Fragment {

    private static final String TAG = FragmentQuestion1.class.getSimpleName();

    private String param1;

    RadioButton question_1_1, question_1_2, question_1_3, question_1_4;
    Integer notaCreatividad;

    Button button_creative_next;


    public FragmentQuestion1() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");

        // Get argument param1 if exists
        if (getArguments() != null) {
            this.param1 = getArguments().getString("param1");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_question_1, container, false);
        initializeRadiosCreatividad(view);

        button_creative_next = view.findViewById(R.id.button_creative_next);
        button_creative_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestActivity.test.setCreatividad(notaCreatividad);
                FragmentManager fragmentManager =  getActivity().getSupportFragmentManager();
                // Create FirstFragment
                Fragment fragment = new FragmentQuestion2();

                // Replace content
                fragmentManager.beginTransaction().replace(R.id.relativeLayout_content, fragment).addToBackStack("tag").commit();
            }
        });



        return view;
    }




    private void initializeRadiosCreatividad(View v){

        question_1_1   = v.findViewById(R.id.radio_question_1_1);
        question_1_2       = v.findViewById(R.id.radio_question_1_2);
        question_1_3   = v.findViewById(R.id.radio_question_1_3);
        question_1_4     = v.findViewById(R.id.radio_question_1_4);

        question_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaCreatividad = 1;
                question_1_2.setChecked(false);
                question_1_3.setChecked(false);
                question_1_4.setChecked(false);
            }
        });

        question_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaCreatividad = 2;
                question_1_1.setChecked(false);
                question_1_3.setChecked(false);
                question_1_4.setChecked(false);
            }
        });

        question_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaCreatividad = 3;
                question_1_1.setChecked(false);
                question_1_2.setChecked(false);
                question_1_4.setChecked(false);
            }
        });

        question_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaCreatividad = 4;
                question_1_1.setChecked(false);
                question_1_2.setChecked(false);
                question_1_3.setChecked(false);
            }
        });


    }




}
