package com.example.androidfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class ActivityEjercicio1 extends Fragment {

    private CheckBox chkPerro, chkGato, chkRaton;
    private Button btnAceptar, btnSalir;
    private TextView lblResultado;

    public ActivityEjercicio1() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ejercicio1, container, false);

        // Referencias UI
        chkPerro = view.findViewById(R.id.chkPerro);
        chkGato = view.findViewById(R.id.chkGato);
        chkRaton = view.findViewById(R.id.chkRaton);
        btnAceptar = view.findViewById(R.id.btnAceptarEje1);
        btnSalir = view.findViewById(R.id.btnSalirEje1);
        lblResultado = view.findViewById(R.id.lblResultadoEje1);

        // Botón Aceptar
        btnAceptar.setOnClickListener(v -> {
            StringBuilder resultado = new StringBuilder("Animales elegidos: ");

            boolean haySeleccion = false;

            if (chkPerro.isChecked()) {
                resultado.append("Perro ");
                haySeleccion = true;
            }
            if (chkGato.isChecked()) {
                resultado.append("Gato ");
                haySeleccion = true;
            }
            if (chkRaton.isChecked()) {
                resultado.append("Ratón ");
                haySeleccion = true;
            }

            if (!haySeleccion) {
                resultado = new StringBuilder("No seleccionaste ningún animal.");
            }

            lblResultado.setText(resultado.toString());
        });

        // Botón Salir
        btnSalir.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.activityMenu);
        });

        return view;
    }
}