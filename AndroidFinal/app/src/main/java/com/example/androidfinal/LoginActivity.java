package com.example.androidfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.InputType;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends Fragment {
    private boolean isPasswordVisible = false;

    public LoginActivity() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el layout del fragmento de login
        return inflater.inflate(R.layout.activity_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText email = view.findViewById(R.id.email);
        EditText password = view.findViewById(R.id.password);
        TextView lblError = view.findViewById(R.id.lblError);
        Button btnLogin = view.findViewById(R.id.login);
        ImageButton btnEye = view.findViewById(R.id.imageButton);

        btnEye.setOnClickListener(v -> {
            if (isPasswordVisible) {
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                btnEye.setImageResource(R.drawable.avierto);
            } else {
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                btnEye.setImageResource(R.drawable.cerrado);
            }
            password.setSelection(password.getText().length());
            isPasswordVisible = !isPasswordVisible;
        });

        btnLogin.setOnClickListener(v -> {
            String correo = email.getText().toString().trim();
            String contra = password.getText().toString().trim();

            boolean correoValido = Patterns.EMAIL_ADDRESS.matcher(correo).matches();
            boolean contrasenaCorrecta = contra.equals("tap*2025");

            if (!correoValido && !contrasenaCorrecta) {
                lblError.setText("Correo inválido y contraseña incorrecta");
            } else if (!correoValido) {
                lblError.setText("Correo electrónico inválido");
            } else if (!contrasenaCorrecta) {
                lblError.setText("Contraseña incorrecta");
            } else {
                lblError.setText("");
                Toast.makeText(getContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                // Navegar al fragmentMenu
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.activityMenu);
            }
        });
    }
}