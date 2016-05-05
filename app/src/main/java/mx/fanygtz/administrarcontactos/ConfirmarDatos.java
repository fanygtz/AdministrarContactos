package mx.fanygtz.administrarcontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {
    public String nombre;
    public String telefono;
    public String email;
    public String descripcion;
    public int dia;
    public int mes;
    public int anio;
    private static final int OK_RESULT_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        Bundle parametros = getIntent().getExtras();
        nombre = parametros.getString(getResources().getString(R.string.pnombre));
        telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        email = parametros.getString(getResources().getString(R.string.pemail));
        descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));
        dia = parametros.getInt(getResources().getString(R.string.pdia));
        mes = parametros.getInt(getResources().getString(R.string.pmes));
        anio = parametros.getInt(getResources().getString(R.string.panio));

        TextView tvNombre = (TextView) findViewById(R.id.tvNombreCompleto);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcionContacto);
        TextView tvFecha = (TextView) findViewById(R.id.tvFecha);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
        mes = mes + 1;
        tvFecha.setText(dia + "/" + mes + "/" + anio);

    }

    public void editarDatos(View v){
        mes = mes - 1;
        Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombre), nombre);
        intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
        intent.putExtra(getResources().getString(R.string.pemail), email);
        intent.putExtra(getResources().getString(R.string.pdescripcion),descripcion);
        intent.putExtra(getResources().getString(R.string.pdia), dia);
        intent.putExtra(getResources().getString(R.string.pmes), mes);
        intent.putExtra(getResources().getString(R.string.panio),anio);
        //startActivity(intent);
        setResult(OK_RESULT_CODE, intent);
        finish();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK){
            mes = mes - 1;
            Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
            intent.putExtra(getResources().getString(R.string.pnombre), nombre);
            intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
            intent.putExtra(getResources().getString(R.string.pemail), email);
            intent.putExtra(getResources().getString(R.string.pdescripcion),descripcion);
            intent.putExtra(getResources().getString(R.string.pdia), dia);
            intent.putExtra(getResources().getString(R.string.pmes), mes);
            intent.putExtra(getResources().getString(R.string.panio),anio);
            setResult(OK_RESULT_CODE, intent);
            //startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
