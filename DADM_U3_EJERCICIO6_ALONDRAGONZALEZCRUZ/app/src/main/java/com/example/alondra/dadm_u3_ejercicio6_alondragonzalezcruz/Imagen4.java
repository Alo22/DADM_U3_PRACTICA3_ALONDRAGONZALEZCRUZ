package com.example.alondra.dadm_u3_ejercicio6_alondragonzalezcruz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Imagen4 {
    private Bitmap icono;
    private float x, y;
    private boolean visible;

    public Imagen4(int resource, float _x, float _y, Lienzo4 l) { //se recibre un 4 parametro de lienzo
        icono = BitmapFactory.decodeResource(l.getResources(), resource);
        x = _x;
        y=_y;
        visible=true;
    } //imagen

    public void pintar(Canvas c, Paint p) {
        if(visible)
            c.drawBitmap(icono, x, y, p);
    }//metodo pintar
    public void hacerVisible(boolean v){
        visible=v;
    }
    public void mover(float yp) {
        y = yp - (icono.getWidth() / 2);
        //y = yp - (icono.getHeight() / 2);
    }
    public float getY(){
        return y;
    }

    public boolean estaEnArea(float xp, float yp) {
        if(!visible) return false;
        float x2, y2;
        x2 = x + icono.getWidth();
        y2 = y + icono.getHeight();
        if (yp >= y && xp <= x2) {
            // validando el valor de las x
            return true;
        } //del toquen
        return false; //retornara verdadero si ambos if son SI
    }

}
