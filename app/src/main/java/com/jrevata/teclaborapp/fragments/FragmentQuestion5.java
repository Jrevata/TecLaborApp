package com.jrevata.teclaborapp.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.jrevata.teclaborapp.R;
import com.jrevata.teclaborapp.activities.MainActivity;
import com.jrevata.teclaborapp.activities.TestActivity;
import com.jrevata.teclaborapp.models.Usuario;
import com.jrevata.teclaborapp.repositories.TestRepository;
import com.jrevata.teclaborapp.repositories.UsuarioRepository;

import java.util.Calendar;
import java.util.Date;

public class FragmentQuestion5 extends Fragment {

    private static final String TAG = FragmentQuestion5.class.getSimpleName();

    private String param1;

    RadioButton question_5_1, question_5_2, question_5_3, question_5_4;
    Integer notaProductividad;
    Button button_produccion_next;

    public FragmentQuestion5() {

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
        View view = inflater.inflate(R.layout.fragment_question_5, container, false);
        initializeRadiosCreatividad(view);
        button_produccion_next = view.findViewById(R.id.button_produccion_next);
        button_produccion_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showTitleDialog();
            }
        });



        return view;
    }


    private void showTitleDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),  R.style.AlertDialogTheme);
        builder.setTitle("Asígnale un nombre al Test");
// I'm using fragment here so I'm using getView() to provide ViewGroup
// but you can provide here any other instance of ViewGroup from your Fragment / Activity
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_title_test, (ViewGroup) getView(), false);
// Set up the input
        final EditText input = (EditText) viewInflated.findViewById(R.id.input_title);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        builder.setView(viewInflated);

// Set up the buttons
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                TestActivity.test.setNombre(input.getText().toString());
                TestActivity.test.setUsuario(UsuarioRepository.getUser().getUsuario());
                TestActivity.test.setFecha(Calendar.getInstance().getTime());
                TestActivity.test.setProductividad(notaProductividad);
                TestActivity.test.setEmpleabilidad();
                TestRepository.createTest(TestActivity.test);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    private void initializeRadiosCreatividad(View v){

        question_5_1   = v.findViewById(R.id.radio_question_5_1);
        question_5_2       = v.findViewById(R.id.radio_question_5_2);
        question_5_3   = v.findViewById(R.id.radio_question_5_3);
        question_5_4     = v.findViewById(R.id.radio_question_5_4);

        question_5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaProductividad = 1;
                question_5_2.setChecked(false);
                question_5_3.setChecked(false);
                question_5_4.setChecked(false);
            }
        });

        question_5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaProductividad = 2;
                question_5_1.setChecked(false);
                question_5_3.setChecked(false);
                question_5_4.setChecked(false);
            }
        });

        question_5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaProductividad = 3;
                question_5_1.setChecked(false);
                question_5_2.setChecked(false);
                question_5_4.setChecked(false);
            }
        });

        question_5_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaProductividad = 4;
                question_5_1.setChecked(false);
                question_5_2.setChecked(false);
                question_5_3.setChecked(false);
            }
        });


    }

}
