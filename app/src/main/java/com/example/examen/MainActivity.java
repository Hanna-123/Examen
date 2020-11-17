package com.example.examen;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends Activity{
    Button jbnEnviar, jbnVolumen;
    TextView jtv;
    EditText jetx1, jety1, jetz1, jetx2, jety2,jetz2, jetx3, jety3, jetz3;


    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        jetx1 = (EditText) findViewById(R.id.xetx1);
        jety1 = (EditText) findViewById(R.id.xety1);
        jetz1 = (EditText) findViewById(R.id.xetz1);
        jetx2 = (EditText) findViewById(R.id.xetx2);
        jety2 = (EditText) findViewById(R.id.xety2);
        jetz2 = (EditText) findViewById(R.id.xetz2);
        jetx3 = (EditText) findViewById(R.id.xetx3);
        jety3 = (EditText) findViewById(R.id.xety3);
        jetz3 = (EditText) findViewById(R.id.xetz3);
        jbnEnviar = (Button) findViewById(R.id.xbtEnviar);
        jbnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(MainActivity.this, FiguraActivity.class);
                Bundle bu = new Bundle();
                bu.putInt("X1", Integer.parseInt(jetx1.getText().toString()));
                bu.putInt("X2", Integer.parseInt(jetx2.getText().toString()));
                bu.putInt("X3", Integer.parseInt(jetx3.getText().toString()));
                bu.putInt("Y1", Integer.parseInt(jety1.getText().toString()));
                bu.putInt("Y2", Integer.parseInt(jety2.getText().toString()));
                bu.putInt("Y3", Integer.parseInt(jety3.getText().toString()));
                bu.putInt("Z1", Integer.parseInt(jetz1.getText().toString()));
                bu.putInt("Z2", Integer.parseInt(jetz2.getText().toString()));
                bu.putInt("Z3", Integer.parseInt(jetz3.getText().toString()));
                in.putExtras(bu);
                startActivity(in);

            }
        });
        jbnVolumen = (Button) findViewById(R.id.xbtVolumen);
        jtv = (TextView) findViewById(R.id.xtvVolumen);
        jbnVolumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int [][] matriz = new int [3][3];
                int det = 0;
                matriz[0][0] = Integer.parseInt(jetx1.getText().toString());
                matriz[1][0] = Integer.parseInt(jetx2.getText().toString());
                matriz[2][0] = Integer.parseInt(jetx3.getText().toString());
                matriz[0][1] = Integer.parseInt(jety1.getText().toString());
                matriz[1][1] = Integer.parseInt(jety2.getText().toString());
                matriz[2][1] = Integer.parseInt(jety3.getText().toString());
                matriz[0][2] = Integer.parseInt(jetz1.getText().toString());
                matriz[1][2] = Integer.parseInt(jetz2.getText().toString());
                matriz[2][2] = Integer.parseInt(jetz3.getText().toString());
                if(jtv.getText() != "")
                    jtv.setText("");
                det = determinante(matriz);
                jtv.append(det+""+"u3");
            }
        });

    }
    static public int determinante(int matriz[][]){
        int det = 0;
        det=((matriz[0][0])*(matriz[1][1])*(matriz[2][2])+(matriz[1][0])*(matriz[2][1])*(matriz[0][2])+
                (matriz[2][0])*(matriz[0][1])*(matriz[1][2]))-((matriz[2][0])*(matriz[1][1])*(matriz[0][2])+
                (matriz[1][0])*(matriz[0][1])*(matriz[2][2])+(matriz[0][0])*(matriz[2][1])*(matriz[1][2]));
        return det;
    }


}