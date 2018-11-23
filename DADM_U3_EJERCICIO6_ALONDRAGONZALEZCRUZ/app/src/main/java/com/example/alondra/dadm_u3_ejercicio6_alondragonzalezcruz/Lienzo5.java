package com.example.alondra.dadm_u3_ejercicio6_alondragonzalezcruz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo5 extends View {
    Imagen5 nuu,nina,gorro,traje,nini,desnina,despans,desch,desgo;
    public Lienzo5(Context context) {
        super(context);
        nuu= new Imagen5(R.drawable.nuu, 10, 10, this);
        gorro = new Imagen5(R.drawable.gorro, 10, 400, this);
        traje = new Imagen5(R.drawable.traje, 10, 730, this);
        nina = new Imagen5(R.drawable.nina, 10, 1200, this);
        nini = new Imagen5(R.drawable.nii, 10, 1500, this);
        desnina = new Imagen5(R.drawable.desnina, 300, 300, this);
        despans = new Imagen5(R.drawable.despans, 300, 300, this);
        desch = new Imagen5(R.drawable.desch, 300, 300, this);
        desgo=new Imagen5(R.drawable.desgo,300,300,this);
        desnina.hacerVisible(false);
        despans.hacerVisible(false);
        desch.hacerVisible(false);
        desgo.hacerVisible(false);
    }
    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        c.drawColor(Color.DKGRAY);
        nuu.pintar(c, p);
        gorro.pintar(c, p);
        traje.pintar(c, p);
        nina.pintar(c, p);
        nini.pintar(c,p);
        desnina.pintar(c,p);
        despans.pintar(c,p);
        desgo.pintar(c,p);
        desch.pintar(c,p);
    }
    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX(); //tipo flotante
        float yp = e.getY();
        //cuando precionas,arrastras y cuando sueltas
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (nuu.estaEnArea(xp, yp)) {
                    desch.hacerVisible(true);
                    desgo.hacerVisible(false);
                    desnina.hacerVisible(false);
                    despans.hacerVisible(false);

                }
                if(gorro.estaEnArea(xp,yp)){
                    desgo.hacerVisible(true);
                    desnina.hacerVisible(false);
                    despans.hacerVisible(false);
                    desch.hacerVisible(false);
                }
                if(traje.estaEnArea(xp,yp)){
                    despans.hacerVisible(true);
                    desgo.hacerVisible(false);
                    desnina.hacerVisible(false);
                    desch.hacerVisible(false);
                }
                if (nina.estaEnArea(xp,yp)){
                    desnina.hacerVisible(true);
                    despans.hacerVisible(false);
                    desgo.hacerVisible(false);
                    desch.hacerVisible(false);

                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (nuu.estaEnArea(xp, yp)) {
                    nuu.mover(yp);
                    gorro.mover(nuu.getY() + 400);
                    traje.mover(gorro.getY() + 400);
                    nina.mover(traje.getY() + 400);
                    nini.mover(nina.getY() + 400);
                }
        }
        invalidate();
        return true;
    }
}
