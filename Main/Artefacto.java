package PracticaT7;

import java.util.ArrayList;


public class Artefacto extends Equipamiento{
    
    protected String tipo;
            
    public Artefacto(){
        setEEstadistica(new ArrayList <> ());
        nombre="";
        rareza="";
        setEValor(0);
        tipo="";
    }
    
    public Artefacto(ArrayList e, String no, String ra, double va, String ti){
        estadistica = e;
        
        if(setENombre(no)){
            nombre=no;
        }
        
        if(setERareza(ra)){
            rareza=ra;
        }
        
        valor=0;
        
        if(setETipo(ti)){
            tipo=ti;
        }
    }

    public Artefacto(Artefacto other){
        estadistica = new ArrayList <> (other.estadistica);
        nombre=other.nombre;
        rareza=other.rareza;
        valor=other.valor;
    }
    
    public String getETipo() {
        return tipo;
    }
    
    public boolean setETipo(String ti) {
        boolean comp=false;
        
        if(ti=="Anillo" ||ti=="Amuleto"){
            comp=true;
        }
        
        return comp;
    }
}
