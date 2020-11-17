package com.example.examen;

import android.util.Log;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Obj {
    double rho, theta=0.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D [] w;	// coordenadas universales
    Point2D [] vScr; // coordenadas de la pantalla
    int[][] n_lados=new int[3][3];

    Obj( int lados[][]){
        n_lados = lados;



        w	= new Point3D[4];
        vScr	= new Point2D[4];

        //Cubo
        w[0]	= new Point3D(0, 0, 0); // desde la base
        w[1]	= new Point3D(n_lados[0][0]/2, n_lados[0][1]/2, n_lados[0][2]/2);
        w[2]	= new Point3D(n_lados[1][0]/2, n_lados[1][1]/2, n_lados[1][2]/2);
        //w[3]	= new Point3D(-1, -1, -1);
        w[3]	= new Point3D(n_lados[2][0]/2, n_lados[2][1]/2, n_lados[2][2]/2);
        //w[4]	= new Point3D(0, 0, 1);
        //w[5]	= new Point3D(0, 0, 1);
        //w[7]	= new Point3D(0, 0, 1);
        objSize = (float) Math.sqrt(20F);

        rho = 5*objSize;
    }
    void initPersp(){
        float costh = (float) cos(theta), sinth=(float)Math.sin(theta), cosph=(float) cos(phi), sinph=(float)Math.sin(phi);
        v11 = -sinth; v12 = -cosph*costh; v13 = sinph*costh;
        v21 = costh; v22 = -cosph*sinth; v23 = sinph*sinth;
        v32 = sinph; v33 = cosph; v43 = -rho;
    }
    void eyeAndScreen(){
        initPersp();
        int numero_vertices = 4;

        for(int i =0; i < numero_vertices; i++){
            Point3D p = w[i];
            double x = v11*p.x + v21*p.y;
            double y = v12*p.x + v22*p.y + v32*p.z;
            double z = v13*p.x + v23*p.y + v33*p.z + v43;

            vScr[i] = new Point2D(-d*x/z, -d*y/z);
        }
    }
}
