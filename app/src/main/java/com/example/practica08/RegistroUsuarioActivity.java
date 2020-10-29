package com.example.practica08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practica08.entidades.ConexionSQLiteHelper;
import com.example.practica08.utilidades.Utilidades;

public class RegistroUsuarioActivity extends AppCompatActivity {
    EditText campoId, campoNombre, campoTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);
        campoId = (EditText) findViewById(R.id.campoId);
        campoNombre = (EditText) findViewById(R.id.campoNombre);
        campoTelefono = (EditText) findViewById(R.id.campoTelefono);
    }

    public void OnClick(View view){
        registrarUsuariosSQL();
    }

    private void registrarUsuariosSQL(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());
        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);
        Toast.makeText(getApplicationContext(), "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}