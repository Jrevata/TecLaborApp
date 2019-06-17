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

public class FragmentQuestion3 extends Fragment {

    private static final String TAG = FragmentQuestion3.class.getSimpleName();

    private String param1;

    RadioButton question_3_1, question_3_2, question_3_3, question_3_4;
    Integer notaColaboracion;
    Button button_colaboracion_next;

    public FragmentQuestion3() {

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
        View view = inflater.inflate(R.layout.fragment_question_3, container, false);
        initializeRadiosCreatividad(view);
        button_colaboracion_next = view.findViewById(R.id.button_colaboracion_next);
        button_colaboracion_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestActivity.test.setColaboracion(notaColaboracion);
                FragmentManager fragmentManager =  getActivity().getSupportFragmentManager();
                // Create FirstFragment
                Fragment fragment = new FragmentQuestion4();

                // Replace content
                fragmentManager.beginTransaction().replace(R.id.relativeLayout_content, fragment).addToBackStack("tag").commit();

            }
        });


        return view;
    }




    private void initializeRadiosCreatividad(View v){

        question_3_1   = v.findViewById(R.id.radio_question_3_1);
        question_3_2       = v.findViewById(R.id.radio_question_3_2);
        question_3_3   = v.findViewById(R.id.radio_question_3_3);
        question_3_4     = v.findViewById(R.id.radio_question_3_4);

        question_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaColaboracion = 1;
                question_3_2.setChecked(false);
                question_3_3.setChecked(false);
                question_3_4.setChecked(false);
            }
        });

        question_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaColaboracion = 2;
                question_3_1.setChecked(false);
                question_3_3.setChecked(false);
                question_3_4.setChecked(false);
            }
        });

        question_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaColaboracion = 3;
                question_3_1.setChecked(false);
                question_3_2.setChecked(false);
                question_3_4.setChecked(false);
            }
        });

        question_3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaColaboracion = 4;
                question_3_1.setChecked(false);
                question_3_2.setChecked(false);
                question_3_3.setChecked(false);
            }
        });


    }

}
