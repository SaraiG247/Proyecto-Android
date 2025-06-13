package com.example.androidfinal;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ActivityEjercicio7 extends Fragment {

    private EditText txtPrecioBase;
    private Button btnInstalacion, btnFormacion, btnAlimentacion, btnCalcular, btnCerrar;
    private TextView lblInstalacion, lblFormacion, lblAlimentacion, lblTotal;

    private boolean selectedInstalacion = false;
    private boolean selectedFormacion = false;
    private boolean selectedAlimentacion = false;

    public ActivityEjercicio7() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ejercicio7, container, false);

        // Referencias UI
        txtPrecioBase = view.findViewById(R.id.txtPrecioEje7);
        btnInstalacion = view.findViewById(R.id.btnInstalacionEje7);
        btnFormacion = view.findViewById(R.id.btnFormacionEje7);
        btnAlimentacion = view.findViewById(R.id.btnAlimentacionEje7);
        btnCalcular = view.findViewById(R.id.btnCalcularEje7);
        btnCerrar = view.findViewById(R.id.btnCerrarEje7);
        lblInstalacion = view.findViewById(R.id.lblInstalacionEje7);
        lblFormacion = view.findViewById(R.id.lblFormacionEje7);
        lblAlimentacion = view.findViewById(R.id.lblAlimentacionEje7);
        lblTotal = view.findViewById(R.id.lblTotalEje7);

        // Lógica de selección/deselección
        btnInstalacion.setOnClickListener(v -> {
            selectedInstalacion = !selectedInstalacion;
            btnInstalacion.setBackgroundColor(selectedInstalacion ?
                    Color.parseColor("#6473BFFF") : Color.parseColor("#4052B6"));
        });

        btnFormacion.setOnClickListener(v -> {
            selectedFormacion = !selectedFormacion;
            btnFormacion.setBackgroundColor(selectedFormacion ?
                    Color.parseColor("#6473BFFF") : Color.parseColor("#4052B6"));
        });

        btnAlimentacion.setOnClickListener(v -> {
            selectedAlimentacion = !selectedAlimentacion;
            btnAlimentacion.setBackgroundColor(selectedAlimentacion ?
                    Color.parseColor("#6473BFFF") : Color.parseColor("#4052B6"));
        });

        // Lógica de cálculo
        btnCalcular.setOnClickListener(v -> {
            String precioBaseStr = txtPrecioBase.getText().toString().trim();
            if (precioBaseStr.isEmpty()) {
                Toast.makeText(getContext(), "Ingrese el precio base", Toast.LENGTH_SHORT).show();
                return;
            }

            double total = 0;
            try {
                total += Double.parseDouble(precioBaseStr);
                if (selectedInstalacion)
                    total += Double.parseDouble(lblInstalacion.getText().toString());
                if (selectedFormacion)
                    total += Double.parseDouble(lblFormacion.getText().toString());
                if (selectedAlimentacion)
                    total += Double.parseDouble(lblAlimentacion.getText().toString());

                lblTotal.setText("Total: $" + total);
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show();
            }
        });

        btnCerrar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.activityMenu);
        });

        return view;
    }
}