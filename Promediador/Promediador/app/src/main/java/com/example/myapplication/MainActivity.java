  package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

  public class MainActivity extends AppCompatActivity {

      float promedio=0, sumatoriaParcial=0,Resultado=0;
      TextView numMaterias,promedioTxt,titulo;
      EditText CuadroDeTexto;
      int acumulacion=0, parcial=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numMaterias = findViewById(R.id.textViewAcumuladas);
        titulo = findViewById(R.id.textViewParcial);
        CuadroDeTexto=findViewById(R.id.editTextC);
        promedioTxt = findViewById(R.id.textViewPromedio);
    }
    public void Sumar (View view){
        try {
            if (11>Integer.parseInt(CuadroDeTexto.getText().toString())) {

                acumulacion = acumulacion + 1;
                promedio = (promedio + Float.parseFloat(CuadroDeTexto.getText().toString())) / acumulacion;
                numMaterias.setText(String.valueOf(acumulacion));
                promedioTxt.setText(String.valueOf(promedio));
                CuadroDeTexto.setText("");
                if (6>Integer.parseInt(CuadroDeTexto.getText().toString())){Toast.makeText(getApplicationContext(), "A extra papu", Toast.LENGTH_LONG).show(); }
            }else{Toast.makeText(getApplicationContext(), "Solo se puede ingresar numeros del rango del 1 al 10", Toast.LENGTH_SHORT).show();}

        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), "Ingrese numeros, no letras", Toast.LENGTH_SHORT).show();
        }
    }

    public void S(View view){
        acumulacion=0;
        numMaterias.setText(String.valueOf(acumulacion));
        sumatoriaParcial = sumatoriaParcial +promedio;
        promedio=0;
        promedioTxt.setText(String.valueOf(promedio));

        if (parcial==3){
            Resultado= sumatoriaParcial /parcial;
            Toast.makeText(getApplicationContext(), "Calificacion del semestre: "+Resultado, Toast.LENGTH_LONG).show();
        }
        parcial=parcial+1;
        titulo.setText("Parcial numero: "+parcial);
    }
}