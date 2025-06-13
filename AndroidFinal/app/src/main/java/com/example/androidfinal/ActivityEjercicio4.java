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


public class ActivityEjercicio4 extends Fragment {

    private Spinner cboColores;
    private TextView lblResult;
    private Button buSalir;

    public ActivityEjercicio4() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ejercicio4, container, false);

        // Referencias
        cboColores = view.findViewById(R.id.cboColores);
        lblResult = view.findViewById(R.id.lblResult);
        buSalir = view.findViewById(R.id.buSalir);

        // Lista de colores
        String[] colores = {"Rojo", "Azul", "Verde"};

        // Adaptador para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_spinner_item, colores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cboColores.setAdapter(adapter);

        // Evento de selección del Spinner
        cboColores.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                String colorSeleccionado = parent.getItemAtPosition(position).toString();
                lblResult.setText("Color seleccionado: " + colorSeleccionado);
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
                // Nada por hacer
            }
        });

        // Botón Salir
        buSalir.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityMenu)
        );

        return view;
    }
}