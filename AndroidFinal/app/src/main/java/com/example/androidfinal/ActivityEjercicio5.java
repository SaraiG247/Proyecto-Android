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

import java.util.Arrays;
import java.util.List;


public class ActivityEjercicio5 extends Fragment {

    private ListView lstNombres;
    private TextView lblResultado;
    private Button btnCurso1, btnCurso2, btnVaciar, btnCerrar;
    private ArrayAdapter<String> adapter;

    public ActivityEjercicio5() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_ejercicio5, container, false);

        // Referencias UI
        lstNombres = view.findViewById(R.id.lstNombresEje5);
        lblResultado = view.findViewById(R.id.lblResultadoEje5);
        btnCurso1 = view.findViewById(R.id.btnCurso1Eje5);
        btnCurso2 = view.findViewById(R.id.btnCurso2Eje5);
        btnVaciar = view.findViewById(R.id.btnVaciarEje5);
        btnCerrar = view.findViewById(R.id.btnCerrarEje5);

        // Inicializar adaptador
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1);
        lstNombres.setAdapter(adapter);

        // Botón Curso 1
        btnCurso1.setOnClickListener(v -> cargarNombres(Arrays.asList("Juan", "Maria", "Luis")));

        // Botón Curso 2
        btnCurso2.setOnClickListener(v -> cargarNombres(Arrays.asList("Ana", "Martha", "Jose")));

        // Botón Vaciar
        btnVaciar.setOnClickListener(v -> {
            adapter.clear();
            lblResultado.setText("");
        });

        // Botón Cerrar
        btnCerrar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.activityMenu);
        });

        // Click en item de lista
        lstNombres.setOnItemClickListener((parent, view1, position, id) -> {
            String seleccionado = adapter.getItem(position);
            lblResultado.setText(seleccionado);
        });

        return view;
    }

    private void cargarNombres(List<String> nombres) {
        adapter.clear();
        adapter.addAll(nombres);
        adapter.notifyDataSetChanged();
    }
}