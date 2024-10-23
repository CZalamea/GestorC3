package com.raccoon.gestorc3;

import android.os.Bundle;

import android.widget.Button;

import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final String Usuario = "usuario";
    private final String Clave = "clave";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //modo edge to edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // mapeando a los elemetos el activity_main.xml
        TextInputEditText editTextUsuario = findViewById(R.id.Usuario);
        TextInputEditText editTextClave = findViewById(R.id.Clave);
        Button botonLogin = findViewById(R.id.button);

        //evento del login
        botonLogin.setOnClickListener(v -> {
            //obtener los datos del usuario
            String usuario = Objects.requireNonNull(editTextUsuario.getText()).toString();
            String clave = Objects.requireNonNull(editTextClave.getText()).toString();

            //validar los datos
            if (usuario.equals(Usuario) && clave.equals(Clave)) {
                //datos correctos -> ingresa
                Toast.makeText(MainActivity.this, "Acceso Concedido", Toast.LENGTH_SHORT).show();
            }else{
                //datos incorrectos -> no ingresa
                Toast.makeText(MainActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }

        });
    }

}