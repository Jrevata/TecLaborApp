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

public class FragmentQuestion4 extends Fragment {

    private static final String TAG = FragmentQuestion4.class.getSimpleName();

    private String param1;

    RadioButton question_4_1, question_4_2, question_4_3, question_4_4;
    Integer notaAdaptabilidad;
    Button button_adaptabilidad_next;

    public FragmentQuestion4() {

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
        View view = inflater.inflate(R.layout.fragment_question_4, container, false);
        initializeRadiosCreatividad(view);
        button_adaptabilidad_next = view.findViewById(R.id.button_adaptabilidad_next);
        button_adaptabilidad_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestActivity.test.setAdaptabilidad(notaAdaptabilidad);

                FragmentManager fragmentManager =  getActivity().getSupportFragmentManager();
                // Create FirstFragment
                Fragment fragment = new FragmentQuestion5();

                // Replace content
                fragmentManager.beginTransaction().replace(R.id.relativeLayout_content, fragment).addToBackStack("tag").commit();

            }
        });



        return view;
    }




    private void initializeRadiosCreatividad(View v){

        question_4_1   = v.findViewById(R.id.radio_question_4_1);
        question_4_2       = v.findViewById(R.id.radio_question_4_2);
        question_4_3   = v.findViewById(R.id.radio_question_4_3);
        question_4_4     = v.findViewById(R.id.radio_question_4_4);

        question_4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaAdaptabilidad = 1;
                question_4_2.setChecked(false);
                question_4_3.setChecked(false);
                question_4_4.setChecked(false);
            }
        });

        question_4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaAdaptabilidad = 2;
                question_4_1.setChecked(false);
                question_4_3.setChecked(false);
                question_4_4.setChecked(false);
            }
        });

        question_4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaAdaptabilidad = 3;
                question_4_1.setChecked(false);
                question_4_2.setChecked(false);
                question_4_4.setChecked(false);
            }
        });

        question_4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaAdaptabilidad = 4;
                question_4_1.setChecked(false);
                question_4_2.setChecked(false);
                question_4_3.setChecked(false);
            }
        });


    }

}