package com.raccoon.gestorc3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistroActivity extends AppCompatActivity {

    private EditText cedula, nombres, apellidos, edad;
    private RatingBar ratingNivelIngles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //conf spíners
        Spinner spinnerNacionalidad = findViewById(R.id.spinnerNacionalidad);
        Spinner spinnerGenero = findViewById(R.id.spinnerGenero);


        ArrayAdapter<CharSequence> nacionalidadAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.nacionalidad_array,
                android.R.layout.simple_spinner_item);
        nacionalidadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNacionalidad.setAdapter(nacionalidadAdapter);

        ArrayAdapter <CharSequence> generoAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.genero_array,
                android.R.layout.simple_spinner_item
        );

        generoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenero.setAdapter(generoAdapter);

        //configurando los botones

        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        Button btnCancelar = findViewById(R.id.button2);
        Button btnBorrar = findViewById(R.id.button3);

        //boton registrar
        btnRegistrar.setOnClickListener(v -> {
            //obtener los datos de los campos de texto
            String datos = "Cedula" +cedula.getText().toString() +
                    "\nNombres" +nombres.getText().toString() +
                    "\nApellidos" +apellidos.getText().toString() +
                    "\nEdad" +edad.getText().toString() +
                    "\nNacionalidad" +spinnerNacionalidad.getSelectedItem().toString() +
                    "\nGenero" +spinnerGenero.getSelectedItem().toString() +
                    "\nNivel de Ingles" +ratingNivelIngles.getRating();

            //MOSTRAMOS LOS DATOS EN EL LOGCAT CONSOLA
            Log.d("Datos", datos);
            Toast.makeText(this, "Datos registrados", Toast.LENGTH_SHORT).show();
        });

        //boton borrar
        btnBorrar.setOnClickListener(view -> {
            //limpiar los campos de texto
            cedula.setText("");
            nombres.setText("");
            apellidos.setText("");
            edad.setText("");
            spinnerNacionalidad.setSelection(0);
            spinnerGenero.setSelection(0);
            ratingNivelIngles.setRating(0);
            Toast.makeText(this, "Campos borrados", Toast.LENGTH_SHORT).show();

        });

        //boton cancelar
        btnCancelar.setOnClickListener(view -> {
            //regresamos al login
            Intent intent = new Intent(this, SplashActivity.class);
        });
    }
}