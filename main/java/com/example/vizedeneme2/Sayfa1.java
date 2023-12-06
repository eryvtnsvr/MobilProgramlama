package com.example.vizedeneme2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Sayfa1 extends AppCompatActivity {
    EditText girilenSayi, girilenDerece;
    Spinner seceneklerSpinner, dereceSpinner;
    Button cevirButton, dereceButton, anasayfaButton;
    TextView cevirmeSonucu, derecesonucu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sayfa1);
        girilenSayi = findViewById(R.id.girilen_sayi);
        seceneklerSpinner = findViewById(R.id.spinner);
        cevirButton = findViewById(R.id.cevirmebutonu);
        anasayfaButton = findViewById(R.id.anasayfa);
        cevirmeSonucu = findViewById(R.id.somucText);
        girilenDerece = findViewById(R.id.girilen_derece);
        dereceSpinner = findViewById(R.id.spinner2);
        dereceButton = findViewById(R.id.derecebutonu);
        derecesonucu = findViewById(R.id.derece_sonucu);




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.secenekler, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seceneklerSpinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.secenekler2, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dereceSpinner.setAdapter(adapter2);

        cevirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cevirmeIslemi();
            }
        });
        dereceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dereceIslemi();
            }
        });

        anasayfaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void cevirmeIslemi(){
        String sayiStr = girilenSayi.getText().toString().trim();
        int sayi = Integer.parseInt(sayiStr);
        String secilen = seceneklerSpinner.getSelectedItem().toString();
        String sonuc = "";
        if (secilen.equals("ikilik")){
            sonuc= Integer.toBinaryString(sayi);
        }
        else if(secilen.equals("sekizlik")){
            sonuc = Integer.toOctalString(sayi);
        }
        else if(secilen.equals("onaltılık")){
            sonuc = Integer.toHexString(sayi);
        }
        cevirmeSonucu.setText("Sonuç : "+ sonuc);
    }
    private void dereceIslemi(){
        String sayiStr2 = girilenDerece.getText().toString().trim();
        int sayi2 = Integer.parseInt(sayiStr2);
        String secilen2 = dereceSpinner.getSelectedItem().toString();
        float sonuc2 =0;
        if(secilen2.equals("fahrenayt")){
            sonuc2 = (sayi2*(9/5)+32);
        }
        else if(secilen2.equals("kelvin")){
            sonuc2 = sayi2 + 273;
        }
        derecesonucu.setText("Sonuç :"+ sonuc2);
    }
}
