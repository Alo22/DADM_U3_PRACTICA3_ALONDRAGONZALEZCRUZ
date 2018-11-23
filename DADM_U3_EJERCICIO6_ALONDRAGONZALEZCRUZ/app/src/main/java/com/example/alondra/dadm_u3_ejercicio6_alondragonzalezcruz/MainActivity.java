package com.example.alondra.dadm_u3_ejercicio6_alondragonzalezcruz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));
    }
    public void categoria() {
        Intent a = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(a);

    }
    public void categoria2() {
        Intent e = new Intent(MainActivity.this, Main3Activity.class);
        startActivity(e);

    }
    public void categoria3() {
        Intent i = new Intent(MainActivity.this, Main4Activity.class);
        startActivity(i);

    }
    public void categoria4() {
        Intent i = new Intent(MainActivity.this, Main5Activity.class);
        startActivity(i);

    }
}
