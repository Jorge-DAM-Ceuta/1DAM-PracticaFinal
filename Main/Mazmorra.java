package PracticaT7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;


public class Mazmorra {
    
    private String nombreMazmorra;
    private HashSet <Monstruo> monstruos;
    private int nivelPromedio;
    
    
    public Mazmorra(){
        nombreMazmorra = "";
        monstruos = new HashSet <Monstruo>();
        nivelPromedio = 0;
    }
    
    public Mazmorra(File f){
        try{
            FileReader fr = new FileReader (f);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            String datos [] = new String [2]; 
            
            br.readLine();
            datos = linea.split(",");
            
            nombreMazmorra = datos[0]; 
            nivelPromedio = Integer.parseInt(datos[1]); 
            
            while((linea=br.readLine())!=null){
                datos = linea.split(",");
                Monstruo m = new Monstruo(datos[1], datos[0], nivelPromedio+3+(-((int)Math.random()*6))); 
                monstruos = new HashSet <Monstruo>();
                monstruos.add(m);
            }
            
            br.close();
            fr.close();
        
        }catch(IOException error){
            System.out.println(error);
        }
    }
    
    public Mazmorra(Mazmorra other){
        nombreMazmorra = other.nombreMazmorra;
        monstruos = new HashSet <Monstruo>(other.monstruos);
        nivelPromedio = other.nivelPromedio;
    }

    public String getNombreMazmorra() {
        return nombreMazmorra;
    }

    public void setNombreMazmorra(String nombreMazmorra) {
        this.nombreMazmorra = nombreMazmorra;
    }

    public HashSet <Monstruo> getMonstruos() {
        return monstruos;
    }

    public void setMonstruos(HashSet <Monstruo> monstruos) {
        this.monstruos = monstruos;
    }

    public int getNivelPromedio() {
        return nivelPromedio;
    }

    public void setNivelPromedio(int nivelPromedio) {
        this.nivelPromedio = nivelPromedio;
    }
    
    public Monstruo combateAleatorio(){
        Iterator <Monstruo> itr = monstruos.iterator();
        return itr.next();
    }
    
    public String toString(){
        return "La Mazmorra " + getNombreMazmorra() + " es de nivel " + getNivelPromedio() + "\n" + "En ella se encuentran los siguientes Monstruos: " + getMonstruos();
    }
}
