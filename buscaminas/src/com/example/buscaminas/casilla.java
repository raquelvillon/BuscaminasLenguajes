package com.example.buscaminas;

public class casilla {
	public int x;
	public int y;
	public int ancho;
	public int contenido = 0;
	public boolean destapado=false; 
	public void fijarXY(int x, int y, int ancho ){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
	}
	public boolean dentro(int xx, int yy){
		if(xx>=this.x && xx<= this.x+ancho && yy>=this.y && yy<=this.y+ancho){
			return true;
		}else{
			return false;
		}
	}
	
}
