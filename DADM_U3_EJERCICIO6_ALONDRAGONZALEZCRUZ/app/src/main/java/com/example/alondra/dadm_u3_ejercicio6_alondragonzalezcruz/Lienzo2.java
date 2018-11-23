package com.example.alondra.dadm_u3_ejercicio6_alondragonzalezcruz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {
    Imagen2 n, na, oso, esfera, esferass, aro, despino, desoso, desesfera,desllave;
    Main2Activity puntero;

    public Lienzo2(Context context) {
        super(context);
        puntero = (Main2Activity) context;
        esferass = new Imagen2(R.drawable.esfera, 10, 10, this);
        oso = new Imagen2(R.drawable.oso, 10, 400, this);
        na = new Imagen2(R.drawable.na, 10, 730, this);
        n = new Imagen2(R.drawable.n, 10, 1200, this);
        aro = new Imagen2(R.drawable.aro, 10, 1500, this);
        despino = new Imagen2(R.drawable.despino, 300, 300, this);
        desoso = new Imagen2(R.drawable.desoso, 300, 300, this);
        desesfera = new Imagen2(R.drawable.desesfera, 300, 300, this);
        desllave= new Imagen2(R.drawable.desllave, 300, 300, this);
        despino.hacerVisible(false);
        desoso.hacerVisible(false);
        desesfera.hacerVisible(false);
        desllave.hacerVisible(false);
    }

    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        c.drawColor(Color.DKGRAY);
        esferass.pintar(c, p);
        oso.pintar(c, p);
        na.pintar(c, p);
        n.pintar(c, p);
        despino.pintar(c, p);
        desoso.pintar(c, p);
        desesfera.pintar(c, p);
        desllave.pintar(c,p);
    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX(); //tipo flotante
        float yp = e.getY();
        //cuando precionas,arrastras y cuando sueltas
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (esferass.estaEnArea(xp, yp)) {
                    desesfera.hacerVisible(true);
                    desoso.hacerVisible(false);
                    despino.hacerVisible(false);
                    desllave.hacerVisible(false);

                }
                if (oso.estaEnArea(xp, yp)) {
                    desoso.hacerVisible(true);
                    desesfera.hacerVisible(false);
                    despino.hacerVisible(false);
                    desllave.hacerVisible(false);

                }
                if (na.estaEnArea(xp, yp)) {
                    despino.hacerVisible(true);
                    desoso.hacerVisible(false);
                    desesfera.hacerVisible(false);
                    desllave.hacerVisible(false);

                }
                if (n.estaEnArea(xp, yp)) {
                    desllave.hacerVisible(true);
                    despino.hacerVisible(false);
                    desoso.hacerVisible(false);
                    desesfera.hacerVisible(false);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (esferass.estaEnArea(xp, yp)) {
                    esferass.mover(yp);
                    oso.mover(esferass.getY() + 400);
                    na.mover(oso.getY() + 400);
                    n.mover(na.getY() + 400);
                    aro.mover(n.getY() + 400);
                }
        }
        invalidate();
        return true;
    }
}