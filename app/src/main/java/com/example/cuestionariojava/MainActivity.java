package com.example.cuestionariojava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Se declaran los objetos para usarlos
    RadioButton rdOpc1, rdOpc2, rdOpc3, rdOpc4;
    TextView txtNroPregunta, txtPregunta;
    Button btnSiguiente, btnSalir;

    //Se declaran las variables para modificar la pregunta y las opciones, para calcular la puntación
    double nota = 0.0;
    int NroPregunta = 1;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se le asigna a cada objeto el id de lo que va a usar
        rdOpc1 = (RadioButton) findViewById(R.id.rdBtnOpc1);
        rdOpc2 = (RadioButton) findViewById(R.id.rdBtnOpc2);
        rdOpc3 = (RadioButton) findViewById(R.id.rdBtnOpc3);
        rdOpc4 = (RadioButton) findViewById(R.id.rdBtnOpc4);

        txtNroPregunta = (TextView) findViewById(R.id.txtNroPregunta);
        txtPregunta = (TextView) findViewById(R.id.txtPregunta);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        TextView correct = findViewById(R.id.correct);
        correct.setVisibility(View.GONE);

        TextView incorrect = findViewById(R.id.incorrect);
        incorrect.setVisibility(View.GONE);

        //NOTA: Oblicacion leer o si ya sabe no.
        // Las respuestas estan en la a o en el if de cada else if
        // Para poder colocar la respuesta correcta, en las condiciones de if o else-if en donde
        // dice rdOpc1 ese uno se puede cambiar por 2, 3, 4 por cualquiera de esos dos y
        // se debe de llevar tambien el acumulador de nota = nota + 0.5
        // Y para poder cambiar el tiempo de espera para la siguiente pregunta, debes de buscar
        // en el codigo con ctrl + f y pones ahi 500, ese 500 es el tiempo de espera en Milisegundos

    }

    public void siguiente(View v) {
        //if por si no se marca ninguna opcion
        if (rdOpc1.isChecked() == false && rdOpc2.isChecked() == false && rdOpc3.isChecked() == false && rdOpc4.isChecked() == false) {

            Toast.makeText(this, "Elija una opción", Toast.LENGTH_SHORT).show();

        } else if (NroPregunta == 1) {


            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (rdOpc1.isChecked()) {

                rdOpc1.setBackgroundResource(R.drawable.correct);
                TextView correct = findViewById(R.id.correct);
                correct.setVisibility(View.VISIBLE);
                nota = nota + 0.5;

            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc4.isChecked()) {
                rdOpc4.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Se le suma 1 al contador, para pasar de pregunta
                    NroPregunta++;

                    //Se sentean los textos para la siguiente pregunta
                    txtNroPregunta.setText("2/10");
                    txtPregunta.setText("Texto de la pregunta Nro 2");
                    rdOpc1.setText("Opcion 1 p2");
                    rdOpc2.setText("Opcion 2 p2");
                    rdOpc3.setText("Opcion 3 p2");
                    rdOpc4.setText("Opcion 4 p2");

                    //Se limpian los RadiosButtons para la siguiente pregunta
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc4.setChecked(false);

                    //Se limpian los colores
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc4.setBackgroundResource(R.drawable.white);

                    //Coloca un background a las opciones de respuestas
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    rdOpc4.setBackgroundResource(R.drawable.opciones);

                    //Esconde las bonificaciones
                    TextView correct = findViewById(R.id.correct);
                    correct.setVisibility(View.GONE);

                    TextView incorrect = findViewById(R.id.incorrect);
                    incorrect.setVisibility(View.GONE);

                }
            },1000);

        } else if (NroPregunta == 2) {

            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (rdOpc1.isChecked()) {

                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                TextView correct = findViewById(R.id.incorrect);
                correct.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc2.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.correct);
                TextView incorrect = findViewById(R.id.correct);
                incorrect.setVisibility(View.VISIBLE);
                nota = nota + 0.5;


            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc2.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc4.isChecked()) {
                rdOpc4.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc2.setBackgroundResource(R.drawable.correct);
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Se le suma 1 al contador, para pasar de pregunta
                    NroPregunta++;

                    //Se sentean los textos para la siguiente pregunta
                    txtNroPregunta.setText("3/10");
                    txtPregunta.setText("Texto de la pregunta Nro 3");
                    rdOpc1.setText("Opcion 1 p3");
                    rdOpc2.setText("Opcion 2 p3");
                    rdOpc3.setText("Opcion 3 p3");
                    rdOpc4.setText("Opcion 4 p3");

                    //Se limpian los RadiosButtons para la siguiente pregunta
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc4.setChecked(false);

                    //Se limpian los colores
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc4.setBackgroundResource(R.drawable.white);

                    //Coloca un background a las opciones de respuestas
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    rdOpc4.setBackgroundResource(R.drawable.opciones);

                    //Esconde las bonificaciones
                    TextView correct = findViewById(R.id.correct);
                    correct.setVisibility(View.GONE);

                    TextView incorrect = findViewById(R.id.incorrect);
                    incorrect.setVisibility(View.GONE);
                }
            },1000);

        } else if (NroPregunta == 3) {

            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (rdOpc1.isChecked()) {

                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                TextView correct = findViewById(R.id.incorrect);
                correct.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc3.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc3.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.correct);
                TextView incorrect = findViewById(R.id.correct);
                incorrect.setVisibility(View.VISIBLE);
                nota = nota + 0.5;

            } else if (rdOpc4.isChecked()) {
                rdOpc4.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc3.setBackgroundResource(R.drawable.correct);
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Se le suma 1 al contador, para pasar de pregunta
                    NroPregunta++;

                    //Se sentean los textos para la siguiente pregunta
                    txtNroPregunta.setText("4/10");
                    txtPregunta.setText("Texto de la pregunta Nro 4");
                    rdOpc1.setText("Opcion 1 p4");
                    rdOpc2.setText("Opcion 2 p4");
                    rdOpc3.setText("Opcion 3 p4");
                    rdOpc4.setText("Opcion 4 p4");

                    //Se limpian los RadiosButtons para la siguiente pregunta
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc4.setChecked(false);

                    //Se limpian los colores
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc4.setBackgroundResource(R.drawable.white);

                    //Coloca un background a las opciones de respuestas
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    rdOpc4.setBackgroundResource(R.drawable.opciones);

                    //Esconde las bonificaciones
                    TextView correct = findViewById(R.id.correct);
                    correct.setVisibility(View.GONE);

                    TextView incorrect = findViewById(R.id.incorrect);
                    incorrect.setVisibility(View.GONE);
                }
            },1000);

        } else if (NroPregunta == 4) {

            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (rdOpc1.isChecked()) {

                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                TextView correct = findViewById(R.id.incorrect);
                correct.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc2.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.correct);
                TextView incorrect = findViewById(R.id.correct);
                incorrect.setVisibility(View.VISIBLE);

                nota = nota + 0.5;

            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc2.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc4.isChecked()) {
                rdOpc4.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc2.setBackgroundResource(R.drawable.correct);

            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Se le suma 1 al contador, para pasar de pregunta
                    NroPregunta++;

                    //Se sentean los textos para la siguiente pregunta
                    txtNroPregunta.setText("5/10");
                    txtPregunta.setText("Texto de la pregunta Nro 5");
                    rdOpc1.setText("Opcion 1 p5");
                    rdOpc2.setText("Opcion 2 p5");
                    rdOpc3.setText("Opcion 3 p5");
                    rdOpc4.setText("Opcion 4 p5");

                    //Se limpian los RadiosButtons para la siguiente pregunta
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc4.setChecked(false);

                    //Se limpian los colores
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc4.setBackgroundResource(R.drawable.white);

                    //Coloca un background a las opciones de respuestas
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    rdOpc4.setBackgroundResource(R.drawable.opciones);

                    //Esconde las bonificaciones
                    TextView correct = findViewById(R.id.correct);
                    correct.setVisibility(View.GONE);

                    TextView incorrect = findViewById(R.id.incorrect);
                    incorrect.setVisibility(View.GONE);
                }
            },1000);

        } else if (NroPregunta == 5) {

            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (rdOpc1.isChecked()) {

                rdOpc1.setBackgroundResource(R.drawable.correct);
                TextView correct = findViewById(R.id.correct);
                correct.setVisibility(View.VISIBLE);
                nota = nota + 0.5;

            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc4.isChecked()) {
                rdOpc4.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Se le suma 1 al contador, para pasar de pregunta
                    NroPregunta++;

                    //Se sentean los textos para la siguiente pregunta
                    txtNroPregunta.setText("6/10");
                    txtPregunta.setText("Texto de la pregunta Nro 6");
                    rdOpc1.setText("Opcion 1 p6");
                    rdOpc2.setText("Opcion 2 p6");
                    rdOpc3.setText("Opcion 3 p6");
                    rdOpc4.setText("Opcion 4 p6");

                    //Se limpian los RadiosButtons para la siguiente pregunta
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc4.setChecked(false);

                    //Se limpian los colores
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc4.setBackgroundResource(R.drawable.white);

                    //Coloca un background a las opciones de respuestas
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    rdOpc4.setBackgroundResource(R.drawable.opciones);

                    //Esconde las bonificaciones
                    TextView correct = findViewById(R.id.correct);
                    correct.setVisibility(View.GONE);

                    TextView incorrect = findViewById(R.id.incorrect);
                    incorrect.setVisibility(View.GONE);
                }
            },1000);

        } else if (NroPregunta == 6) {

            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (rdOpc1.isChecked()) {

                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                TextView correct = findViewById(R.id.incorrect);
                correct.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc2.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.correct);
                TextView incorrect = findViewById(R.id.correct);
                incorrect.setVisibility(View.VISIBLE);

                nota = nota + 0.5;

            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc2.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc4.isChecked()) {
                rdOpc4.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc2.setBackgroundResource(R.drawable.correct);
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Se le suma 1 al contador, para pasar de pregunta
                    NroPregunta++;

                    //Se sentean los textos para la siguiente pregunta
                    txtNroPregunta.setText("7/10");
                    txtPregunta.setText("Texto de la pregunta Nro 7");
                    rdOpc1.setText("Opcion 1 p7");
                    rdOpc2.setText("Opcion 2 p7");
                    rdOpc3.setText("Opcion 3 p7");
                    rdOpc4.setText("Opcion 4 p7");

                    //Se limpian los RadiosButtons para la siguiente pregunta
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc4.setChecked(false);

                    //Se limpian los colores
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc4.setBackgroundResource(R.drawable.white);

                    //Coloca un background a las opciones de respuestas
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    rdOpc4.setBackgroundResource(R.drawable.opciones);

                    //Esconde las bonificaciones
                    TextView correct = findViewById(R.id.correct);
                    correct.setVisibility(View.GONE);

                    TextView incorrect = findViewById(R.id.incorrect);
                    incorrect.setVisibility(View.GONE);
                }
            },1000);

        } else if (NroPregunta == 7) {

            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (rdOpc1.isChecked()) {

                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                TextView correct = findViewById(R.id.incorrect);
                correct.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc3.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc3.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.correct);
                TextView incorrect = findViewById(R.id.correct);
                incorrect.setVisibility(View.VISIBLE);

                nota = nota + 0.5;

            } else if (rdOpc4.isChecked()) {
                rdOpc4.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc3.setBackgroundResource(R.drawable.correct);
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Se le suma 1 al contador, para pasar de pregunta
                    NroPregunta++;

                    //Se sentean los textos para la siguiente pregunta
                    txtNroPregunta.setText("8/10");
                    txtPregunta.setText("Texto de la pregunta Nro 8");
                    rdOpc1.setText("Opcion 1 p8");
                    rdOpc2.setText("Opcion 2 p8");
                    rdOpc3.setText("Opcion 3 p8");
                    rdOpc4.setText("Opcion 4 p8");

                    //Se limpian los RadiosButtons para la siguiente pregunta
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc4.setChecked(false);

                    //Se limpian los colores
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc4.setBackgroundResource(R.drawable.white);

                    //Coloca un background a las opciones de respuestas
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    rdOpc4.setBackgroundResource(R.drawable.opciones);

                    //Esconde las bonificaciones
                    TextView correct = findViewById(R.id.correct);
                    correct.setVisibility(View.GONE);

                    TextView incorrect = findViewById(R.id.incorrect);
                    incorrect.setVisibility(View.GONE);
                }
            },1000);

        } else if (NroPregunta == 8) {

            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (rdOpc1.isChecked()) {

                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                TextView correct = findViewById(R.id.incorrect);
                correct.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc4.setBackgroundResource(R.drawable.correct);


            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc4.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc4.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc4.isChecked()) {
                rdOpc4.setBackgroundResource(R.drawable.correct);
                TextView incorrect = findViewById(R.id.correct);
                incorrect.setVisibility(View.VISIBLE);

                nota = nota + 0.5;

            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Se le suma 1 al contador, para pasar de pregunta
                    NroPregunta++;

                    //Se sentean los textos para la siguiente pregunta
                    txtNroPregunta.setText("9/10");
                    txtPregunta.setText("Texto de la pregunta Nro 9");
                    rdOpc1.setText("Opcion 1 p9");
                    rdOpc2.setText("Opcion 2 p9");
                    rdOpc3.setText("Opcion 3 p9");
                    rdOpc4.setText("Opcion 4 p9");

                    //Se limpian los RadiosButtons para la siguiente pregunta
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc4.setChecked(false);

                    //Se limpian los colores
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc4.setBackgroundResource(R.drawable.white);

                    //Coloca un background a las opciones de respuestas
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    rdOpc4.setBackgroundResource(R.drawable.opciones);

                    //Esconde las bonificaciones
                    TextView correct = findViewById(R.id.correct);
                    correct.setVisibility(View.GONE);

                    TextView incorrect = findViewById(R.id.incorrect);
                    incorrect.setVisibility(View.GONE);
                }
            },1000);

        } else if (NroPregunta == 9) {

            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (rdOpc1.isChecked()) {

                rdOpc1.setBackgroundResource(R.drawable.correct);
                TextView correct = findViewById(R.id.correct);
                correct.setVisibility(View.VISIBLE);
                nota = nota + 0.5;

            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc4.isChecked()) {
                rdOpc4.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Se le suma 1 al contador, para pasar de pregunta
                    NroPregunta++;

                    //Se sentean los textos para la siguiente pregunta
                    txtNroPregunta.setText("10/10");
                    txtPregunta.setText("Texto de la pregunta Nro 10");
                    rdOpc1.setText("Opcion 1 p10");
                    rdOpc2.setText("Opcion 2 p10");
                    rdOpc3.setText("Opcion 3 p10");
                    rdOpc4.setText("Opcion 4 p10");

                    //Se limpian los RadiosButtons para la siguiente pregunta
                    rdOpc1.setChecked(false);
                    rdOpc2.setChecked(false);
                    rdOpc3.setChecked(false);
                    rdOpc4.setChecked(false);

                    //Se limpian los colores
                    rdOpc1.setBackgroundResource(R.drawable.white);
                    rdOpc2.setBackgroundResource(R.drawable.white);
                    rdOpc3.setBackgroundResource(R.drawable.white);
                    rdOpc4.setBackgroundResource(R.drawable.white);

                    //Coloca un background a las opciones de respuestas
                    rdOpc1.setBackgroundResource(R.drawable.opciones);
                    rdOpc2.setBackgroundResource(R.drawable.opciones);
                    rdOpc3.setBackgroundResource(R.drawable.opciones);
                    rdOpc4.setBackgroundResource(R.drawable.opciones);

                    //Esconde las bonificaciones
                    TextView correct = findViewById(R.id.correct);
                    correct.setVisibility(View.GONE);

                    TextView incorrect = findViewById(R.id.incorrect);
                    incorrect.setVisibility(View.GONE);
                }
            },1000);

        } else if (NroPregunta ==10) {

            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (rdOpc1.isChecked()) {

                rdOpc1.setBackgroundResource(R.drawable.incorrect);
                TextView correct = findViewById(R.id.incorrect);
                correct.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc2.isChecked()) {
                rdOpc2.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);

            } else if (rdOpc3.isChecked()) {
                rdOpc3.setBackgroundResource(R.drawable.correct);
                TextView incorrect = findViewById(R.id.correct);
                incorrect.setVisibility(View.VISIBLE);

                nota = nota + 0.5;

            } else if (rdOpc4.isChecked()) {
                rdOpc4.setBackgroundResource(R.drawable.incorrect);
                TextView incorrect = findViewById(R.id.incorrect);
                incorrect.setVisibility(View.VISIBLE);

                //Colocar el fondo de la opcion correcta
                rdOpc1.setBackgroundResource(R.drawable.correct);
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Se sentean los textos para el resultado de la nota
                    txtNroPregunta.setText("Nota obtenida: " + nota);

                    //if para verificar si se ha aprobado o reprobado
                    if (nota >= 3.0) {

                        txtPregunta.setText("Estado: Aprobado");

                    } else {

                        txtPregunta.setText("Estado: Reprobado");

                    }

                    //Se ocultan las opciones que no se van a usar para poder ver la nota y el resultado
                    rdOpc1.setVisibility(View.GONE);
                    rdOpc2.setVisibility(View.GONE);
                    rdOpc3.setVisibility(View.GONE);
                    rdOpc4.setVisibility(View.GONE);
                    TextView correct = findViewById(R.id.correct);
                    correct.setVisibility(View.GONE);
                    TextView incorrect = findViewById(R.id.incorrect);
                    incorrect.setVisibility(View.GONE);
                    btnSiguiente.setVisibility(View.GONE);
                }
            }, 1000);
        }
    }
    public void Salir(View v) {
        finish();
    }
}
