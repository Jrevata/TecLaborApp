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

public class FragmentQuestion2 extends Fragment {

    private static final String TAG = FragmentQuestion2.class.getSimpleName();

    private String param1;

    RadioButton question_2_1, question_2_2, question_2_3, question_2_4;
    Integer notaPersuasion;
    Button button_persuasion_next;

    public FragmentQuestion2() {

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
        View view = inflater.inflate(R.layout.fragment_question_2, container, false);
        initializeRadiosCreatividad(view);
        button_persuasion_next = view.findViewById(R.id.button_persuasion_next);

        button_persuasion_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestActivity.test.setPersuasion(notaPersuasion);
                FragmentManager fragmentManager =  getActivity().getSupportFragmentManager();
                // Create FirstFragment
                Fragment fragment = new FragmentQuestion3();

                // Replace content
                fragmentManager.beginTransaction().replace(R.id.relativeLayout_content, fragment).addToBackStack("tag").commit();

            }
        });



        return view;
    }




    private void initializeRadiosCreatividad(View v){

        question_2_1   = v.findViewById(R.id.radio_question_2_1);
        question_2_2       = v.findViewById(R.id.radio_question_2_2);
        question_2_3   = v.findViewById(R.id.radio_question_2_3);
        question_2_4     = v.findViewById(R.id.radio_question_2_4);

        question_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaPersuasion = 1;
                question_2_2.setChecked(false);
                question_2_3.setChecked(false);
                question_2_4.setChecked(false);
            }
        });

        question_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaPersuasion = 2;
                question_2_1.setChecked(false);
                question_2_3.setChecked(false);
                question_2_4.setChecked(false);
            }
        });

        question_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaPersuasion = 3;
                question_2_1.setChecked(false);
                question_2_2.setChecked(false);
                question_2_4.setChecked(false);
            }
        });

        question_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaPersuasion = 4;
                question_2_1.setChecked(false);
                question_2_2.setChecked(false);
                question_2_3.setChecked(false);
            }
        });


    }



}
