package com.example.tareascg;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText editNombre, editApellido, editCorreo, editCelular;
    private ContactoManager contactoManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inicializar ContactoManager
        contactoManager = ContactoManager.getInstance(this);

        editNombre = findViewById(R.id.text1);
        editApellido = findViewById(R.id.text2);
        editCorreo = findViewById(R.id.text3);
        editCelular = findViewById(R.id.text4);
        Button btnRegistrar = findViewById(R.id.registerButton);
        Button btnRegresar = findViewById(R.id.btn_backmain);

        btnRegistrar.setOnClickListener(view -> registrarContacto());
        btnRegresar.setOnClickListener(view -> finish());
    }

    private void registrarContacto() {
        String nombre = editNombre.getText().toString().trim();
        String apellido = editApellido.getText().toString().trim();
        String correo = editCorreo.getText().toString().trim();
        String celular = editCelular.getText().toString().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || celular.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validar formato de email (básico)
        if (!correo.contains("@") || !correo.contains(".")) {
            Toast.makeText(this, "Por favor ingrese un correo válido", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validar que el celular solo contenga números
        if (!celular.matches("\\d+")) {
            Toast.makeText(this, "El celular debe contener solo números", Toast.LENGTH_SHORT).show();
            return;
        }

        Contacto nuevoContacto = new Contacto(nombre, apellido, correo, celular);
        
        // Guardar en la base de datos
        long resultado = contactoManager.getContactoDAO().insertarContacto(nuevoContacto);
        
        if (resultado != -1) {
            Toast.makeText(this, "Contacto registrado exitosamente", Toast.LENGTH_SHORT).show();
            limpiarCampos();
            finish();
        } else {
            Toast.makeText(this, "Error al registrar el contacto", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        editNombre.setText("");
        editApellido.setText("");
        editCorreo.setText("");
        editCelular.setText("");
    }
}
