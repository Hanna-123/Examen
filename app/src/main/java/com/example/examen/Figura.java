package com.example.examen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class Figura extends View {
        Paint paint = new Paint();
        Paint p;
        int s = -1;
        int centerX, centerY, maxX, maxY, minMaxXY;
        Obj obj;
        double X,Y;
        String figura;
        int [][] n_lados = new int [3][3];
        public Figura(Context c, int n_lad[][]){
                super(c);
                n_lados = n_lad;
                obj = new Obj(n_lados);
                paint = new Paint();
                paint.setColor(Color.BLACK);
                centerY = 865;

                centerX = 540;

        }
        int iX (double x){ return (int) (centerX + x); }
        int iY(double y){ return (int) (centerY - y);}
        void line(Canvas c, int i, int j){
                Point2D p = obj.vScr[i], q = obj.vScr[j];
                c.drawLine(iX(p.x), iY(p.y),iX(q.x), iY(q.y), paint);
        }
        protected void onDraw(Canvas can){
                can.drawColor(Color.WHITE);
                maxX = getWidth()-1;
                maxY = getHeight()-1;
                minMaxXY = Math.min(maxX, maxY);
                obj.d = obj.rho*minMaxXY/obj.objSize;
                obj.eyeAndScreen();

                int n_lados = 3;
                for ( int i = 0; i< n_lados-1; i++ ){
                        line(can, i , i+1);
                        line(can, i , n_lados);

                }
                line(can, n_lados-1, 0);
                line(can, n_lados-1 , n_lados);
                int x,y;
                ////////////////
                p = new Paint(); // Paint asigna atributos
                x = can.getWidth(); // También: getMeasuredWidth() o getRight(), x=480
                y = can.getHeight(); // También: getMeasuredHeight() o getBottom(), y=762
                //Log.i("Figura.java", "Centro"+y/2);
                p.setColor(Color.rgb(0, 0, 255)); // Ejes azules
                can.drawLine(x/2, 0, x/2, y, p);
                can.drawLine(0, y/2, x, y/2, p);
                /////////////////////

        }
        public boolean onTouchEvent(MotionEvent me){
                if(me.getAction() == MotionEvent.ACTION_DOWN){
                        s = -1;
                        X = me.getX();
                        Y = me.getY();

                        for(int i = 0; i < 2; i++){
                                double dx = X-centerX, dy = Y - centerY;
                                double d = (double) Math.sqrt(dx*dx + dy*dy);

                                if(d <= 75){
                                        s = i;
                                        invalidate();
                                }
                        }
                }
                if(me.getAction() == MotionEvent.ACTION_MOVE){
                        if(s > -1){
                                centerX = (int) me.getX();
                                centerY = (int) me.getY();
                                invalidate();
                        }
                }
                if(me.getX() < X) obj.theta = (double) (obj.theta - 2*Math.PI/300);
                if(me.getX() > X) obj.theta = (double) (obj.theta + 2*Math.PI/300);
                if(me.getX() < Y) obj.phi = (double) (obj.phi - 2*Math.PI/400);
                if(me.getX() > Y) obj.phi = (double) (obj.phi + 2*Math.PI/400);
                invalidate();
                return true;
        }
}
