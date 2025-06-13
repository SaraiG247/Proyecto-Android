package com.example.androidfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ActivityEjercicio_10 extends Fragment {

    private SeekBar desValor;
    private TextView lblValor;
    private Button btnCerrar;

    public ActivityEjercicio_10() {
        // Constructor vacío requerido
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout
        View view = inflater.inflate(R.layout.activity_ejercicio_10, container, false); // Cambia por el nombre real

        desValor = view.findViewById(R.id.desValor);
        lblValor = view.findViewById(R.id.lblValor);
        btnCerrar = view.findViewById(R.id.btnCerrar);

        lblValor.setText("El valor es: " + desValor.getProgress());

        desValor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lblValor.setText("El valor es: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        btnCerrar.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}
