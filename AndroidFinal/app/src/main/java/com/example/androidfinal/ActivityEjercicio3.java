package com.example.androidfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class ActivityEjercicio3 extends Fragment {

    private ListView listViewColores;

    private TextView lblResultado;

    private Button btnAceptar, btnSalir;
    private String colorSeleccionado = null;

    public ActivityEjercicio3() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ejercicio3, container, false);

        // Referencias UI
        listViewColores = view.findViewById(R.id.listViewColores);
        btnAceptar = view.findViewById(R.id.button);
        btnSalir = view.findViewById(R.id.button2);
        lblResultado = view.findViewById(R.id.lblResultadoEje3);


        // Adaptador con los colores
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_single_choice,
                Arrays.asList("Rojo", "Azul", "Verde")
        );
        listViewColores.setAdapter(adapter);
        listViewColores.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Selección de color
        listViewColores.setOnItemClickListener((parent, view1, position, id) -> {
            colorSeleccionado = adapter.getItem(position);
        });

        // Botón Aceptar
        btnAceptar.setOnClickListener(v -> {
            if (colorSeleccionado == null) {
                Toast.makeText(getContext(), "Seleccione un color primero", Toast.LENGTH_SHORT).show();
            } else {
                String mensaje = "El color seleccionado es: " + colorSeleccionado;
                lblResultado.setText(mensaje);
            }
        });

        // Botón Salir
        btnSalir.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.activityMenu);
        });

        return view;
    }
}