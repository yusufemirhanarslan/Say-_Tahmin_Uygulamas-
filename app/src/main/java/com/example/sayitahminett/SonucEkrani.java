package com.example.sayitahminett;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sayitahminett.databinding.ActivitySonucEkraniBinding;

public class SonucEkrani extends AppCompatActivity {
    private ActivitySonucEkraniBinding binding;
    private Boolean result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sonuc_ekrani);

        result = getIntent().getBooleanExtra("veri",false);


        if(result){

            binding.imageView2.setImageResource(R.drawable.gulen_yuz);
            binding.textViewSonuc.setText("KAZANDINIZ");

        }else{

            binding.imageView2.setImageResource(R.drawable.uzgun_yuz);
            binding.textViewSonuc.setText("KAYBETTİNİZ");
        }



        binding.buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SonucEkrani.this,OyunEkrani.class);
                startActivity(intent);
                finish();
            }
        });
    }
}