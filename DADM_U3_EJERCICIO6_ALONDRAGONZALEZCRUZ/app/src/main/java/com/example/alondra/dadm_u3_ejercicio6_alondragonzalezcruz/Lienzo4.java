package com.example.alondra.dadm_u3_ejercicio6_alondragonzalezcruz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo4 extends View {
    Imagen4 sue,cueroo,chamarra,chaqueta,cuello,dessueter,descuero,descuello,deschaqueta;
    public Lienzo4(Context context) {
        super(context);
        sue= new Imagen4(R.drawable.sue, 10, 10, this);
        cueroo = new Imagen4(R.drawable.cueroo, 10, 400, this);
        chaqueta = new Imagen4(R.drawable.chaqueta, 10, 730, this);
        cuello = new Imagen4(R.drawable.cuello, 10, 1200, this);
        chamarra = new Imagen4(R.drawable.chamarra, 10, 1500, this);
        dessueter = new Imagen4(R.drawable.dessueter, 300, 300, this);
        descuero = new Imagen4(R.drawable.descuero, 300, 300, this);
        deschaqueta = new Imagen4(R.drawable.deschaqueta, 300, 300, this);
        descuello= new Imagen4(R.drawable.descuello, 300, 300, this);
        dessueter.hacerVisible(false);
        descuero.hacerVisible(false);
        deschaqueta.hacerVisible(false);
        descuello.hacerVisible(false);
    }
    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        c.drawColor(Color.DKGRAY);
        sue.pintar(c, p);
        cueroo.pintar(c, p);
        chaqueta.pintar(c, p);
        cuello.pintar(c, p);
        chamarra.pintar(c,p);
        dessueter.pintar(c,p);
        descuero.pintar(c,p);
        deschaqueta.pintar(c,p);
        descuello.pintar(c,p);
    }
    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX(); //tipo flotante
        float yp = e.getY();
        //cuando precionas,arrastras y cuando sueltas
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (sue.estaEnArea(xp, yp)) {
                    dessueter.hacerVisible(true);
                    descuero.hacerVisible(false);
                    deschaqueta.hacerVisible(false);
                    descuello.hacerVisible(false);
                }
                if (cueroo.estaEnArea(xp, yp)) {
                    descuero.hacerVisible(true);
                    dessueter.hacerVisible(false);
                    deschaqueta.hacerVisible(false);
                    descuello.hacerVisible(false);
                }
                if (chaqueta.estaEnArea(xp, yp)) {
                    deschaqueta.hacerVisible(true);
                    descuero.hacerVisible(false);
                    dessueter.hacerVisible(false);
                    descuello.hacerVisible(false);
                }
                if (cuello.estaEnArea(xp, yp)) {
                    descuello.hacerVisible(true);
                    deschaqueta.hacerVisible(false);
                    descuero.hacerVisible(false);
                    dessueter.hacerVisible(false);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (sue.estaEnArea(xp, yp)) {
                    sue.mover(yp);
                    cueroo.mover(sue.getY() + 400);
                    chaqueta.mover(cueroo.getY() + 400);
                    cuello.mover(chaqueta.getY() + 400);
                    chamarra.mover(cuello.getY() + 400);
                }
        }
        invalidate();
        return true;
    }

}
