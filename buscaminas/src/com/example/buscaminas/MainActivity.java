package com.example.buscaminas;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener {
	private tablero fondo;
	int x;
	int y;
	private boolean activo=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        //setContentView(R.layout.activity_main);
        fondo = new tablero(this);
        fondo.setOnTouchListener(this);
        linearLayout1.addView(fondo);
        fondo.casillas = new casilla[8][8];
        for(int f=0;f<8;f++){
        	for(int c=0; c<8;c++){
        		fondo.casillas[f][c]=new casilla();
        	}
        }
        this.disponerBombas();
        this.contarBombasPerimetro();
    }
    public void presionado(View v){
    	fondo.casillas = new casilla[8][8];
        for(int f=0;f<8;f++){
        	for(int c=0; c<8;c++){
        		fondo.casillas[f][c]=new casilla();
        	}
        }
        this.disponerBombas();
        this.contarBombasPerimetro();
        activo = true;
        fondo.invalidate();
    }

    private void contarBombasPerimetro() {
		// TODO Auto-generated method stub
		
	}


	private void disponerBombas() {
		// TODO Auto-generated method stub
		int cantidad=8;
		do{
			int fila=(int) (Math.random()*8);
			int columna=(int)(Math.random()*8);
			if(fondo.casillas[fila][columna].contenido==0){
				fondo.casillas[fila][columna].contenido=80;
				cantidad--;
			}
		}while(cantidad!=0);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if(activo){
			for (int f = 0; f < 8; f++) {
				for (int c = 0; c < 8; c++) {
					if(fondo.casillas[f][c].dentro((int)event.getX() ,(int)event.getY())){
						fondo.casillas[f][c].destapado=true;
						if(fondo.casillas[f][c].contenido==80){
							Toast.makeText(this, "Boooooommm", Toast.LENGTH_LONG).show();
							activo=false;
						}else if(fondo.casillas[f][c].contenido==0){
							recorrer(f,c);
						}
						fondo.invalidate();
					}
				}
			}
		}
		if(gano()&&activo){
			Toast.makeText(this, "Ganaste", Toast.LENGTH_LONG);
			activo=false;
		}
		return false;
	}
	private boolean gano() {
		// TODO Auto-generated method stub
		return false;
	}
	private void recorrer(int f, int c) {
		// TODO Auto-generated method stub
		
	}
    
}
