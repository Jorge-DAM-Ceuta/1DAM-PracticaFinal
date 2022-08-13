package PracticaT7;

import java.util.ArrayList;

public abstract class Equipamiento {
    
    protected String nombre, rareza;
    protected int valor;
    protected ArrayList <Integer> estadistica;
    
    public Equipamiento(){
        estadistica = new ArrayList <> ();
        nombre="";
        rareza="";
        valor=0;
    }
    
    public Equipamiento(ArrayList e, String no, String ra, int va){
        estadistica = e;
        
        if(setENombre(no)){
            nombre=no;
        }
        
        if(setERareza(ra)){
            rareza=ra;
        }
        
        valor=0;
    }

    public Equipamiento(Equipamiento other){
        estadistica = new ArrayList <> (other.estadistica);
        nombre=other.nombre;
        rareza=other.rareza;
        valor=other.valor;
    }
    
    public String getENombre() {
        return nombre;
    }

    public boolean setENombre(String no) {
        boolean comp=false;
        
        if(no.length()<=20){
            comp=true;
        }
        
        return comp;
    }

    public String getERareza() {
        return rareza;
    }

    public boolean setERareza(String ra) {
        boolean comp=false;
        
        if(ra=="comun" || ra=="raro" || ra=="epico" || ra=="comun"){
            comp=true;
        }
        
        return comp;
    }

    public int getEValor() {
        return valor;
    }

    public void setEValor(int valor) {
        this.valor = valor;
    }
    
    public ArrayList getEEstadistica() {
        return estadistica;
    }

    public void setEEstadistica(ArrayList es) {
        estadistica=es;
    }
    
    public String toString(){
        return "El personaje obtiene sus estadisticas " + estadistica + " del equipamiento. " + getENombre() + "\nCuyo valor es " + getEValor() + " y su rareza " + getERareza();
    }
    
    public boolean equals(Equipamiento other){
        boolean comp=false;
        
        if(getENombre()==other.getENombre()){
            if(getERareza()==other.getERareza()){
                if(getEValor()==other.getEValor()){
                    if(getEEstadistica()==other.getEEstadistica()){
                        comp=true;
                    }
                }
            }
        }
        
        return comp;
    }
    
    
}
