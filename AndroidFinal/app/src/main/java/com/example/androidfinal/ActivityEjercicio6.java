package com.example.androidfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ActivityEjercicio6 extends Fragment {

    private Spinner cboNumeros;
    private TextView lblResul;
    private Button btnPares, btnImpares, butVaciar, butSalir;

    public ActivityEjercicio6() {
        // Constructor requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ejercicio6, container, false);

        // Referencias UI
        cboNumeros = view.findViewById(R.id.cboNumeros);
        lblResul = view.findViewById(R.id.lblResul);
        btnPares = view.findViewById(R.id.btnPares);
        btnImpares = view.findViewById(R.id.btnImpares);
        butVaciar = view.findViewById(R.id.butVaciar);
        butSalir = view.findViewById(R.id.butSalir);

        // Evento botón Pares
        btnPares.setOnClickListener(v -> {
            List<String> pares = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    pares.add(String.valueOf(i));
                }
            }
            llenarSpinner(pares);
        });

        // Evento botón Impares
        btnImpares.setOnClickListener(v -> {
            List<String> impares = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    impares.add(String.valueOf(i));
                }
            }
            llenarSpinner(impares);
        });

        // Evento selección del Spinner
        cboNumeros.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                String numero = parent.getItemAtPosition(position).toString();
                lblResul.setText("Número seleccionado: " + numero);
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
                // No hacer nada
            }
        });

        // Botón Vaciar
        butVaciar.setOnClickListener(v -> {
            cboNumeros.setAdapter(null);
            lblResul.setText("");
        });

        // Botón Salir
        butSalir.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.activityMenu);
        });

        return view;
    }

    private void llenarSpinner(List<String> numeros) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_item, numeros);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cboNumeros.setAdapter(adapter);
    }
}