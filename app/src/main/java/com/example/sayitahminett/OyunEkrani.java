package com.example.sayitahminett;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sayitahminett.databinding.ActivityMainBinding;
import com.example.sayitahminett.databinding.ActivityOyunEkraniBinding;

import java.util.Random;

public class OyunEkrani extends AppCompatActivity {
    private ActivityOyunEkraniBinding binding;
    private int count = 5;
    private int cameNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_oyun_ekrani);

        Random r = new Random();
        int number = r.nextInt(101);

        Log.e("Rastgele gelen sayı: ",String.valueOf(number));
        binding.buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count-=1;

               cameNumber = Integer.parseInt(binding.editTextTextGelenVeri.getText().toString());

                if(cameNumber > number){

                    binding.textViewYardM.setText("AZALT");
                    binding.textViewKalanHak.setText("Kalan Hak: "+count);

                }else if( cameNumber < number){
                    binding.textViewYardM.setText("ARTTIR");
                    binding.textViewKalanHak.setText("Kalan Hak: "+count);

                }else  if(cameNumber == number){

                    Intent intent = new Intent(OyunEkrani.this,SonucEkrani.class);

                    intent.putExtra("veri",true);
                    startActivity(intent);
                    finish();
                    return;
                }
                if(count == 0){

                    Intent intent = new Intent(OyunEkrani.this,SonucEkrani.class);

                    intent.putExtra("veri",false);
                    startActivity(intent);
                    finish();
                }

                binding.editTextTextGelenVeri.setText("");
            }
        });
    }
}