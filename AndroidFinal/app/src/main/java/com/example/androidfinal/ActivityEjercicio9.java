package com.example.androidfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ActivityEjercicio9 extends Fragment {


    private Button btnAumentar, btnReducir, btnCerrar;
    private EditText spiValor;
    private TextView lblValor;
    private int valor = 0;

    public ActivityEjercicio9() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_ejercicio9, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Referenciar vistas
        btnAumentar = view.findViewById(R.id.btnAumentar);
        btnReducir = view.findViewById(R.id.btnReducir);
        btnCerrar = view.findViewById(R.id.btnCerrar);
        spiValor = view.findViewById(R.id.spiValor);
        lblValor = view.findViewById(R.id.lblValor);

        // Inicializar valor en 0
        actualizarSpiYLabel();

        btnAumentar.setOnClickListener(v -> {
            if (valor + 2 <= 10) {
                valor += 2;
                actualizarSpiYLabel();
            }
        });

        btnReducir.setOnClickListener(v -> {
            if (valor - 2 >= 0) {
                valor -= 2;
                actualizarSpiYLabel();
            }
        });

        spiValor.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String texto = spiValor.getText().toString().trim();
                if (!TextUtils.isEmpty(texto)) {
                    try {
                        int nuevoValor = Integer.parseInt(texto);
                        if (nuevoValor >= 0 && nuevoValor <= 10) {
                            valor = nuevoValor;
                            actualizarLabel();
                        } else {
                            lblValor.setText(""); // No válido
                        }
                    } catch (NumberFormatException e) {
                        lblValor.setText(""); // Entrada inválida
                    }
                }
            }
        });

        btnCerrar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.activityMenu);
        });
    }

    private void actualizarSpiYLabel() {
        spiValor.setText(String.valueOf(valor));
        actualizarLabel();
    }

    private void actualizarLabel() {
        if (valor >= 0 && valor <= 10) {
            lblValor.setText("El valor es: " + valor);
        } else {
            lblValor.setText("");
        }
    }
}
