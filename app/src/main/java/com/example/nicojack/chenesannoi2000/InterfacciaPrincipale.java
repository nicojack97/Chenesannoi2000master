package com.example.nicojack.chenesannoi2000;

import android.content.res.TypedArray;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by peron on 28/04/2017.
 */

public class InterfacciaPrincipale {
    Button r1;
    Button r2;
    Button r3;
    Button r4;
    TextView domanda;
    String[] domande;
    String[] risposte;
    int indice_domanda;
    ImageView immagine;
    TypedArray immagini;
    int contatore = 0;



    InterfacciaPrincipale
            (Button r1, Button r2, Button r3, Button r4, TextView domanda, String[] domande, String[] risposte, ImageView immagine, TypedArray immagini){
            this.r1 = r1;
            this.r2 = r2;
            this.r3 = r3;
            this.r4 = r4;
            this.domanda = domanda;
            this.domande = domande;
            this.risposte = risposte;
            this.immagine = immagine;
            this.immagini = immagini;


    }


    public void inizializzaInterfaccia(){
        final int indice_domanda = (int) (Math.random() * domande.length);
        this.indice_domanda = indice_domanda;
        this.domanda.setText(this.domande[indice_domanda]);
        String[] rispostecorrenti = risposte_correnti(indice_domanda, risposte);
        shuffle(rispostecorrenti);
        inizializzaBottoni();
        this.immagine.setImageResource(immagini.getResourceId(indice_domanda,-1));
        contatore++;
    }

    public String[] risposte_correnti(int i, String[] risposte){
        String[] rispostecorrenti = new String[4];
        for (int n = 0; n < 4; n++){
            rispostecorrenti[n] = risposte[i * 4 + n];
        }
        return rispostecorrenti;
    }

    public void shuffle(String[] risposte_cor){
        for(int i = 0; i < risposte_cor.length - 1; i++){
            int j = (int) (Math.random() * risposte_cor.length);
            String tmp = risposte_cor[i];
            risposte_cor[i] = risposte_cor[j];
            risposte_cor[j] = tmp;
        }
    }

    public void inizializzaBottoni(){
        String[] s = risposte_correnti(this.indice_domanda,this.risposte);
        this.r1.setText(s[0]);
        this.r2.setText(s[1]);
        this.r3.setText(s[2]);
        this.r4.setText(s[3]);
    }

    public boolean controllaRisposta(String risposta_selezionata){
        return risposta_selezionata==risposte[indice_domanda*4];
    }

    public boolean finePartita(){
        return this.contatore > 4;
    }






}
