package com.example.androidfinal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMenu extends Fragment {

    public FragmentMenu() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_menu, container, false);




    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configura botones para navegar a los ejercicios
        view.findViewById(R.id.eje1).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityEjercicio1));

        view.findViewById(R.id.eje2).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityEjercicio2));

        view.findViewById(R.id.eje3).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityEjercicio3));

        view.findViewById(R.id.eje4).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityEjercicio4));

        view.findViewById(R.id.eje5).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityEjercicio5));

        view.findViewById(R.id.eje6).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityEjercicio6));

        view.findViewById(R.id.eje7).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityEjercicio7));

        view.findViewById(R.id.eje8).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityEjercicio8));

        view.findViewById(R.id.eje9).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityEjercicio9));

        view.findViewById(R.id.eje10).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityEjercicio_10));

        view.findViewById(R.id.btnCerrarMenu).setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.activityLogin));

    }
}