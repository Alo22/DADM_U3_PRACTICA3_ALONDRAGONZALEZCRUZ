package com.example.alondra.dadm_u3_ejercicio6_alondragonzalezcruz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {
    Imagen3 bl,cauyan,abrigo,chamaa,bufanda,deschaleco,dessuda,deschamarra,desabrigo;
    public Lienzo3(Context context) {
        super(context);
        bl= new Imagen3(R.drawable.bl, 10, 10, this);
        cauyan = new Imagen3(R.drawable.cauyan, 10, 400, this);
        abrigo = new Imagen3(R.drawable.abrigo, 10, 730, this);
        chamaa = new Imagen3(R.drawable.chamaa, 10, 1200, this);
        bufanda = new Imagen3(R.drawable.bufanda, 10, 1500, this);
        deschaleco = new Imagen3(R.drawable.deschaleco, 300, 300, this);
        dessuda = new Imagen3(R.drawable.dessuda, 300, 300, this);
        desabrigo = new Imagen3(R.drawable.desabrigo, 300, 300, this);
        deschamarra=new Imagen3(R.drawable.deschamarra,300,300,this);
        deschaleco.hacerVisible(false);
        dessuda.hacerVisible(false);
        desabrigo.hacerVisible(false);
        deschamarra.hacerVisible(false);
    }
    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        c.drawColor(Color.DKGRAY);
        bl.pintar(c, p);
        cauyan.pintar(c, p);
        abrigo.pintar(c, p);
        chamaa.pintar(c, p);
        bufanda.pintar(c,p);
        deschaleco.pintar(c,p);
        dessuda.pintar(c,p);
        desabrigo.pintar(c,p);
        deschamarra.pintar(c,p);
    }
    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX(); //tipo flotante
        float yp = e.getY();
        //cuando precionas,arrastras y cuando sueltas
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (bl.estaEnArea(xp, yp)) {
                    deschaleco.hacerVisible(true);
                    dessuda.hacerVisible(false);
                    desabrigo.hacerVisible(false);
                    deschamarra.hacerVisible(false);
                }
                if (cauyan.estaEnArea(xp, yp)) {
                    dessuda.hacerVisible(true);
                    deschaleco.hacerVisible(false);
                    desabrigo.hacerVisible(false);
                    deschamarra.hacerVisible(false);
                }
                if (abrigo.estaEnArea(xp, yp)) {
                    desabrigo.hacerVisible(true);
                    dessuda.hacerVisible(false);
                    deschaleco.hacerVisible(false);
                    deschamarra.hacerVisible(false);
                }
                if (chamaa.estaEnArea(xp, yp)) {
                    deschamarra.hacerVisible(true);
                    desabrigo.hacerVisible(false);
                    dessuda.hacerVisible(false);
                    deschaleco.hacerVisible(false);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (bl.estaEnArea(xp, yp)) {
                    bl.mover(yp);
                    cauyan.mover(bl.getY() + 400);
                    abrigo.mover(cauyan.getY() + 400);
                    chamaa.mover(abrigo.getY() + 400);
                    bufanda.mover(chamaa.getY() + 400);
                }
        }
        invalidate();
        return true;
    }

}
