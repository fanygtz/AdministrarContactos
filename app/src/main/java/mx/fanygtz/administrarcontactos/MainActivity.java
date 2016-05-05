package mx.fanygtz.administrarcontactos;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    public TextInputLayout LyNombreCompleto;
    public TextInputLayout LyTelefono;
    public TextInputLayout LyEmail;
    public TextInputLayout LyDescripcionContacto;
    public TextInputEditText Enombre;

    public DatePicker FechaNacimiento;
    public Button Siguiente;
    public int dia;
    public int mes;
    public int anio;
    protected static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LyNombreCompleto = (TextInputLayout) findViewById(R.id.layoutNombreCompleto);
        LyTelefono = (TextInputLayout) findViewById(R.id.layoutTelefono);
        LyEmail = (TextInputLayout) findViewById(R.id.layoutEmail);
        LyDescripcionContacto = (TextInputLayout) findViewById(R.id.layoutDescripcionContacto);
        FechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);
        Siguiente = (Button) findViewById(R.id.btnSiguiente);


    }

    public void siguienteAct(View v) {

         Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
         intent.putExtra(getResources().getString(R.string.pnombre), LyNombreCompleto.getEditText().getText().toString().trim());
         intent.putExtra(getResources().getString(R.string.ptelefono), LyTelefono.getEditText().getText().toString().trim());
         intent.putExtra(getResources().getString(R.string.pemail), LyEmail.getEditText().getText().toString().trim());
         intent.putExtra(getResources().getString(R.string.pdescripcion), LyDescripcionContacto.getEditText().getText().toString().trim());
         intent.putExtra(getResources().getString(R.string.pdia), FechaNacimiento.getDayOfMonth());
         intent.putExtra(getResources().getString(R.string.pmes), FechaNacimiento.getMonth());
         intent.putExtra(getResources().getString(R.string.panio), FechaNacimiento.getYear());
        /*
             * Inicia una actividad que devolverá un resultado cuando
             * haya terminado. Cuando la actividad termina, se llama al método
             * onActivityResult() con el requestCode dado.
             * El uso de un requestCode negativo es lo mismo que llamar a
             * startActivity(intent) (la actividad no se iniciará como una
             * sub-actividad).
             */
           startActivityForResult(intent, REQUEST_CODE);
         //startActivity(intent);

    }

    /*
    * Éste método se llama cuando la actividad que iniciamos con un startActivityForResult
    * finaliza, dando el REQUEST_CODE con el que llamó, el resultCode se devuelve, junto con
    * algunos datos adicionales, el resultCode será RESULT_CANCELED si la actividad devuelve
    * eso explícitamente, si no devuelve ningún resultado o si la operación finalizó de forma inesperada.
    */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            // cogemos el valor devuelto por la otra actividad
            LyNombreCompleto.getEditText().setText(data.getStringExtra(getResources().getString(R.string.pnombre)));
            LyTelefono.getEditText().setText(data.getStringExtra(getResources().getString(R.string.ptelefono)));
            LyEmail.getEditText().setText(data.getStringExtra(getResources().getString(R.string.pemail)));
            LyDescripcionContacto.getEditText().setText(data.getStringExtra(getResources().getString(R.string.pdescripcion)));
            dia = data.getIntExtra(getResources().getString(R.string.pdia),0);
            mes = data.getIntExtra(getResources().getString(R.string.pmes),0);
            anio = data.getIntExtra(getResources().getString(R.string.panio),0);
            FechaNacimiento.updateDate(anio,mes,dia);

        }
    }





}
