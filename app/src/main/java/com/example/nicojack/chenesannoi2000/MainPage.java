package com.example.nicojack.chenesannoi2000;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainPage extends AppCompatActivity {




    public String printArray(String[] ar){
        String res = "";
        res += "[";
        for(int i = 0; i < ar.length; i++){
            res += ar[i] + ", ";
            if (i == ar.length - 1){
                res += ar[i];
            }

        }
        res += "]";
        return res;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page); //mostra il contunuto del layout all'interno della cartella res/layout
        final TextView domanda = (TextView) findViewById(R.id.domanda);
        final Button r1 = (Button) findViewById(R.id.r1); //dichiaro la variabile di tipo bottone e importa l'oggetto dal layout
        final Button r2 = (Button) findViewById(R.id.r2);
        final Button r3 = (Button) findViewById(R.id.r3);
        final Button r4 = (Button) findViewById(R.id.r4);
        final TextView debug = (TextView) findViewById(R.id.counter);
        Resources res = getResources(); //creo l'oggetto resources che i consente di accedere a tutti gli array creati in XML
        final Toast toastv = Toast.makeText(getApplicationContext(), "HAI VINTO", Toast.LENGTH_LONG);
        final Toast toastp = Toast.makeText(getApplicationContext(), "HAI PERSO", Toast.LENGTH_LONG);
        final String[] domande = res.getStringArray(R.array.domande); //importo l'array delle domande
        final String[] risposte = res.getStringArray(R.array.risposte); //importo l'array delle riposte
        final ImageView immagine = (ImageView) findViewById(R.id.immagine);
        final Intent i =new Intent(this,FineGioco.class);
        final TextView time = (TextView) findViewById(R.id.time);
        final Toast temposcaduto = Toast.makeText(getApplicationContext(),"TEMPO SCADUTO",Toast.LENGTH_LONG);
        TypedArray immagini = getResources().obtainTypedArray(R.array.random_imgs);
        final InterfacciaPrincipale interfaccia = new InterfacciaPrincipale(r1, r2, r3, r4, domanda, domande, risposte,immagine, immagini );
        interfaccia.inizializzaInterfaccia();

        final CountDownTimer timer = new CountDownTimer(15000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                time.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                temposcaduto.show();
                interfaccia.inizializzaInterfaccia();
                start();


            }
        }.start();






        r1.setOnClickListener(new View.OnClickListener() { //uso il metodo onclicklistener che serve per controllare quando il pulsante viene premuto
            @Override
            public void onClick(View v) { //qui dentro scrivo cosa deve succedere quand il pulsante viene cliccato
                if (interfaccia.controllaRisposta(r1.getText().toString())) {

                    toastv.show();
                } else {
                    toastp.show();
                }

                if (interfaccia.finePartita()){
                    startActivity(i);
                }
                else
                {
                interfaccia.inizializzaInterfaccia();
                timer.start();}



            }
        });


        r2.setOnClickListener(new View.OnClickListener() { //uso il metodo onclicklistener che serve per controllare quando il pulsante viene premuto
            @Override
            public void onClick(View v) { //qui dentro scrivo cosa deve succedere quand il pulsante viene cliccato
                if (interfaccia.controllaRisposta(r2.getText().toString())) {
                    toastv.show();
                } else {
                    toastp.show();
                }
                if (interfaccia.finePartita()){
                    startActivity(i);
                }
                else{
                interfaccia.inizializzaInterfaccia();
                timer.start();}


            }
        });


        r3.setOnClickListener(new View.OnClickListener() { //uso il metodo onclicklistener che serve per controllare quando il pulsante viene premuto
            @Override
            public void onClick(View v) { //qui dentro scrivo cosa deve succedere quand il pulsante viene cliccato
                if (interfaccia.controllaRisposta(r3.getText().toString())) {
                    toastv.show();
                } else {
                    toastp.show();
                }
                if (interfaccia.finePartita()){
                    startActivity(i);
                }
                else
                {
                interfaccia.inizializzaInterfaccia();
                timer.start();}

            }
        });


        r4.setOnClickListener(new View.OnClickListener() { //uso il metodo onclicklistener che serve per controllare quando il pulsante viene premuto
            @Override
            public void onClick(View v) { //qui dentro scrivo cosa deve succedere quand il pulsante viene cliccato
                if (interfaccia.controllaRisposta(r4.getText().toString())) {
                    toastv.show();

                } else {
                    toastp.show();
                }
                if (interfaccia.finePartita()){
                    startActivity(i);
                }
                else{
                interfaccia.inizializzaInterfaccia();
                timer.start();}

            }
        });







        }

    }

