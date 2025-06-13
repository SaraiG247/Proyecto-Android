package com.example.androidfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class ActivityEjercicio8 extends Fragment {

    private SeekBar slDeslizador;
    private TextView lblValorEje8;

    public ActivityEjercicio8() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflamos el layout
        View view = inflater.inflate(R.layout.activity_ejercicio8, container, false);

        // Referencias
        slDeslizador = view.findViewById(R.id.slDeslizador);
        lblValorEje8 = view.findViewById(R.id.lblValorEje8);
        Button btnCerrar = view.findViewById(R.id.btnCerrarEje8);

        // Listener para el SeekBar
        slDeslizador.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int valor = progress + 100;
                lblValorEje8.setText("El valor es: " + valor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // No se usa
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // No se usa
            }
        });

        btnCerrar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.activityMenu);
        });

        return view;
    }
}