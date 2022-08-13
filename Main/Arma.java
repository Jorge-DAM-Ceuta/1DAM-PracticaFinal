package PracticaT7;

import java.util.ArrayList;

public class Arma extends Equipamiento{
    
    protected String empunadura, tipo;
    
    public Arma(){
        setEEstadistica(new ArrayList <> ());
        nombre="";
        rareza="";
        setEValor(0);
        empunadura="";
        tipo="";
    }
    
    public Arma(ArrayList e, String no, String ra, int va, String em, String ti){
        estadistica = e;
        
        if(setENombre(no)){
            nombre=no;
        }
        
        if(setERareza(ra)){
            rareza=ra;
        }
        
        valor=0;
        
        if(setEEmpunadura(em)){
            empunadura=em;
        }
        
        if(setETipo(ti)){
            tipo=ti;
        }
    }

    public Arma(Arma other){
        estadistica = new ArrayList <> (other.estadistica);
        nombre=other.nombre;
        rareza=other.rareza;
        valor=other.valor;
        empunadura=other.empunadura;
        tipo=other.tipo;
    }
    
    public String getEEmpunadura() {
        return empunadura;
    }
    
    public boolean setEEmpunadura(String em) {
        boolean comp=false;
        
        if(em=="Una mano" || em=="Dos manos"){
            comp=true;
        }
        
        return comp;
        
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public boolean setETipo(String ti) {
        boolean comp=false;
        
        if(setEEmpunadura("Una mano")){
            if(ti=="Espada" ||ti=="Maza" || ti=="Hacha" ||ti=="Mangual" || ti=="Cetro" || ti=="Daga"){
                comp=true;
            }
        }
        
        if(setEEmpunadura("Dos manos")){
            if(ti=="Espadon" ||ti=="Martillo de guerra" || ti=="Pica" ||ti=="Arco" || ti=="Baston"){
                comp=false;
            }
        }
        
        return comp;
    }
    
    
}
