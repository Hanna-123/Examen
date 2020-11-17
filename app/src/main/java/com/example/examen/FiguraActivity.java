package com.example.examen;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class FiguraActivity extends Activity {
    Figura f;

    public void onCreate(Bundle b) {
        super.onCreate(b);

        Figura f;
        Bundle bn = this.getIntent().getExtras();
        int [][] matriz = new int [3][3];
        matriz[0][0] = bn.getInt("X1");
        matriz[1][0] = bn.getInt("X2");
        matriz[2][0] = bn.getInt("X3");
        matriz[0][1] = bn.getInt("Y1");
        matriz[1][1] = bn.getInt("Y2");
        matriz[2][1] = bn.getInt("Y3");
        matriz[0][2] = bn.getInt("Z1");
        matriz[1][2] = bn.getInt("Z2");
        matriz[2][2] = bn.getInt("Z3");

        f = new Figura(this, matriz);
        setContentView(f);
    }

}
