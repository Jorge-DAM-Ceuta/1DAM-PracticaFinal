package PracticaT7;

import java.util.ArrayList;

public class Armadura extends Equipamiento{
    
    protected String pieza, tipo;
    
    public Armadura(){
        setEEstadistica(new ArrayList <> ());
        nombre="";
        rareza="";
        setEValor(0);
        pieza="";
        tipo="";
    }
    
    public Armadura(ArrayList e, String no, String ra, int va, String pi, String ti){
        estadistica = e;
        
        if(setENombre(no)){
            nombre=no;
        }
        
        if(setERareza(ra)){
            rareza=ra;
        }
        
        valor=0;
        
        if(setEPieza(pi)){
            pieza=pi;
        }
        
        if(setETipo(ti)){
            tipo=ti;
        }
    }

    public Armadura(Armadura other){
        estadistica = new ArrayList <> (other.estadistica);
        nombre=other.nombre;
        rareza=other.rareza;
        valor=other.valor;
        pieza=other.pieza;
        tipo=other.tipo;
    }
    
    public String getEPieza() {
        return pieza;
    }
    
    public boolean setEPieza(String pi) {
        boolean comp=false;
        
        if(pi=="Yelmo"  || pi=="Pechera" || pi=="Hombrera" || pi=="Guantelete" || pi=="Greba" || pi=="Botas"){
            comp=true;
        }
        
        return comp;
        
    }
    
    public String getETipo() {
        return tipo;
    }
    
    public boolean setETipo(String ti) {
        boolean comp=false; 
        
        if(ti=="Tela" ||ti=="Cuero" || ti=="Metal"){
            comp=true;
        }
        
        return comp;
    }
    
    
}
