package com.example.alondra.dadm_u3_ejercicio6_alondragonzalezcruz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Imagen moda, logom, esfera, cuero, chama, ninoo, bebaa, des, dess, desss, dessss, bebe, entrar,entrar2,entrar3,entrar4;
    MainActivity puntero;

    public Lienzo(Context context) {
        super(context);
        puntero = (MainActivity) context;
        logom = new Imagen(R.drawable.logom, 20, 20, this);
        moda = new Imagen(R.drawable.moda, 200, 40, this);
        esfera = new Imagen(R.drawable.esfera, 20, 180, this);
        chama = new Imagen(R.drawable.chama, 280, 180, this);
        cuero = new Imagen(R.drawable.cuero, 540, 180, this);
        ninoo = new Imagen(R.drawable.ninoo, 820, 180, this);
        bebaa = new Imagen(R.drawable.bebaa, 1080, 180, this);
        des = new Imagen(R.drawable.des, 20, 600, this);
        dess = new Imagen(R.drawable.dess, 20, 600, this);
        desss = new Imagen(R.drawable.desss, 20, 600, this);
        dessss = new Imagen(R.drawable.dessss, 20, 600, this);
        bebe = new Imagen(R.drawable.bebe, 20, 600, this);
        entrar = new Imagen(R.drawable.entrar, 480, 880, this);
        entrar2 = new Imagen(R.drawable.entrar2, 480, 880, this);
        entrar3 = new Imagen(R.drawable.entrar3, 480, 880, this);
        entrar4 = new Imagen(R.drawable.entrar4, 480, 880, this);
        des.hacerVisible(false);
        dess.hacerVisible(false);
        desss.hacerVisible(false);
        dessss.hacerVisible(false);
        bebe.hacerVisible(false);
        entrar.hacerVisible(false);
        entrar2.hacerVisible(false);
        entrar3.hacerVisible(false);
        entrar4.hacerVisible(false);
    }

    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        c.drawColor(Color.DKGRAY);
        logom.pintar(c, p);
        moda.pintar(c, p);
        esfera.pintar(c, p);
        chama.pintar(c, p);
        cuero.pintar(c, p);
        ninoo.pintar(c, p);
        bebaa.pintar(c, p);
        des.pintar(c, p);
        dess.pintar(c, p);
        desss.pintar(c, p);
        dessss.pintar(c, p);
        bebe.pintar(c, p);
        entrar.pintar(c, p);
        entrar2.pintar(c,p);
        entrar3.pintar(c,p);
        entrar4.pintar(c,p);
    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX(); //tipo flotante
        float yp = e.getY();
        //cuando precionas,arrastras y cuando sueltas
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (entrar.estaEnArea(xp, yp)) {
                    puntero.categoria();
                }
                if(entrar2.estaEnArea(xp,yp)){
                    puntero.categoria2();
                }
                if(entrar3.estaEnArea(xp,yp)){
                    puntero.categoria3();
                }
                if(entrar4.estaEnArea(xp,yp)){
                    puntero.categoria4();
                }

                if (esfera.estaEnArea(xp, yp)) {
                    des.hacerVisible(true);
                    dess.hacerVisible(false);
                    desss.hacerVisible(false);
                    dessss.hacerVisible(false);
                    entrar2.hacerVisible(false);
                    entrar.hacerVisible(true);
                    entrar3.hacerVisible(false);
                    entrar4.hacerVisible(false);
                    break;
                }

                if (chama.estaEnArea(xp, yp)) {
                    dess.hacerVisible(true);
                    des.hacerVisible(false);
                    desss.hacerVisible(false);
                    dessss.hacerVisible(false);
                    entrar.hacerVisible(false);
                    entrar2.hacerVisible(true);
                    entrar3.hacerVisible(false);
                    entrar4.hacerVisible(false);
                    break;
                }
                if (cuero.estaEnArea(xp, yp)) {
                    desss.hacerVisible(true);
                    des.hacerVisible(false);
                    dess.hacerVisible(false);
                    dessss.hacerVisible(false);
                    entrar.hacerVisible(false);
                    entrar2.hacerVisible(false);
                    entrar3.hacerVisible(true);
                    entrar4.hacerVisible(false);
                    break;
                }
                if (ninoo.estaEnArea(xp, yp)) {
                    dessss.hacerVisible(true);
                    desss.hacerVisible(false);
                    des.hacerVisible(false);
                    dess.hacerVisible(false);
                    entrar4.hacerVisible(true);
                    entrar.hacerVisible(false);
                    entrar2.hacerVisible(false);
                    entrar3.hacerVisible(false);
                    break;
                }
                if (bebaa.estaEnArea(xp, yp)) {
                    bebe.hacerVisible(true);
                    dessss.hacerVisible(false);
                    desss.hacerVisible(false);
                    des.hacerVisible(false);
                    dess.hacerVisible(false);
                    break;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (esfera.estaEnArea(xp, yp)) {
                    esfera.mover(xp);
                    chama.mover(esfera.getX()+340);
                    cuero.mover(chama.getX()+340);
                    ninoo.mover(cuero.getX()+340);
                    bebaa.mover(ninoo.getX()+340);
                }
        }
        invalidate();
        return true;
    }
}
