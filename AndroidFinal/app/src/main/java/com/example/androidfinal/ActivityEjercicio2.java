package com.example.androidfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class ActivityEjercicio2 extends Fragment {

    private RadioButton bgRojo, bgVerde, bgAzul;
    private TextView lblValor;

    public ActivityEjercicio2() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ejercicio2, container, false);

        // Referencias
        bgRojo = view.findViewById(R.id.bgRojoEje2);
        bgVerde = view.findViewById(R.id.bgVerdeEje2);
        bgAzul = view.findViewById(R.id.bgAzulEje2);
        lblValor = view.findViewById(R.id.lblValorEje2);
        Button btnAceptar = view.findViewById(R.id.btnAceptarEje2);
        Button btnCerrar = view.findViewById(R.id.btnCerrarEje2);

        // Lógica para el botón Aceptar
        btnAceptar.setOnClickListener(v -> {
            String colorSeleccionado = "";

            if (bgRojo.isChecked()) {
                colorSeleccionado = "Rojo";
            } else if (bgVerde.isChecked()) {
                colorSeleccionado = "Verde";
            } else if (bgAzul.isChecked()) {
                colorSeleccionado = "Azul";
            }

            if (!colorSeleccionado.isEmpty()) {
                lblValor.setText("El color elegido es: " + colorSeleccionado);
            } else {
                lblValor.setText("Por favor selecciona un color");
            }
        });

        btnCerrar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.activityMenu);
        });

        return view;
    }
}