package com.example.tareascg;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText editNombre, editApellido, editCorreo, editCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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

        Contacto nuevoContacto = new Contacto(nombre, apellido, correo, celular);
        ContactsActivity.agregarContacto(nuevoContacto);
        Toast.makeText(this, "Contacto registrado exitosamente", Toast.LENGTH_SHORT).show();
        
        limpiarCampos();
        finish();
    }

    private void limpiarCampos() {
        editNombre.setText("");
        editApellido.setText("");
        editCorreo.setText("");
        editCelular.setText("");
    }
}
